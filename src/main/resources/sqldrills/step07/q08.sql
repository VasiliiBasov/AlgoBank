-- Шаг 7 · SQL-блок · Q8: id и amount_minor транзакций с суммой от -1000 до 1000 включительно, по id
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q8)
-- Напиши один SELECT ниже этой строки:
SELECT id, amount_minor FROM transactions WHERE amount_minor BETWEEN -1000 AND 1000 ORDER BY id
