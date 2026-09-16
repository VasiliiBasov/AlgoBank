package ru.algobank.algo.step04;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Шаг 4: Records + sealed + pattern matching (Java 21).
 *
 * Цель: разобрать 3 концепции современного Java на банковском домене:
 * 1. record — компактный value-class для данных
 * 2. sealed interface — закрытая иерархия типов (только Deposit / Withdraw / Transfer)
 * 3. pattern matching switch — безопасная диспетчеризация по типу, компилятор следит за полнотой
 *
 * Ниже — заготовка. Методы заполни сам (где стоит ???).
 * Подсказки закомментированы в каждом методе.
 */
public class SealedTransaction {

    /* ============================================================
     * 1) sealed-иерархия: Transaction и его разрешённые реализации
     * ============================================================ */

    /** Закрытая иерархия транзакций. Только эти 3 типа могут реализовать Transaction. */
    public sealed interface Transaction permits Deposit, Withdraw, Transfer {
        BigDecimal amount();
    }

    /** ??? Сделай record Deposit с полями (user, amount).
     *  — record автоматически даёт конструктор, аксессоры (user(), amount()), equals, hashCode, toString.
     *  — implements Transaction — обязательно, чтобы попасть в permits.
     */
    public record Deposit(??? user, ??? amount) implements Transaction {
        // ничего не пиши — тело record пустое
    }

    /** ??? Сделай record Withdraw аналогично Deposit. */
    public record Withdraw(??? user, ??? amount) implements Transaction {
    }

    /** ??? Сделай record Transfer с тремя полями: (from, to, amount). */
    public record Transfer(??? from, ??? to, ??? amount) implements Transaction {
    }

    /* ============================================================
     * 2) Pattern matching switch по типу (Java 21)
     * ============================================================ */

    /**
     * Вернуть человекочитаемое описание транзакции.
     * Используй switch с pattern matching по типам (case Deposit d -> ... и т.д.).
     *
     * Требование: обработать все 3 типа. Компилятор САМ проверит exhaustiveness,
     * благодаря sealed + permits. Если добавим новый тип в permits — он подсветит здесь ошибку.
     */
    public static String describe(Transaction t) {
        // ??? верни строку через switch
        // Пример для Deposit: "Пополнение user=X на 100.50"
        // Пример для Withdraw: "Списание user=X на 100.50"
        // Пример для Transfer: "Перевод from=A → to=B на 100.50"
        return switch (t) {
            // ??? 3 case с pattern-ами
            default -> ???;
        };
    }

    /* ============================================================
     * 3) Когда "сумма прихода/расхода/перевода" по-разному
     * ============================================================ */

    /**
     * Тип операции: INCOME (деньги приходят — Deposit),
     * EXPENSE (уходят — Withdraw), TRANSFER (нейтрально для системы в целом).
     */
    public enum OpKind { INCOME, EXPENSE, TRANSFER }

    /** ??? Верни OpKind по типу транзакции. Используй switch pattern matching. */
    public static OpKind opKind(Transaction t) {
        return ???;
    }

    /* ============================================================
     * 4) Record + деструктуризация в switch (record patterns)
     * ============================================================ */

    /**
     * Является ли транзакция "подозрительно большой" (> 100 000)?
     * Используй record patterns — когда значение поля идёт прямо в when-условие.
     *
     * Пример record pattern в switch:
     *   case Deposit(var u, var a) -> ...
     *   case Transfer(_, _, var a) when a.compareTo(...) > 0 -> true
     */
    public static boolean isSuspicious(Transaction t) {
        // ??? используй record patterns + when
        // Подсказка: BigDecimal.compareTo(BigDecimal) — int
        return ???;
    }

    /* ============================================================
     * 5) Stream + sealed: фильтрация по типу через switch+record
     * ============================================================ */

    /**
     * Подсчёт общего объёма "прихода" (Deposit) среди всех транзакций.
     * Используй filter(... instanceof Deposit d) + map(Deposit::amount) + sum.
     */
    public static BigDecimal totalIncome(List<Transaction> txs) {
        return txs.stream()
                .filter(??? -> ??? instanceof Deposit d)
                .map(??? -> ???)
                .reduce(BigDecimal.ZERO, ???);
    }

    /* ============================================================
     * 6) Главный — группировка по пользователю с учётом sealed-иерархии
     * ============================================================ */

    /**
     * Для каждого пользователя посчитай СУММУ его операций.
     * — Deposit и Transfer.to — это "кому пришло" (INCOME).
     * — Withdraw и Transfer.from — это "от кого ушло" (EXPENSE).
     * — Баланс: SUM(income) - SUM(expense).
     *
     * Подсказка: тут удобно использовать switch по типу,
     * но можно и через фильтр+мап для простоты.
     */
    public static Map<String, BigDecimal> balanceByUser(List<Transaction> txs) {
        // ??? Map<String, BigDecimal> result = new HashMap<>();
        // ??? для каждой транзакции добавь/вычти amount() в нужный ключ
        return ???;
    }

    /* ============================================================
     * main — проверим, что собирается/запускается
     * ============================================================ */
    public static void main(String[] args) {
        List<Transaction> txs = List.of(
                new Deposit("alice", new BigDecimal("1500.00")),
                new Withdraw("alice", new BigDecimal("400.50")),
                new Transfer("alice", "bob", new BigDecimal("200.00")),
                new Deposit("bob", new BigDecimal("9999.99")),
                new Transfer("bob", "alice", new BigDecimal("50.00"))
        );

        System.out.println("=== describe ===");
        for (Transaction t : txs) {
            System.out.println(describe(t));
        }

        System.out.println("\n=== opKind ===");
        for (Transaction t : txs) {
            System.out.println(t.getClass().getSimpleName() + " → " + opKind(t));
        }

        System.out.println("\n=== isSuspicious ===");
        for (Transaction t : txs) {
            System.out.println(describe(t) + " | suspicious=" + isSuspicious(t));
        }

        System.out.println("\n=== totalIncome ===");
        System.out.println(totalIncome(txs));

        System.out.println("\n=== balanceByUser ===");
        Map<String, BigDecimal> balances = balanceByUser(txs);
        balances.forEach((u, b) -> System.out.println(u + " → " + b));
    }
}
