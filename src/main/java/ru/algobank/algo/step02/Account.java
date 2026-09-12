package ru.algobank.algo.step02;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Objects;
import ru.algobank.algo.step01.TransactionGrouping.Transaction;

import static java.util.List.*;

public final class Account {
    private final String owner;
    private final Money balance;
    private final List<Transaction> history;

    public Account(String owner, Money balance, List<Transaction> history) {
        this.owner = Objects.requireNonNull(owner);
        this.balance = Objects.requireNonNull(balance);
        this.history = copyOf(Objects.requireNonNull(history));
    }

    public String getOwner() {
        return owner;
    }
    public Money getBalance() {
        return balance;
    }
    public List<Transaction> getHistory() {
        return history;
    }

    public static void main(String[] args) {
        List<Transaction> txs = new ArrayList<>();
        txs.add(new Transaction("alice", "DEPOSIT", 100_000_00L));

        Account acc = new Account("alice",
                new Money(new BigDecimal("100.00"), Currency.getInstance("RUB")), txs);

        // Попытка взломать immutability
        txs.add(new Transaction("bob", "TRANSFER", 999_999_99L));
        try {
            acc.getHistory().clear();  // должно бросить UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("✓ Список защищён от изменений");
        }

        System.out.println("History size: " + acc.getHistory().size());  // должно быть 1
    }
}
