# 📋 Прогресс: контекст и навигация

Здесь — **только** то, что нужно для быстрого входа в работу: где остановились, что дальше, шпаргалка для следующего открытия.

**Цифры, время, баллы — в `STATS.md`.**
**Конспект теории — в `LEARNING_LOG.md`.**
**Краткое резюме (если история слетит) — в `HANDOFF.md`.**
**Сводка по всем проектам — в `OVERALL_STATS.md`.**
**Программа курса + история — в `COURSE_HANDBOOK.md`.**

---

## 📌 Где мы сейчас

**Текущий шаг:** 4 / 26 (Records, sealed, pattern matching Java 21)
**Процент:** 12% (3/26)

**Что сделано в шаге 0 (служебный, инициализация, 11.09.2026):**
- ✅ Почищен Maven Archetype-артефакт (был `archetype-resources/`, `META-INF/maven/`)
- ✅ Создан нормальный `pom.xml` (Spring Boot 4.0.8, Java 21, JUnit 5, Testcontainers, Flyway, все нужные стартеры)
- ✅ Обновлён `.gitignore` (target, IDE, env, H2 data, logs)
- ✅ Создан `AlgoBankApplication.java` (стандартный `SpringApplication.run`)
- ✅ Создан `application.yml` (порт 8082, H2 in-memory, Flyway, Actuator, профиль dev)
- ✅ Создана структура пакетов: `ru.algobank.algo.step01`+ для алгоритмических задач
- ✅ Созданы 5 файлов-дневника: `HANDOFF.md`, `PROGRESS.md`, `STATS.md`, `LEARNING_LOG.md`, `OVERALL_STATS.md`, `COURSE_HANDBOOK.md`
- ✅ Git init + первый коммит

**Что сделано в шаге 1 (Collections framework, 11.09.2026):**
- ✅ **A** — ArrayList внутри + ArrayList vs LinkedList
  - Замер: ArrayList в 2700x быстрее на `get(i)`, в 66x медленнее на `add(0, x)`, ~2x медленнее на `addLast`
  - Файл `src/main/java/ru/algobank/algo/step01/ListBenchmark.java`
  - Коммит `e4ffba8`
- ✅ **B** — HashMap внутри (завершён 11.09.2026)
  - HashMap<String, Long> с балансами клиентов (alice, bob, carol, dave, eve)
  - put / get / update / entrySet / remove — всё отработало
  - Усвоено: контракт hashCode/equals, коллизии, O(1) средний случай, treeify в Java 8+
  - Файл `src/main/java/ru/algobank/algo/step01/HashMapPlayground.java`
  - Коммит `736954a`
- ✅ **C** — Two Sum, easy (завершён 12.09.2026)
  - Реализованы оба подхода: HashMap (O(n)) и brute force (O(n²))
  - Усвоено: HashMap в 1 000 000 раз быстрее на n=1M (10⁶ vs 10¹² операций)
  - Файл `src/main/java/ru/algobank/algo/step01/TwoSum.java`
  - Коммит `9060833`
- ✅ **D** — Группировка транзакций, easy/medium (завершён 12.09.2026)
  - record Transaction (клиент, тип, сумма)
  - 3 отчёта через Stream API: сумма по типам, count по типам, топ-3 клиента
  - Усвоено: Collectors.groupingBy + summingLong/counting, sorted+limit для top-K
  - Файл `src/main/java/ru/algobank/algo/step01/TransactionGrouping.java`
  - Коммит `2b83b70`
- ✅ Мини-экзамен: 1 вопрос без вариантов (завершён 12.09.2026)
  - Вопрос: ArrayList vs LinkedList для Account.transactions
  - Ответ: ArrayList (верно), аргументы про get(i) + append + Deque
  - Оценка: **85/100** (отлично для шага 1)
  - Комментарий: не хватает аргументов про cache locality и memory layout

---

## 🎉 Шаг 1 полностью завершён

**Прогресс:** 4 микро-шага + 2 алгоритмические задачи + мини-экзамен
**Файлы:**
- `ListBenchmark.java` — замер ArrayList vs LinkedList
- `HashMapPlayground.java` — типизированный HashMap с клиентами
- `TwoSum.java` — обе версии (HashMap + brute force)
- `TransactionGrouping.java` — Stream API, record, top-K

**Следующий шаг:** шаг 2 — Generics, equals/hashCode, immutability + value class `Money`

---

## Шаг 2: Generics, equals/hashCode, immutability (в работе)

- ✅ **A** — Generics (завершён 12.09.2026)
  - 3 метода: printList(?), sumNumbers(? extends Number), addIntegers(? super Integer)
  - Файл `src/main/java/ru/algobank/algo/step02/GenericsPlayground.java`
  - Коммит `1dc55ab`
  - Оценка: 80/100 (PECS баг — ? super Number вместо ? super Integer)
- ✅ **B** — equals/hashCode контракт + Money value object (завершён 12.09.2026)
  - final class Money, final поля, Objects.requireNonNull
  - equals через pattern matching, hashCode через Objects.hash
  - Файл `src/main/java/ru/algobank/algo/step02/Money.java`
  - Коммит `297de8c`
  - Оценка: 95/100 (не упомянул симметричность equals + нюанс BigDecimal scale)
- ✅ **C** — Immutability (defensive copies) — завершён 13.09.2026, 85/100 (забыл `final` на классе, исправлено)
- ✅ **D** — Money extended (Comparable, add/subtract, фабрики, currency guard) — завершён 13.09.2026, 95/100
- ✅ Мини-экзамен шага 2 — завершён 14.09.2026, 93/100

## 🎉 Шаг 2 полностью завершён (14.09.2026)

**Прогресс шага 2:** 2A (80) + 2B (95) + 2C (85) + 2D (95) + Экзамен (93) = **89.6/100**

**Файлы шага 2:**
- `GenericsPlayground.java` — PECS, wildcards (коммит `1dc55ab`)
- `Money.java` — value object с Comparable (коммиты `297de8c` → `77dae51`)
- `Account.java` — immutable с defensive copy (коммит `05d3466`)
- `ImmutablePoint.java` — тренировка value object (коммит `ed36bfb`)

**Ключевые открытия шага 2:**
- `compareTo` должен быть согласован с `equals` (иначе HashSet и TreeSet дают разные ответы)
- String immutability: String Pool + HashMap + thread-safety + security
- Defensive copy на входе и выходе из геттера — единственный способ сделать Account реально immutable

**Следующий шаг:** шаг 4 — Records, sealed, pattern matching (Java 21)

---

## 🎉 Шаг 3 полностью завершён

**Когда:** 16.09.2026
**Прогресс:** 5 микро-шагов + мини-экзамен
**Оценка:** 89.5/100 (средний по 6 пунктам: 3A=95, 3B=95, 3C=85, 3D=90, 3E=98, 3Экзамен=74)

**Что сделано в шаге 3 (Stream API + Optional + лямбды + Collectors):**
- ✅ **A** — Лямбды + method references (завершён 14.09.2026)
  - Функциональные интерфейсы, ссылки на методы (статические, экземпляра, конструкторы)
  - Файл `src/main/java/ru/algobank/algo/step03/LambdaPlayground.java`
- ✅ **B** — Stream API (завершён 15.09.2026)
  - 11 базовых операций: filter, map, flatMap, reduce, findFirst, mapToInt, max, joining
  - Интересный факт: обнаружил «нашёл длину самого длинного слова» — 8 (Function и Optional)
  - Файл `src/main/java/ru/algobank/algo/step03/StreamBasics.java`
- ✅ **C** — Optional (завершён 15.09.2026)
  - Цепочки: of, ofNullable, map, filter, orElse, orElseGet, ifPresent
  - Честный момент: ответ про orElse vs orElseGet был частично неточным (singleton — деталь JVM, не контракт)
  - Файл `src/main/java/ru/algobank/algo/step03/OptionalPlayground.java`
- ✅ **D** — Collectors (завершён 16.09.2026)
  - 8 коллекторов: toList, toSet, toMap, groupingBy, partitioningBy, joining, counting, summingDouble
  - 2G некоторые коллекторы (mapping, maxBy, summarizingDouble) дал сам в подсказках
  - Файл `src/main/java/ru/algobank/algo/step03/CollectorsPlayground.java`
- ✅ **E** — Задача TransactionAnalytics (завершён 16.09.2026)
  - 5 методов: countByUser, balanceByUser, top3Active, firstTransactionOfDay, suspiciousUsers
  - Использованы все основные коллекторы на реальной задаче
  - Мини-промахи: `!=` для строк → показал, исправил на `.equals()`; в методе `top3Active` біл синтаксический промах
  - Файл `src/main/java/ru/algobank/algo/step03/TransactionAnalytics.java`
- ✅ **Мини-экзамен** (74/100):
  - 1 (Stream базовые операции): 8/10 — `Collectors.toList(String::toUpperCase)` без `.map()`
  - 2 (Stream vs коллекция): 8/10 — верные 3 отличия, чуть не хватило lazy/eager
  - 3 (Lazy / peek): 5/10 — главная ошибка: `peek1: abcd` вместо каждого элемента по 2 раза
  - 4 (Optional): 10/10 — идеально
  - 5 (Вложенные Collectors): 6/10 — промах в синтаксисе, идея была верная
- ✅ **Коммит шага 3:** `1654b34` — step 3 complete

### Усвоено на шаге 3
- Stream — ленивый, одноразовый, не хранит данные
- Lazy: операции выполнения начинаются только при `collect`/`forEach`
- `peek` — промежуточная операция для логирования, вызывается для каждого элемента при проходе конвейера
- Optional — про замену null, `orElseGet` ленивый, `flatMap` для распаковки `Optional<Optional<T>>`
- Collectors: для агрегации; `groupingBy` с downstream коллектором позволяет делать двухуровневые группировки
- Вложенные коллекторы — реальный подход к аналитике транзакций

### Сделанные ошибки для запоминания
1. `!=` для строк → контракт на `equals()`. Хорошо ловит NPE-защиту через литерал слева.
2. `Collectors.toList(String::toUpperCase)` — `toList()` без аргументов, `.map()` для преобразования
3. `peek` логирует каждый элемент по 2 раза в моей задаче — lazy + промежуточная операция = для каждого элемента вся цепочка

### Что можно улучшить
- В методе `4` `firstTransactionOfDay` текущий подход использует `.entrySet().stream().collect(toMap)` — работает, но можно проще через `Optional.map(t -> t).get()` — в Java 16+ можно избежать переделки через `Collectors.toMap(minBy(...))`. Это версия 21 без чумы.

---

## 🧭 Если новый ассистент

**Если ученик написал «прочитай прогресс» — прочитай ОБЯЗАТЕЛЬНО все 6 файлов в таком порядке:**

0. **`COURSE_HANDBOOK.md`** — master-файл с историей и программой
1. **`OVERALL_STATS.md`** — сводка по всем проектам (Spring Core, Spring Boot, AlgoBank)
2. **`HANDOFF.md`** — краткое резюме
3. **`PROGRESS.md`** (этот файл) — где остановились
4. **`STATS.md`** — баллы, время, прогресс
5. **`LEARNING_LOG.md`** — конспект теории

### Суть
- **Ученик:** Василий. Готовится к собесе Java-разработчика (Middle, универсал). См. `COURSE_HANDBOOK.md`.
- **Профиль:** ценит глубокие разборы с аналогиями, ASCII-схемы, мини-экзамены без вариантов. **Не любит готовый код классов целиком** — давай только подсказки и направление.
- **Проект:** AlgoBank — банковский backend, всё изучается внутри него.

### Главное правило про время
**Не угадывай время — всегда `Get-Date`.**

### Правила работы с паузами и сессиями

| Команда ученика | Что делать ассистенту |
|---|---|
| **«начинаю обучение»** / **«продолжим»** | Зафиксировать время старта (`Get-Date`), отметить в `STATS.md` новую строку с датой и часами (по факту, в конце сессии), продолжить с того места, где остановились. |
| **«пауза»** | Проверить время (`Get-Date`), **не коммитить**, просто ждать следующей команды. |
| **«закончили на сегодня»** / **«заканчиваем на сегодня»** | Проверить время (`Get-Date`), записать в `STATS.md` итого за день, синхронизировать `HANDOFF.md` / `OVERALL_STATS.md` / `COURSE_HANDBOOK.md`, **закоммитить и запушить**. |
| **«коммитим как есть»** | Дозаписать прогресс в `LEARNING_LOG.md`, синхронизировать дневники, коммит + пуш. |

**Ключевое правило:** каждая сессия — отдельная строка в `STATS.md` с датой. Не путать «сегодня» и «вчера» — `Get-Date` обязателен.

### Главное правило про git
**После каждого завершённого шага — `git add . && git commit -m "step N: <название>" && git push`.** Ученик явно попросил это.

---

## 📋 План курса (26 шагов)

> Подробная программа — в `COURSE_HANDBOOK.md`, раздел «📋 Программа курса AlgoBank».

### Блок 1: Java Core экспресс-повторение (шаги 1-4)
1. **Collections framework** — List/Set/Map, HashMap внутри, ArrayList vs LinkedList
2. **Generics, equals/hashCode, immutability** — value class `Money`
3. **Stream API + Optional + лямбды** — группировка транзакций
4. **Records, sealed, pattern matching (Java 21)**

### Блок 2: AlgoBank — Spring Boot (шаги 5-14)
5. Старт проекта + REST basics
6. DTO + валидация + Luhn-алгоритм
7. JPA entities + репозитории (Account ↔ Transaction)
8. Транзакции (`@Transactional`) + циклы в графе переводов
9. Spring Security basics + проверка силы пароля
10. JWT + реальная аутентификация
11. Spring Data queries (JPQL, Specification) + Top-K транзакций
12. Кэширование + свой LRU-кеш
13. Actuator + логирование + парсинг access-лога
14. Тестирование (`@SpringBootTest`, Testcontainers) + параллельная генерация

### Блок 3: Многопоточность + JVM (шаги 15-17)
15. Thread basics (synchronized, volatile, happens-before) + producer-consumer
16. Executor + Future + CompletableFuture + merge-k-sorted-lists
17. JVM internals (heap/stack, GC) + memory leak

### Блок 4: SQL для собеседования (шаги 18-19)
18. Базовый SQL (JOIN, CTE, GROUP BY) — задачи на данных AlgoBank
19. Оконные функции + индексы + EXPLAIN

### Блок 5: Структуры данных (шаги 20-21)
20. Массивы, списки, стеки, очереди + Valid Parentheses, Min Stack
21. Деревья, кучи, графы + BFS, Kth Largest

### Блок 6: Алгоритмы (шаги 22-24)
22. Два указателя + скользящее окно
23. Рекурсия + backtracking
24. DP + жадные алгоритмы

### Блок 7: Финал (шаги 25-26)
25. LeetCode марафон (10-15 задач подряд с таймером)
26. Финальная шпаргалка + mock-собеседование
