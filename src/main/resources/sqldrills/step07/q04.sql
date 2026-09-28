-- Шаг 7 · SQL-блок · Q4: id и amount_minor транзакций счёта 1, по убыванию суммы
-- Постановка и ожидаемый результат: docs/sqldrills/step07/README.md (Q4)
-- Подсказка-ловушка: следи за знаками ( -450 против -4500 )
-- Напиши один SELECT ниже этой строки:
SELECT id, amount_minor FROM transactions WHERE account_id = 1 ORDER BY amount_minor DESC
