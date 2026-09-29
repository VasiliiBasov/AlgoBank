-- Шаг 8 · SQL-блок 2 · Q2: транзакции Ивана Петрова.
-- Колонки: id, amount_minor, description; порядок — по id транзакции (4 строки: 1, 2, 3, 10).
-- Ловушка: фильтр по ИМЕНИ 'Иван Петров', не по id счёта; вопрос собеса — чем условие
-- в WHERE отличается от условия в ON для INNER (ответ: ничем — теория §2).
-- Постановка и ожидаемый результат: docs/sqldrills/step08/README.md (Q2)
-- Напиши один SELECT ниже этой строки:
SELECT t.id, t.amount_minor, t.description
FROM account a INNER JOIN transactions t ON t.account_id = a.id
WHERE a.owner_name = 'Иван Петров' ORDER BY t.id