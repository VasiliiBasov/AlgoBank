package ru.algobank.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.algobank.entity.Account;
import ru.algobank.exception.AccountNotFoundException;
import ru.algobank.exception.InsufficientFundsException;
import ru.algobank.repository.AccountRepository;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(Long fromId, Long toId, long amount) {
        Account from = accountRepository.findById(fromId)
                .orElseThrow(() -> new AccountNotFoundException("счёт отправителя не найден: id=" + fromId));
        Account to = accountRepository.findById(toId)
                .orElseThrow(() -> new AccountNotFoundException("счёт получателя не найден: id=" + toId));

        if (accountRepository.debit(fromId, amount) == 0) {
            throw new InsufficientFundsException("id счёта: " + fromId +
                    " Попытка списания: " + amount + " валюты.");
        }
        if (accountRepository.credit(toId, amount) == 0) {
            throw new InsufficientFundsException("id счёта: " + toId +
                    " Попытка зачисления: " + amount + " валюты.");
        }
    }
}
