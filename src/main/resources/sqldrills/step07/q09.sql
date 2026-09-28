-- Шаг 7 · SQL-блок · Q9: id и owner_name счетов Ивана Петрова и Анны Козловой, по id
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q9)
-- Напиши один SELECT ниже этой строки:
SELECT id, owner_name FROM account WHERE owner_name IN ('Иван Петров', 'Анна Козлова') ORDER BY id
