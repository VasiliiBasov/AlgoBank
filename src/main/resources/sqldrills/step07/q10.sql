-- Шаг 7 · SQL-блок · Q10: owner (алиас owner_name) и balance_rub (алиас: баланс / 100), по id
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q10)
-- Напиши один SELECT ниже этой строки:
SELECT owner_name AS owner, balance_minor/100 AS balance_rub FROM account ORDER BY id
