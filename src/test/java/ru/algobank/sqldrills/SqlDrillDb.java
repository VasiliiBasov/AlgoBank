package ru.algobank.sqldrills;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Инфраструктура SQL-трека (см. docs/sqldrills/SQL_TRACK.md).
 * Поднимает чистую in-memory H2 и накатывает миграции из db/migration
 * и сид-данные из sqldrills/seed. Каждый вызов {@link #open()} — новая
 * изолированная БД, чтобы задачи не могли влиять друг на друга.
 */
public final class SqlDrillDb {

    private SqlDrillDb() {
    }

    /** Чистая БД со схемой из миграций и фикстурами трека. */
    public static Connection open() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:h2:mem:sqldrills-" + UUID.randomUUID() + ";MODE=PostgreSQL", "sa", "");
            runDirectory(connection, "db/migration");
            runDirectory(connection, "sqldrills/seed");
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("Не удалось поднять drill-БД", e);
        }
    }

    /** Выполняет все *.sql из каталога classpath в алфавитном порядке имён (V1, V2, …, V900). */
    private static void runDirectory(Connection connection, String classpathDir) {
        URL dirUrl = SqlDrillDb.class.getClassLoader().getResource(classpathDir);
        Objects.requireNonNull(dirUrl, "Не найден каталог в classpath: " + classpathDir);
        try (Stream<Path> files = Files.list(Path.of(dirUrl.toURI()))) {
            files.filter(p -> p.getFileName().toString().endsWith(".sql"))
                    .sorted(Comparator.comparing(p -> p.getFileName().toString()))
                    .forEach(p -> runScript(connection, read(p)));
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Не удалось прочитать каталог: " + classpathDir, e);
        }
    }

    /**
     * Простой раннер скриптов: делит по ';'. Для учебных скриптов достаточно —
     * без ';' внутри строковых литералов и без процедурных блоков.
     */
    static void runScript(Connection connection, String script) {
        for (String statement : script.split(";")) {
            String sql = statement.strip();
            if (sql.isEmpty()) {
                continue;
            }
            try (Statement st = connection.createStatement()) {
                st.execute(sql);
            } catch (SQLException e) {
                throw new IllegalStateException("Ошибка выполнения скрипта:\n" + sql, e);
            }
        }
    }

    static String read(Path path) {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
