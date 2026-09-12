package ru.algobank.algo.step01;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionGrouping {

    record Transaction(String client, String type, long amountKopecks) {
    }

    public static void main(String[] args) {
        List<Transaction> txs = List.of(
                new Transaction("alice", "TRANSFER", 50_000_00L),
                new Transaction("bob", "WITHDRAW", 10_000_00L),
                new Transaction("alice", "PAYMENT", 3_500_00L),
                new Transaction("carol", "TRANSFER", 80_000_00L),
                new Transaction("alice", "DEPOSIT", 100_000_00L),
                new Transaction("bob", "TRANSFER", 25_000_00L),
                new Transaction("dave", "PAYMENT", 1_200_00L),
                new Transaction("alice", "PAYMENT", 7_800_00L)
        );

        // TODO 1: сумма по типам
        Map<String, Long> sumByType = txs.stream().collect(Collectors.groupingBy(
                Transaction::type, Collectors.summingLong(Transaction::amountKopecks)
        ));

        // TODO 2: количество по типам
        Map<String, Long> countByType = txs.stream().collect(Collectors.groupingBy(
                Transaction::type, Collectors.counting()
        ));

        // TODO 3: топ-3 клиента по количеству операций
        List<Map.Entry<String, Long>> topClients = txs.stream().collect(Collectors.groupingBy(
                Transaction::client, Collectors.counting()
        ))
                        .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .limit(3).toList();

        System.out.println("Сумма по типам: " + sumByType);
        System.out.println("Количество по типам: " + countByType);
        System.out.println("Топ-3 клиента: " + topClients);
    }
}
