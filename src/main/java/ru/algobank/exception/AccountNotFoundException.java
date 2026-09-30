package ru.algobank.exception;

/**
 * 8B: счёт не найден. ЗАГЛУШКА ментора под контракт TransferServiceAcceptanceTest —
 * при реализации 8B ученик может расширить (напр., хранить id счёта). См. ТЗ 8B в LEARNING_LOG (30.09).
 */
public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}
