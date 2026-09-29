-- Шаг 8 · SQL-блок 2 · Q4: счета БЕЗ транзакций.
-- Колонки: id, owner_name (ровно 1 строка: 4, Анна Козлова).
-- Приём: anti-join = LEFT JOIN + WHERE t.id IS NULL; NOT IN не используем (NULL-ловушка, теория §3).
-- Постановка и ожидаемый результат: docs/sqldrills/step08/README.md (Q4)
-- Напиши один SELECT ниже этой строки:
SELECT a.id, a.owner_name
FROM account a LEFT JOIN transactions t ON t.account_id = a.id WHERE t.id IS NULL