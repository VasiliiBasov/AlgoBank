package ru.algobank.exception;

/**
 * 8B: недостаточно средств для списания. ЗАГЛУШКА ментора под контракт TransferServiceAcceptanceTest —
 * при реализации 8B ученик может расширить (напр., хранить требуемую/доступную сумму). См. ТЗ 8B в LEARNING_LOG (30.09).
 */
public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(String message) {
        super(message);
    }
}
