package ru.algobank.algo.step03;

import java.util.*;
import java.util.stream.*;

public class CollectorsPlayground {

    public static void main(String[] args) {
        List<Transaction> transactions = sampleTransactions();

        // ============= Задания — допиши реализацию =============

        // 1. Общая сумма всех транзакций
        double totalAmount = transactions.stream().collect(Collectors.summingDouble(t -> t.getAmount()));

        // 2. Map<String, Long> — сколько транзакций каждого типа?
        Map<String, Long> countByType = transactions.stream().collect(Collectors.groupingBy(t -> t.type, Collectors.counting()));

        // 3. Map<String, Double> — общая сумма по типам?
        Map<String, Double> sumByType = transactions.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount)));

        // 4. Map<String, List<String>> — пользователи по типам транзакций?
        Map<String, List<String>> usersByType = transactions.stream().collect((
                Collectors.groupingBy(Transaction::getType, Collectors.mapping(
                        Transaction::getUser, Collectors.toList()
                ))
                ));

        // 5. Map<Boolean, List<Transaction>> — крупные (>500) vs мелкие?
        Map<Boolean, List<Transaction>> bigVsSmall = transactions.stream()
                .collect(Collectors.groupingBy(t -> t.getAmount() > 500));

        // 6. String — все типы через запятую?
        String typesJoined = transactions.stream()
                .map(Transaction::getType)
                .distinct()
                .collect(Collectors.joining(", "));

        // 7. Map<String, Optional<Transaction>> — самая крупная транзакция по типу?
        Map<String, Optional<Transaction>> maxByType = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType,
                        Collectors.maxBy(Comparator.comparingDouble(Transaction::getAmount))));

        // 8. Map<String, DoubleSummaryStatistics> — статистика сумм по типам?
        Map<String, DoubleSummaryStatistics> statsByType = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType,
                        Collectors.summarizingDouble(Transaction::getAmount)));

        // Вывод
        System.out.println("1. Total: " + totalAmount);
        System.out.println("2. Count by type: " + countByType);
        System.out.println("3. Sum by type: " + sumByType);
        System.out.println("4. Users by type: " + usersByType);
        System.out.println("5. Big vs small: " + bigVsSmall);
        System.out.println("6. Types joined: " + typesJoined);
        System.out.println("7. Max by type: " + maxByType);
        System.out.println("8. Stats by type: " + statsByType);
    }

    // ============ Я добавляю сам (скучная часть) ============

    private static List<Transaction> sampleTransactions() {
        return List.of(
            new Transaction("DEPOSIT", 1000.0, "Alice"),
            new Transaction("WITHDRAW", 500.0, "Alice"),
            new Transaction("DEPOSIT", 2000.0, "Bob"),
            new Transaction("TRANSFER", 300.0, "Alice"),
            new Transaction("DEPOSIT", 1500.0, "Bob"),
            new Transaction("WITHDRAW", 200.0, "Carol"),
            new Transaction("DEPOSIT", 750.0, "Carol")
        );
    }

    static class Transaction {
        private final String type;
        private final double amount;
        private final String user;

        Transaction(String type, double amount, String user) {
            this.type = type;
            this.amount = amount;
            this.user = user;
        }

        public String getType() { return type; }
        public double getAmount() { return amount; }
        public String getUser() { return user; }

        @Override
        public String toString() {
            return type + "(" + amount + "," + user + ")";
        }
    }
}
