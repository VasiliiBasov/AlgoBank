-- Шаг 8 · SQL-блок 2 · Q8: транзакции крупнее 10000 (минорных) с балансом владельца.
-- Колонки: owner_name, id, amount_minor, balance_minor; порядок — amount_minor по убыванию.
-- (3 строки: 200000 Мария, 100000 Иван, 35000 Мария — баланс Марии повторится, это нормально.)
-- Постановка и ожидаемый результат: docs/sqldrills/step08/README.md (Q8)
-- Напиши один SELECT ниже этой строки:
SELECT a.owner_name, t.id, t.amount_minor, a.balance_minor
FROM account a
         INNER JOIN transactions t ON a.id = t.account_id AND t.amount_minor > 10000
ORDER BY t.amount_minor DESC