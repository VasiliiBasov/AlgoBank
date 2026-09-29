-- Шаг 8 · SQL-блок 2 · Q6: LEFT JOIN + условие в ON (ON vs WHERE!).
-- Соединение: t.account_id = a.id AND t.amount_minor > 0 — положительность в ON, НЕ в WHERE
-- (в WHERE это условие превратило бы LEFT в INNER — Анна выпадет; теория §2).
-- Колонки: owner_name, id (транзакции), amount_minor; порядок — id счёта, затем id транзакции.
-- Ожидается 5 строк: Иван +100000 → Мария ×2 (+200000, +35000) → Олег +1000 → Анна (NULL, NULL).
-- NB: исходная постановка была про FULL JOIN, но H2 2.4 его не поддерживает вовсе (теория §5).
-- Постановка и ожидаемый результат: docs/sqldrills/step08/README.md (Q6)
-- Напиши один SELECT ниже этой строки:
SELECT a.owner_name, t.id, t.amount_minor
FROM account a LEFT JOIN transactions t ON a.id = t.account_id AND t.amount_minor > 0
ORDER BY a.id, t.id