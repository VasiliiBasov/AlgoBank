package ru.algobank.algo.step02;

import java.math.BigDecimal;
import java.util.*;

public final class Money implements  Comparable<Money>{
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = Objects.requireNonNull(amount, "amount");
        this.currency = Objects.requireNonNull(currency, "currency");
    }

    public static Money of(String amount, String currencyCode) {
        return new Money(new BigDecimal(amount), Currency.getInstance(currencyCode));
    }

    public static Money zero(Currency currency) {
        return new Money(BigDecimal.ZERO, currency);
    }

    public Money add(Money other) {
        requireSameCurrency(other);
        return new Money(amount.add(other.amount), currency);
    }

    private void requireSameCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch: " + this.currency + " vs " + other.currency);
        }
    }

    @Override
    public int compareTo(Money other) {
        Objects.requireNonNull(other, "other");
        requireSameCurrency(other);
        return amount.compareTo(other.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return amount.compareTo(money.amount) == 0 && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return amount.toPlainString() + " " + currency.getCurrencyCode();
    }

    public static void main(String[] args) {
        Money balance = Money.of("100.50", "RUB");
        Money deposit = Money.of("50.25", "RUB");
        Money total = balance.add(deposit);
        System.out.println("Total: " + total);  // 150.75 RUB

        // Защита от смешивания валют
        Money usd = Money.of("100.00", "USD");
        try {
            balance.add(usd);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Защита от смешивания валют: " + e.getMessage());
        }

        // Сортировка
        List<Money> list = new ArrayList<>();
        list.add(Money.of("100", "RUB"));
        list.add(Money.of("50", "RUB"));
        list.add(Money.of("200", "RUB"));
        Collections.sort(list);
        System.out.println("Sorted: " + list);  // [50.00 RUB, 100.00 RUB, 200.00 RUB]
    }
}
