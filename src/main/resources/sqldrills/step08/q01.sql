-- Шаг 8 · SQL-блок 2 · Q1: все транзакции с именем владельца.
-- Колонки: id (транзакции), owner_name, amount_minor; порядок — по id транзакции.
-- Вид соединения: INNER (Олег? Анна? — кто без транзакций, тот не попадёт; объясни на зачёте).
-- Постановка и ожидаемый результат: docs/sqldrills/step08/README.md (Q1)
-- Напиши один SELECT ниже этой строки:
SELECT t.id, a.owner_name, t.amount_minor
FROM transactions t INNER JOIN account a ON a.id = t.account_id ORDER BY t.id