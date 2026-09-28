package ru.algobank.algo.step07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class TransactionDedup {
    record MoneyTx(long id, long amountMinor, LocalDate date) {
    }

    private TransactionDedup() {
    }

    public static List<MoneyTx> dedup(List<MoneyTx> moneyTxes) {
        record DedupKey(long amountMinor, LocalDate date) {
        }
        Set<DedupKey> deduped = new HashSet<>();
        List<MoneyTx> dedupedList = new ArrayList<>();
        moneyTxes.forEach(moneyTx -> {
            if (deduped.add(new DedupKey(moneyTx.amountMinor, moneyTx.date))) dedupedList.add(moneyTx);
        });
        return dedupedList;
    }

}
