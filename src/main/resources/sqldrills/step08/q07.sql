-- Шаг 8 · SQL-блок 2 · Q7: пара транзакций-«двойников» — одинаковая сумма, РАЗНЫЕ счета.
-- Колонки: id первой, имя её владельца, id второй, имя её владельца, сумма (1 строка: 8, Олег, 10, Иван, -450).
-- Приёмы: self-join (t1 JOIN t2) + account ДВАЖДЫ под двумя алиасами (owner первой и второй);
-- зеркальные пары гасим условием t1.id < t2.id (теория §6–§7).
-- Постановка и ожидаемый результат: docs/sqldrills/step08/README.md (Q7)
-- Напиши один SELECT ниже этой строки:
SELECT t1.id, a1.owner_name AS account_from, t2.id, a2.owner_name AS account_to, t1.amount_minor
FROM transactions t1
         INNER JOIN transactions t2
                    ON t1.amount_minor = t2.amount_minor AND t1.id < t2.id
         INNER JOIN account a1 ON a1.id = t1.account_id
         INNER JOIN account a2 ON a2.id = t2.account_id AND t1.account_id <> t2.account_id