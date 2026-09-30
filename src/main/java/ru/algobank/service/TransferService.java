package ru.algobank.service;

/**
 * Шаг 8 · 8B: сервис денежных переводов между счетами.
 *
 * ЗАГЛУШКА ментора (как qNN.sql в sqldrills): существует лишь чтобы контракт-приёмка
 * {@code TransferServiceAcceptanceTest} компилировалась и была КРАСНОЙ до реализации.
 * Реализацию пишет ученик по ТЗ 8B (LEARNING_LOG, 30.09.2026):
 * @Transactional transfer — списание/начисление двух счетов атомарно, движения в transactions,
 * AccountNotFoundException / InsufficientFundsException / IllegalArgumentException по правилам ТЗ.
 */
// TODO(8B, ученик): @Service + @Transactional + реализация transfer(...)
public class TransferService {

    public void transfer(Long fromId, Long toId, long amountMinor) {
        throw new UnsupportedOperationException("TODO 8B: реализовать атомарный перевод (ученик)");
    }
}
