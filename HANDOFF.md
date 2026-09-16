# 🚀 HANDOFF: быстрое восстановление контекста

**Когда читать:** если чат/история потеряна и нужно понять, **что вообще происходит**, за 2 минуты.

Если что-то непонятно — открой `PROGRESS.md` (навигация) и `LEARNING_LOG.md` (теория).

---

## 🎯 Суть курса

- **Ученик:** Василий
- **Цель:** устроиться Java-разработчиком (Middle, универсал)
- **Формат:** ~26-шаговый проект **AlgoBank** — банковский backend
- **Подход:** реальный код + разбор теории + мини-экзамены + **2-3 алгоритмические задачи на шаг**
- **Контекст:** ученик уже завершил Spring Core (12 шагов, ~85%) и в процессе Spring Boot (шаг 9/15) — подробности в `COURSE_HANDBOOK.md`

## 🛠 Проект

- **Язык:** Java 21 (target в `pom.xml`); **в IDEA работает JDK 23.0.1** (Boot 4 совместим)
- **Сборка:** Maven 3.9.9 (по полному пути `C:\tools\apache-maven-3.9.9`)
- **Фреймворк:** Spring Boot **4.0.8** (Boot 4 — новая ветка, не 3.x!)
- **Starter'ы:** `webmvc`, `validation`, `data-jpa`, `security`, `cache`, `actuator`, `flyway`
- **БД:** H2 in-memory (для разработки) + PostgreSQL через Testcontainers (для тестов)
- **IDE:** IntelliJ IDEA, Windows 11
- **Порт:** 8082

## 📊 Текущий статус

- **Шаг:** 4 / 26 (Records, sealed, pattern matching Java 21 — следующий)
- **Дата старта:** 11.09.2026
- **Завершённые шаги:** 0 ✅, 1 ✅ (Collections, 85/100), 2 ✅ (Generics + equals/hashCode/immutability, 89.6/100), 3 ✅ (Stream API + Optional + лямбды + Collectors, 89.5/100)
- **Средний балл за шаг 1:** 85/100
- **Средний балл за шаг 2:** 89.6/100
- **Средний балл за шаг 3:** 89.5/100
- **Всего потрачено:** ~6 ч (инициализация + шаги 1, 2, 3)

### Следующий шаг
- **Шаг 4:** Records, sealed, pattern matching (Java 21) — современный Java, убираем бойлерплейт в DTO

## 🧠 Что изучено

### Шаг 1 (Collections framework, ✅ 11-12.09.2026)
- ArrayList внутри (массив + add(i, x) сдвигает хвост), LinkedList (двусвязный список)
- ArrayList в 2700x быстрее на `get(i)`, в 66x медленнее на `add(0, x)`, ~2x медленнее на `addLast`
- HashMap: массив бакетов, hash → индекс, цепочки → дерево (Java 8+)
- Контракт equals/hashCode: согласованность обязательна, иначе HashMap теряет данные
- Two Sum: HashMap O(n) в 10⁶ раз быстрее brute force O(n²) на n=1M
- Stream API: `Collectors.groupingBy` + `summingLong`/`counting`/`mapping`, `sorted().limit()` для top-K
- `record` — компактный immutable класс (Java 14+)

### Шаг 2 (Generics/equals/hashCode/immutability, ✅ 12-14.09.2026, 89.6/100)
- 2A Generics: `?` (любой тип), `? extends T` (producer — чтение), `? super T` (consumer — запись), PECS
- 2B Money value object: `final class` + `final` поля, `Objects.requireNonNull`, equals через `instanceof` pattern matching, hashCode через `Objects.hash`, `toString` через `toPlainString`
- 2C Account immutable: defensive copy через `List.copyOf` в конструкторе, immutable возврат из геттера
- 2D Money extended: `implements Comparable<Money>`, `add/subtract/multiply`, фабрики `Money.of(...)`, защита от смешивания валют
- String immutability: HashMap ключи + thread-safety + String Pool + security
- **Главное:** `compareTo` должен быть согласован с `equals` (HashSet vs TreeSet дают одинаковый ответ только если согласованы)

### Шаг 3 (Stream API + Optional + лямбды + Collectors, ✅ 14-16.09.2026, 89.5/100)
- 3A Лямбды: функциональные интерфейсы (Consumer, Supplier, Function, BiFunction, Predicate), method references (`::` для статических, экземпляра, конструктора)
- 3B Stream API: 11 операций — `filter`, `map`, `flatMap`, `reduce`, `findFirst`, `mapToInt`, `max`, `joining`. Stream ленивый — операции выполняются при `collect`/`forEach`
- 3C Optional: замена null. `orElseGet(Supplier<T>)` ленивый, `orElse(T)` жадный. `flatMap` распаковывает `Optional<Optional<T>>`
- 3D Collectors: `toList`, `toSet`, `toMap`, `groupingBy(c, downstream)`, `partitioningBy(p)`, `joining`, `counting`, `summingDouble`
- 3E Задача TransactionAnalytics: 5 методов агрегации транзакций — groupingBy с downstream, top-K через sorted+limit, partitioningBy
- **Главное:** Stream и коллекция дополняют друг друга — **Stream для декларативной обработки**, **коллекция для хранения данных**

### Частые ошибки шага 3 (для запоминания)
- `Collectors.toList(mapper)` — НЕТ такого! Только `.map(mapper).collect(Collectors.toList())`
- `peek` логирует КАЖДЫЙ элемент по конвейеру, а не «все элементы одним куском» (lazy + промежуточная операция)
- `!=` для строк → только `.equals()`. Защита от NPE: литерал слева `"WITHDRAW".equals(t.type())`
- `groupingBy(classifier, downstream)` — двухуровневые группировки = один вызов с двумя аргументами, не два отдельных stream'а

См. `LEARNING_LOG.md` — подробные разборы и шпаргалки.

## 📚 Где что лежит

- **`PROGRESS.md`** — навигация, где остановились, что дальше
- **`STATS.md`** — дашборд (время, баллы, процент, мини-экзамены)
- **`LEARNING_LOG.md`** — конспект теории, разборы шагов, копилка фактов + шпаргалки для собеса
- **`OVERALL_STATS.md`** — сводка по всем проектам ученика (Spring Core, Spring Boot, AlgoBank)
- **`COURSE_HANDBOOK.md`** — master-файл с историей и программой AlgoBank

## 🎓 Профиль ученика

См. `COURSE_HANDBOOK.md`, раздел «Профиль обучения». Главное:

- ✅ Заходят длинные разборы с аналогиями, ASCII-схемы, мини-экзамены **без вариантов ответа**
- ✅ Нравится формат **проекта-обёртки** (теория и алгоритмы привязаны к одному живому проекту)
- ✅ Хочет **больше алгоритмических задач** (2-3 на шаг)
- ❌ НЕ давать готовый код классов целиком — только подсказки и направление
- ❌ В вопросах мини-экзаменов **не утекать ответы**
- ⚠️ Слабые места: путает похожие концепции, доверяет недавней памяти, ошибки в формулировках закрепляются → давать сравнительные вопросы и требовать явные таблицы отличий

## 🚨 Инструкция по стилю ответов (обязательно!)

1. **НЕ ЖДАТЬ команд** типа «продолжим» / «коммить» / «обнови файлы». Ученик дал **директиву** → **сразу** её выполняю.
2. **НЕ уточнять** после явных инструкций. Делай → отчитывайся о результате.
3. **Не извиняться за косяки дважды.** Один раз признал → исправил → поехали дальше.
4. Уточняющий вопрос **уместен только** когда есть реальная неоднозначность.
5. **НЕ ПИСАТЬ КОД ЗА УЧЕНИКА.** Давать подсказки, направление, шпаргалки — но финальный код пишет сам ученик. Исключение: мелкие правки в `*.md` (HANDOFF, LOG, STATS) и `git commit/push`.
6. **Get-Date перед паузой/окончанием** — никогда не угадывать время.

## 📝 Где живут алгоритмические задачи

> Алгоритмические задачи **решаются учеником самостоятельно** в пакете `ru.algobank.algo.<step>` (например, `ru.algobank.algo.step01` для шага 1).

Структура папок (после прохождения шагов):
```
src/main/java/ru/algobank/
├── AlgoBankApplication.java
├── controller/
├── service/
├── repository/
├── domain/
├── dto/
├── config/
└── algo/
    ├── step01/   (задачи шага 1)
    ├── step02/   (задачи шага 2)
    └── ...
```

Каждая задача — отдельный класс с `main` методом или JUnit-тестами для проверки.
