package ru.algobank.sqldrills;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Прогон файлов-ответов ученика (src/main/resources/sqldrills/stepNN/qNN.sql).
 * Из файла убираются строки-комментарии '--', запрос выполняется на свежей БД,
 * результат сверяется с ожидаемым: важны и порядок строк, и набор колонок.
 */
public final class SqlDrillRunner {

    private SqlDrillRunner() {
    }

    /** Прогоняет запрос ученика из файла-ответа и сверяет результат с ожидаемым. */
    public static void assertQuery(String resourcePath, List<List<String>> expected) {
        List<List<String>> actual = execute(loadStudentSql(resourcePath));
        assertEquals(expected, actual,
                () -> "Проверь запрос в " + resourcePath + " (постановка: docs/"
                        + resourcePath.substring(0, resourcePath.lastIndexOf('/')) + "/README.md)");
    }

    /** Выполняет SELECT на свежей drill-БД. Ячейки — строки, SQL NULL читается как null. */
    public static List<List<String>> execute(String sql) {
        try (Connection connection = SqlDrillDb.open();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            int columns = rs.getMetaData().getColumnCount();
            List<List<String>> rows = new ArrayList<>();
            while (rs.next()) {
                List<String> row = new ArrayList<>(columns);
                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getString(i));
                }
                rows.add(row);
            }
            return rows;
        } catch (SQLException e) {
            return fail("Запрос не выполнился (" + e.getMessage() + ")\nSQL:\n" + sql);
        }
    }

    /** Читает файл-ответ: без комментариев '--', ровно один SELECT c одной ';' максимум в конце. */
    private static String loadStudentSql(String resourcePath) {
        URL url = SqlDrillRunner.class.getClassLoader().getResource(resourcePath);
        Objects.requireNonNull(url, () -> "Файл не найден в classpath: " + resourcePath);
        String raw;
        try {
            raw = SqlDrillDb.read(Path.of(url.toURI()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
        String sql = raw.lines()
                .filter(line -> !line.strip().startsWith("--"))
                .collect(Collectors.joining("\n"))
                .strip();
        if (sql.isEmpty()) {
            return fail("Заглушка: впиши запрос в " + resourcePath);
        }
        if (sql.endsWith(";")) {
            sql = sql.substring(0, sql.length() - 1).strip();
        }
        if (sql.contains(";")) {
            return fail("Один файл = один запрос (';' только в самом конце): " + resourcePath);
        }
        if (!sql.regionMatches(true, 0, "SELECT", 0, "SELECT".length())) {
            return fail("Ожидается один SELECT (см. постановку блока): " + resourcePath);
        }
        return sql;
    }
}
