package ru.algobank.sqldrills.step01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import ru.algobank.sqldrills.SqlDrillRunner;

import java.util.List;

/**
 * Шаг sql-01 — базовый SELECT. Постановки и фикстуры: docs/sqldrills/step01/README.md.
 *
 * Прогон: mvn -Dtest=SqlStep01Test "-Dsqldrills=on" test
 *
 * Гейт -Dsqldrills=on осознанный: без него дрели пропускаются, чтобы основной
 * прогон тестов и GitHub CI оставались зелёными, пока шаг не решён.
 * Известные значения в ожиданиях — часть приёмки (как в algo-задачах),
 * SQL в файлах qNN.sql пишет ученик.
 */
@EnabledIfSystemProperty(named = "sqldrills", matches = "on",
        disabledReason = "SQL-дрели: включи флагом -Dsqldrills=on (см. docs/sqldrills/SQL_TRACK.md)")
public class SqlStep01Test {

    private static final String STEP = "sqldrills/step01/";

    @Test
    void q01_allAccounts() {
        SqlDrillRunner.assertQuery(STEP + "q01.sql", List.of(
                List.of("1", "Иван Петров", "150000"),
                List.of("2", "Мария Сидорова", "235000"),
                List.of("3", "Олег Смирнов", "50000"),
                List.of("4", "Анна Козлова", "0")));
    }

    @Test
    void q02_balancesDesc() {
        SqlDrillRunner.assertQuery(STEP + "q02.sql", List.of(
                List.of("Мария Сидорова", "235000"),
                List.of("Иван Петров", "150000"),
                List.of("Олег Смирнов", "50000"),
                List.of("Анна Козлова", "0")));
    }

    @Test
    void q03_richOwners() {
        SqlDrillRunner.assertQuery(STEP + "q03.sql", List.of(
                List.of("Иван Петров"),
                List.of("Мария Сидорова")));
    }

    @Test
    void q04_accountOneAmountsDesc() {
        SqlDrillRunner.assertQuery(STEP + "q04.sql", List.of(
                List.of("1", "100000"),
                List.of("10", "-450"),
                List.of("2", "-4500"),
                List.of("3", "-12300")));
    }

    @Test
    void q05_withoutDescription() {
        SqlDrillRunner.assertQuery(STEP + "q05.sql", List.of(
                List.of("5", "-9999")));
    }

    @Test
    void q06_distinctAmounts() {
        SqlDrillRunner.assertQuery(STEP + "q06.sql", List.of(
                List.of("-12300"),
                List.of("-9999"),
                List.of("-4500"),
                List.of("-550"),
                List.of("-450"),
                List.of("1000"),
                List.of("35000"),
                List.of("100000"),
                List.of("200000")));
    }

    @Test
    void q07_salaryDescriptions() {
        SqlDrillRunner.assertQuery(STEP + "q07.sql", List.of(
                List.of("1", "зарплата сентябрь"),
                List.of("4", "зарплата сентябрь")));
    }

    @Test
    void q08_betweenSmallAmounts() {
        SqlDrillRunner.assertQuery(STEP + "q08.sql", List.of(
                List.of("7", "-550"),
                List.of("8", "-450"),
                List.of("9", "1000"),
                List.of("10", "-450")));
    }

    @Test
    void q09_twoOwners() {
        SqlDrillRunner.assertQuery(STEP + "q09.sql", List.of(
                List.of("1", "Иван Петров"),
                List.of("4", "Анна Козлова")));
    }

    @Test
    void q10_balanceInRubles() {
        SqlDrillRunner.assertQuery(STEP + "q10.sql", List.of(
                List.of("Иван Петров", "1500"),
                List.of("Мария Сидорова", "2350"),
                List.of("Олег Смирнов", "500"),
                List.of("Анна Козлова", "0")));
    }

    @Test
    void q11_topTwoAmounts() {
        SqlDrillRunner.assertQuery(STEP + "q11.sql", List.of(
                List.of("4", "200000"),
                List.of("1", "100000")));
    }

    @Test
    void q12_accountThenAmount() {
        SqlDrillRunner.assertQuery(STEP + "q12.sql", List.of(
                List.of("3", "1", "-12300"),
                List.of("2", "1", "-4500"),
                List.of("10", "1", "-450"),
                List.of("1", "1", "100000"),
                List.of("5", "2", "-9999"),
                List.of("6", "2", "35000"),
                List.of("4", "2", "200000"),
                List.of("7", "3", "-550"),
                List.of("8", "3", "-450"),
                List.of("9", "3", "1000")));
    }
}
