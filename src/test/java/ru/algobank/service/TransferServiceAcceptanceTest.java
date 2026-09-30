package ru.algobank.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.algobank.entity.Account;
import ru.algobank.exception.AccountNotFoundException;
import ru.algobank.exception.InsufficientFundsException;
import ru.algobank.repository.AccountRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Шаг 8 · 8B ПРИЁМКА: атомарность денежного перевода на РЕАЛЬНОМ PostgreSQL (Testcontainers).
 * Контракт (ТЗ 8B в LEARNING_LOG, запись 30.09.2026): ru.algobank.service.TransferService#transfer
 * (Long fromId, Long toId, long amountMinor) — списание и начисление атомарны:
 * сбой после списания откатывает списание; движения фиксируются записями в transactions.
 *
 * Красный до реализации ученика как в sqldrills (упадёт на компиляции — TransferService нет).
 * Требует docker-демон; если Docker недоступен — класс скипается (disabledWithoutDocker),
 * «вечно зелёный» общий прогон не страдает.
 */
@Testcontainers(disabledWithoutDocker = true)
@SpringBootTest
class TransferServiceAcceptanceTest {

    @Container
    static final PostgreSQLContainer<?> POSTGRES =
            new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void datasource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES::getUsername);
        registry.add("spring.datasource.password", POSTGRES::getPassword);
    }

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountRepository accountRepository;

    @PersistenceContext
    private EntityManager em;

    private Account newAccount(String owner, long balanceMinor) {
        Account a = new Account();
        a.setOwnerName(owner);
        a.setBalanceMinor(balanceMinor);
        return accountRepository.save(a);
    }

    private long balanceOf(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow().getBalanceMinor();
    }

    private long movementCount(Long accountId) {
        return em.createQuery(
                        "select count(t) from Transaction t where t.account.id = :id", Long.class)
                .setParameter("id", accountId)
                .getSingleResult();
    }

    @Test
    void happyPath_movesMoney_andWritesTwoMovements() {
        Account from = newAccount("8B Отправитель", 150_000);
        Account to = newAccount("8B Получатель", 0);

        transferService.transfer(from.getId(), to.getId(), 45_000);

        assertEquals(105_000, balanceOf(from.getId()));
        assertEquals(45_000, balanceOf(to.getId()));
        // движения: -45_000 на отправителе, +45_000 на получателе
        assertEquals(1, movementCount(from.getId()));
        assertEquals(1, movementCount(to.getId()));
    }

    @Test
    void recipientMissing_afterDebit_senderBalanceRolledBack() {
        Account from = newAccount("8B Откат", 100_000);

        assertThrows(AccountNotFoundException.class,
                () -> transferService.transfer(from.getId(), 999_999L, 10_000));

        // гвоздь 8B: списание с from выполнилось раньше броска — и ОТКАТИЛОСЬ
        assertEquals(100_000, balanceOf(from.getId()));
        assertEquals(0, movementCount(from.getId()));
    }

    @Test
    void insufficientFunds_rejected_bothBalancesIntact() {
        Account from = newAccount("8B Бедный", 5_000);
        Account to = newAccount("8B Богатый", 0);

        assertThrows(InsufficientFundsException.class,
                () -> transferService.transfer(from.getId(), to.getId(), 50_000));

        assertEquals(5_000, balanceOf(from.getId()));
        assertEquals(0, balanceOf(to.getId()));
    }

    @Test
    void sameAccount_rejected() {
        Account a = newAccount("8B Сам-себе", 10_000);

        assertThrows(IllegalArgumentException.class,
                () -> transferService.transfer(a.getId(), a.getId(), 1_000));

        assertEquals(10_000, balanceOf(a.getId()));
    }
}
