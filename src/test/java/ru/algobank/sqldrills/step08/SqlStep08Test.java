package ru.algobank.sqldrills.step08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import ru.algobank.sqldrills.SqlDrillRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Шаг 8 · SQL-блок 2: JOIN — INNER/LEFT/RIGHT/FULL, NULL при JOIN, мульти-JOIN.
 * Постановки и фикстуры: docs/sqldrills/step08/README.md.
 *
 * ГЕЙТ: тесты работают только с -Dsqldrills=on (@EnabledIfSystemProperty) —
 * осознанно, чтобы блок был красным для ученика, но зелёным в общем прогоне и CI,
 * пока шаг не сдан. При сдаче (ритуал SQL_TRACK.md) ментор снимает аннотацию.
 *
 * Известные значения в ожиданиях — часть приёмки; SQL в файлах qNN.sql пишет ученик.
 * Ожидаемый SQL NULL читается как null (в таких строках — Arrays.asList).
 */
@EnabledIfSystemProperty(named = "sqldrills", matches = "on")
public class SqlStep08Test {

    private static final String STEP = "sqldrills/step08/";

    @Test
    void q01_innerAllTransactionsWithOwner() {
        SqlDrillRunner.assertQuery(STEP + "q01.sql", List.of(
                List.of("1", "Иван Петров", "100000"),
                List.of("2", "Иван Петров", "-4500"),
                List.of("3", "Иван Петров", "-12300"),
                List.of("4", "Мария Сидорова", "200000"),
                List.of("5", "Мария Сидорова", "-9999"),
                List.of("6", "Мария Сидорова", "35000"),
                List.of("7", "Олег Смирнов", "-550"),
                List.of("8", "Олег Смирнов", "-450"),
                List.of("9", "Олег Смирнов", "1000"),
                List.of("10", "Иван Петров", "-450")));
    }

    @Test
    void q02_innerOnlyIvan() {
        SqlDrillRunner.assertQuery(STEP + "q02.sql", List.of(
                List.of("1", "100000", "зарплата сентябрь"),
                List.of("2", "-4500", "супермаркет"),
                List.of("3", "-12300", "аренда жилья"),
                List.of("10", "-450", "кофе")));
    }

    @Test
    void q03_leftAllAccounts() {
        SqlDrillRunner.assertQuery(STEP + "q03.sql", List.of(
                List.of("Иван Петров", "1", "100000"),
                List.of("Иван Петров", "2", "-4500"),
                List.of("Иван Петров", "3", "-12300"),
                List.of("Иван Петров", "10", "-450"),
                List.of("Мария Сидорова", "4", "200000"),
                List.of("Мария Сидорова", "5", "-9999"),
                List.of("Мария Сидорова", "6", "35000"),
                List.of("Олег Смирнов", "7", "-550"),
                List.of("Олег Смирнов", "8", "-450"),
                List.of("Олег Смирнов", "9", "1000"),
                Arrays.asList("Анна Козлова", null, null)));
    }

    @Test
    void q04_leftAntiJoinNoTransactions() {
        SqlDrillRunner.assertQuery(STEP + "q04.sql", List.of(
                List.of("4", "Анна Козлова")));
    }

    @Test
    void q05_rightMirrorsLeft() {
        SqlDrillRunner.assertQuery(STEP + "q05.sql", List.of(
                List.of("Иван Петров", "1", "100000"),
                List.of("Иван Петров", "2", "-4500"),
                List.of("Иван Петров", "3", "-12300"),
                List.of("Иван Петров", "10", "-450"),
                List.of("Мария Сидорова", "4", "200000"),
                List.of("Мария Сидорова", "5", "-9999"),
                List.of("Мария Сидорова", "6", "35000"),
                List.of("Олег Смирнов", "7", "-550"),
                List.of("Олег Смирнов", "8", "-450"),
                List.of("Олег Смирнов", "9", "1000"),
                Arrays.asList("Анна Козлова", null, null)));
    }

    @Test
    void q06_fullWithOnCondition() {
        SqlDrillRunner.assertQuery(STEP + "q06.sql", List.of(
                Arrays.asList("Анна Козлова", null, null),
                List.of("Иван Петров", "1", "100000"),
                List.of("Мария Сидорова", "4", "200000"),
                List.of("Мария Сидорова", "6", "35000"),
                List.of("Олег Смирнов", "9", "1000"),
                Arrays.asList(null, "2", "-4500"),
                Arrays.asList(null, "3", "-12300"),
                Arrays.asList(null, "5", "-9999"),
                Arrays.asList(null, "7", "-550"),
                Arrays.asList(null, "8", "-450"),
                Arrays.asList(null, "10", "-450")));
    }

    @Test
    void q07_selfJoinAmountTwins() {
        SqlDrillRunner.assertQuery(STEP + "q07.sql", List.of(
                List.of("8", "Олег Смирнов", "10", "Иван Петров", "-450")));
    }

    @Test
    void q08_innerBigAmountsWithBalance() {
        SqlDrillRunner.assertQuery(STEP + "q08.sql", List.of(
                List.of("Мария Сидорова", "4", "200000", "235000"),
                List.of("Иван Петров", "1", "100000", "150000"),
                List.of("Мария Сидорова", "6", "35000", "235000")));
    }
}
