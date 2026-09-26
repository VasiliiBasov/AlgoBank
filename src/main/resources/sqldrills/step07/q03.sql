-- Шаг 7 · SQL-блок · Q3: имена владельцев с балансом строго больше 100000, по имени ASC
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q3)
-- Напиши один SELECT ниже этой строки:
SELECT owner_name FROM account WHERE balance_minor > 100000 ORDER BY owner_name
