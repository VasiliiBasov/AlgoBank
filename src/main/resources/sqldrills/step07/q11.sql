-- Шаг 7 · SQL-блок · Q11: две самые крупные транзакции (id, amount_minor)
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q11)
-- Напиши один SELECT ниже этой строки:
SELECT id, amount_minor FROM transactions ORDER BY amount_minor DESC LIMIT 2
