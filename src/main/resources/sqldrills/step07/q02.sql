-- Шаг 7 · SQL-блок · Q2: owner_name и balance_minor всех счетов, по убыванию баланса
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q2)
-- Напиши один SELECT ниже этой строки:
SELECT owner_name, balance_minor FROM account ORDER BY balance_minor DESC
