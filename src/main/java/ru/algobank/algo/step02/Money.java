package ru.algobank.algo.step02;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public final class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = Objects.requireNonNull(amount, "amount");
        this.currency = Objects.requireNonNull(currency, "currency");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return amount.equals(money.amount) && currency.equals(money.currency);
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
        Money m1 = new Money(new BigDecimal("100.50"), Currency.getInstance("RUB"));
        Money m2 = new Money(new BigDecimal("100.50"), Currency.getInstance("RUB"));
        Money m3 = new Money(new BigDecimal("100.50"), Currency.getInstance("USD"));

        System.out.println("m1.equals(m2): " + m1.equals(m2));     // true
        System.out.println("m1.equals(m3): " + m1.equals(m3));     // false
        System.out.println("m1.hashCode() == m2.hashCode(): " + (m1.hashCode() == m2.hashCode()));  // true
        System.out.println("m1: " + m1);                            // 100.50 RUB
    }
}
