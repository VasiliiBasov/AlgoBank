package ru.algobank.algo.step07;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class TransactionDuplicates {

    private TransactionDuplicates() {
    }

    public static Set<Long> findDuplicates(List<Long> transactionIds) {
        Set<Long> seen = new HashSet<>();
        Set<Long> duplicates = new HashSet<>();
        transactionIds.forEach(transactionId -> {
            if (seen.contains(transactionId)) {
                duplicates.add(transactionId);
            } else {
                seen.add(transactionId);
            }
        });
        return duplicates;
    }
}
