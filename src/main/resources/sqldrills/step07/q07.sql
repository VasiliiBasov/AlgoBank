-- Шаг 7 · SQL-блок · Q7: id и description транзакций, где описание начинается со слова 'зарплата', по id
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q7)
-- Напиши один SELECT ниже этой строки:
SELECT id, description FROM transactions WHERE description LIKE 'зарплата%' ORDER BY id
