# 📋 Прогресс: контекст и навигация

Здесь — **только** то, что нужно для быстрого входа в работу: где остановились, что дальше, шпаргалка для следующего открытия.

**Цифры, время, баллы — в `STATS.md`.**
**Конспект теории — в `LEARNING_LOG.md`.**
**Краткое резюме (если история слетит) — в `HANDOFF.md`.**
**Сводка по всем проектам — в `OVERALL_STATS.md`.**
**Программа курса + история — в `COURSE_HANDBOOK.md`.**

---

## 📌 Где мы сейчас

**Текущий шаг:** 1 / 26 (Collections framework — экспресс-повторение Java Core)
**Прогресс шага 1:** A ✅ / B ⏳ / C ⏳ / D ⏳
**Процент:** 0% (0/26)

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
- ⏳ **D** — задача №2 (группировка Stream, easy/medium) — следующий
- ⏳ Мини-экзамен: 1 вопрос без вариантов

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
