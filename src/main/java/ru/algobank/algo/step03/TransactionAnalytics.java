package ru.algobank.algo.step03;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionAnalytics {

    record Transaction(String type, double amount, String user, Instant time) {
    }

    // ============ Тестовые данные ============
    // lastTime — последняя транзакция в списке, нужна для пункта 5
    private static Instant lastTime(List<Transaction> tx) {
        return tx.stream().map(Transaction::time).max(Comparator.naturalOrder()).orElseThrow();
    }

    private static List<Transaction> sample() {
        Instant t = Instant.parse("2026-09-16T10:00:00Z");
        return new ArrayList<>(List.of(
                new Transaction("DEPOSIT", 1000, "Alice", t),
                new Transaction("WITHDRAW", 500, "Bob", t.plusSeconds(60)),
                new Transaction("DEPOSIT", 2000, "Alice", t.plusSeconds(120)),
                new Transaction("WITHDRAW", 300, "Alice", t.plusSeconds(180)),
                new Transaction("TRANSFER", 1500, "Alice", t.plusSeconds(240)),
                new Transaction("DEPOSIT", 1500, "Bob", t.plusSeconds(300)),
                new Transaction("WITHDRAW", 200, "Carol", t.plusSeconds(360)),
                new Transaction("WITHDRAW", 100, "Carol", t.plusSeconds(400)),
                new Transaction("WITHDRAW", 150, "Carol", t.plusSeconds(430)),
                new Transaction("WITHDRAW", 250, "Carol", t.plusSeconds(450)) // 4 WD подряд
        ));
    }

    public static void main(String[] args) {
        List<Transaction> tx = sample();
        TransactionAnalytics analytics = new TransactionAnalytics();

        System.out.println("1. Count by user:   " + analytics.countByUser(tx));
        System.out.println("2. Balance by user: " + analytics.balanceByUser(tx));
        System.out.println("3. Top-3 active:    " + analytics.top3Active(tx));
        System.out.println("4. First of day:    " + analytics.firstTransactionOfDay(tx));
        System.out.println("5. Suspicious:      " + analytics.suspiciousUsers(tx));
    }

    // ============ Реализация — Stream + Collectors ============

    // 1. Сколько транзакций у каждого юзера
    Map<String, Long> countByUser(List<Transaction> tx) {
        return tx.stream().collect(
                Collectors.groupingBy(Transaction::user, Collectors.counting())
        );
    }

    // 2. Баланс: DEPOSIT = +, WITHDRAW = -, TRANSFER не учитывается
    Map<String, Double> balanceByUser(List<Transaction> tx) {
        // TODO
        Map<String, Double> deposits = tx.stream()
                .filter(t -> t.type().equals("DEPOSIT"))
                .collect(Collectors.groupingBy(Transaction::user, Collectors.summingDouble(Transaction::amount)));

        Map<String, Double> withdraws = tx.stream()
                .filter(t -> t.type().equals("WITHDRAW"))
                .collect(Collectors.groupingBy(Transaction::user, Collectors.summingDouble(Transaction::amount)));

        Set<String> users = new HashSet<>();
        users.addAll(deposits.keySet());
        users.addAll(withdraws.keySet());

        Map<String, Double> balance = new HashMap<>();
        for (String user : users) {
            double dep = deposits.getOrDefault(user, 0.0);
            double withdr = withdraws.getOrDefault(user, 0.0);
            balance.put(user, dep - withdr);
        }

        return balance;
    }

    // 3. Топ-3 юзера по общей активности (по сумме всех транзакций)
    List<Map.Entry<String, Double>> top3Active(List<Transaction> tx) {
        // TODO
        List<Map.Entry<String, Double>> top3 = tx.stream().collect(
                        Collectors.groupingBy(Transaction::user,
                                Collectors.summingDouble(Transaction::amount)
                        ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .toList();
        return top3;
    }

    // 4. Первая транзакция дня (UTC). Несколько юзеров, разные дни — нам нужно ВСЕ первые.
    //    На самом деле по условию в тестовых данных все в один день, но решение должно
    //    работать и на кросс-дневных данных.
    //    Возвращает map: LocalDate -> Transaction (первая транзакция этого дня)
    Map<LocalDate, Transaction> firstTransactionOfDay(List<Transaction> tx) {

        // TODO
        return tx.stream().collect(Collectors.groupingBy(
                        t -> t.time().atOffset(ZoneOffset.UTC).toLocalDate(),
                        Collectors.minBy(Comparator.comparing(Transaction::time))
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().orElseThrow()
                ));
    }

    // 5. Подозрительные юзеры: те, у кого > 3 WITHDRAW за последний час от последней транзакции
    Set<String> suspiciousUsers(List<Transaction> tx) {
        // TODO
        Instant lastTime = tx.stream()
                .map(Transaction::time)
                .max(Comparator.naturalOrder()).orElseThrow();

        Instant oneHourAgo = lastTime.minusSeconds(3600);

        return tx.stream()
                .filter(t -> t.type().equals("WITHDRAW"))
                .filter(t -> t.time().isAfter(oneHourAgo))
                .collect(Collectors.groupingBy(Transaction::user, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
