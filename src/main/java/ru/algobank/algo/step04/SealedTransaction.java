package ru.algobank.algo.step04;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Шаг 4A: Records + sealed interface (Java 21).
 * <p>
 * Что отрабатываем:
 * 1) record — компактный value-class (авто: ctor, аксессоры, equals, hashCode, toString)
 * 2) sealed interface + permits — закрытая иерархия типов
 * 3) record patterns в switch + проверка exhaustiveness
 */
public class SealedTransaction {

    /* ============================================================
     * 1) sealed-иерархия: Transaction
     * ============================================================ */

    /**
     * Закрытая иерархия — только Deposit/Withdraw/Transfer могут реализовать.
     */
    public sealed interface Transaction permits Deposit, Withdraw, Transfer {
        BigDecimal amount();

        default boolean isLarge() {
            return amount().compareTo(new BigDecimal("100000")) > 0;
        }
    }

    /**
     * record — value-class: поля final, авто-аксессоры user()/amount().
     */
    public record Deposit(String user, BigDecimal amount, LocalDate date) implements Transaction {
    }

    public record Withdraw(String user, BigDecimal amount, LocalDate date) implements Transaction {
    }

    public record Transfer(String from, String to, BigDecimal amount, LocalDate date) implements Transaction {
    }

    /* ============================================================
     * 2) switch pattern matching — компилятор проверяет полноту
     * ============================================================ */

    /**
     * Человекочитаемое описание транзакции.
     */
    public static String describe(Transaction t) {
        // pattern matching switch по типу (Java 21)
        return switch (t) {
            case Deposit d -> "Пополнение user=" + d.user() + " на " + d.amount() + " в " + d.date();
            case Withdraw w -> "Списание user=" + w.user() + " на " + w.amount();
            case Transfer tx -> "Перевод " + tx.from() + " → " + tx.to() + " " + tx.amount();
            // БЕЗ default! sealed гарантирует, что других типов нет.
            // Если убрать один case — компилятор РУГАЕТСЯ на отсутствие ветки.
        };
    }

    /* ============================================================
     * 3) Enum для типа операции + ещё один switch для практики
     * ============================================================ */

    public enum OpKind {INCOME, EXPENSE, TRANSFER}

    public static OpKind opKind(Transaction t) {
        return switch (t) {
            case Deposit d -> OpKind.INCOME;
            case Withdraw w -> OpKind.EXPENSE;
            case Transfer tx -> OpKind.TRANSFER;
        };
    }

    /* ============================================================
     * 4) Запись всех транзакций банковской выписки в формате CSV
     * ============================================================ */

    /**
     * Превращает список транзакций в CSV-строки (для дампа/теста).
     */
    public static List<String> toCsv(List<Transaction> txs) {
        return txs.stream()
                .map(t -> switch (t) {
                    case Deposit d -> "DEPOSIT," + d.user() + "," + d.amount() + "," + d.date();
                    case Withdraw w -> "WITHDRAW," + w.user() + "," + w.amount() + "," + w.date();
                    case Transfer tx -> "TRANSFER," + tx.from() + "," + tx.to() + "," + tx.amount() + "," + tx.date();
                })
                .toList();
    }

    public static String summarize(Transaction t) {

        BigDecimal THRESHOLD_BIG = new BigDecimal("100000");
        BigDecimal THRESHOLD_MED = new BigDecimal("10000");

        return switch (t) {
            case Transfer(var from, var to, var amount, var date)
                    when amount.compareTo(THRESHOLD_BIG) > 0 -> "LARGE TRANSFER from=" + from + " to=" + to;
            case Deposit d when d.amount.compareTo(THRESHOLD_BIG) > 0 -> "BIG OP: Deposit user=" + d.user();
            case Withdraw w when w.amount.compareTo(THRESHOLD_BIG) > 0 -> "BIG OP: Withdraw user=" + w.user();
            case Deposit d when d.amount.compareTo(THRESHOLD_MED) > 0 -> "MODERATE Deposit user=" + d.user();
            case Withdraw w when w.amount.compareTo(THRESHOLD_MED) > 0 -> "MODERATE Withdraw user=" + w.user();
            case Transfer tx when tx.amount.compareTo(THRESHOLD_MED) > 0 -> "MODERATE TRANSFER user=" + tx.from();
            case Deposit d -> "SMALL Deposit user=" + d.user();
            case Withdraw w -> "SMALL Withdraw user=" + w.user();
            case Transfer tx -> "SMALL TRANSFER user=" + tx.from();
        };
    }

    /* ============================================================
     * main — проверим, что всё компилируется и работает
     * ============================================================ */
    public static void main(String[] args) {
        List<Transaction> txs = List.of(
                new Deposit("alice", new BigDecimal("1500.00"), LocalDate.now()),
                new Withdraw("alice", new BigDecimal("400.50"), LocalDate.now()),
                new Transfer("alice", "bob", new BigDecimal("200.00"), LocalDate.now()),
                new Deposit("bob", new BigDecimal("9999.99"), LocalDate.now()),
                new Deposit("alice", new BigDecimal("1500.00"), LocalDate.now()),   // SMALL
                new Deposit("alice", new BigDecimal("50000.00"), LocalDate.now()),   // MODERATE
                new Deposit("alice", new BigDecimal("250000.00"), LocalDate.now()),   // BIG
                new Transfer("alice", "bob", new BigDecimal("150000.00"), LocalDate.now()) // LARGE TRANSFER
        );

        System.out.println("=== describe ===");
        for (Transaction t : txs) {
            System.out.println(describe(t) + " Большая сумма? " + t.isLarge());
        }

        System.out.println("\n=== opKind ===");
        for (Transaction t : txs) {
            System.out.println(t.getClass().getSimpleName() + " → " + opKind(t));
        }


        System.out.println("\n=== CSV ===");
        toCsv(txs).forEach(System.out::println);

        System.out.println("\n=== summarize ===");
        Map<String, Long> stats = txs.stream()
                .collect(Collectors.groupingBy(SealedTransaction::summarize, Collectors.counting()));
        stats.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
