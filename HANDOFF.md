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

- **Шаг:** 5 / 26 (Spring Boot REST basics — **почти закрыт:** 5A/5B/5C ✅, задачи ✅ (FizzBuzz 90, BankGreeter 95, первые JUnit-тесты), артефакты ✅ в коммите `1b67465` (README, CI, PNG+SVG-схемы → main); осталось: git-тег `step-05` + время дня в STATS; шаг 4 ✅ 17.09.2026)
- **Дата старта:** 11.09.2026
- **Завершённые шаги:** 0 ✅, 1 ✅ (Collections, 85/100), 2 ✅ (Generics + equals/hashCode/immutability, 89.6/100), 3 ✅ (Stream API + Optional + лямбды + Collectors, 89.5/100), 4 ✅ (Records + sealed + pattern matching, 89.0/100, экзамен 56/100)
- **Средний балл за шаг 1:** 85/100
- **Средний балл за шаг 2:** 89.6/100
- **Средний балл за шаг 3:** 89.5/100
- **Всего потрачено:** **~19.7 ч** (шаг 0–3 с ×1.85 коэффициентом: 14.5 ч; шаг 4 по факту без коэффициента: 1.4 ч; ночная сессия 17.09 по git-окну: 1.8 ч; вечер 18.09–ночь 19.09 (5C + задачи + тесты): 2.0 ч)
- **Средний балл за шаг 4 (экзамен):** 56/100 (пробелы: exhaustiveness в switch, when-guards)

### Следующий шаг (продолжение шага 5)
- ✅ Разминка-ретест шага 4 проведена 17.09: **38/60** — `record pattern` остался в ротации повторения (давать в разминках)
- ✅ Разминка 19.09 (старт сессии): record pattern **75** → снят с ротации; пирамида конфигов **90** → снята; `orElse` vs `orElseGet` — «не помню» → **разобрано заново, в ротации повторения**
- ✅ **5A** (автоконфигурация + первая 401 → SecurityConfig `permitAll`) и **5B** (`/api/hello` JSON + H2-консоль после двойного бага: лямбда-пустышка `PathRequest.toH2Console()` и модуль `spring-boot-h2console` в Boot 4)
- ⏳ **5C:** `application.yml` — пирамида приоритетов (CLI > -D > env > профильный yml > общий yml > дефолты), relaxed binding, `ServerProperties`. Роздано задание 5Cα «война портов» (--server.port=9099) + 2 экзамен-вопроса (кто победит из 3 источников; что без `spring.profiles.active`) — ✅ закрыто 19.09: разм.№3=75, экзамен-1 (пирамида)=70, экзамен-2 (профили)=60; практика «война портов» подтверждена логами (CLI 9099 победил, без аргумента — 8082). Найденное: `application-dev.yml` вообще не существует — dev-профиль пустой, строка `spring.profiles.active: dev` висит на будущее
- ✅ Задачи: FizzBuzz (90/100; мёртвый requireNonNull на примитиве — удалён после разбора) + BankGreeter (95/100; null-check левее ||, isBlank vs isEmpty верно) — первые JUnit 5 тесты: FizzBuzzTest 4/4 ✅, BankGreeterTest 4/4 ✅. Мелкий todo: переименовать тесты BankGreeterTest в поведенческий стиль
- ✅ Артефакты (коммит `1b67465`, запушен в main): README.md + PNG-схема ученика → `docs/architecture-step05.png` + SVG-схема целевых слоёв `docs/architecture-step06-07.svg` + `.github/workflows/ci.yml` (maven verify, JDK 21 temurin). ⏳ Осталось: git-тег `step-05` (ставится при закрытии дня)
- 🆕 Новые практики с шага 5 (правила №11-16 в LEARNING_LOG): разминка-квиз на старте сессии, JUnit-тест к каждой задаче, git-теги шагов
- ✅ Security-ловушка сыграна: первый запрос дал 401 → разобрали и временно починили SecurityConfig'ом; по-честному Security — шаг 9, JWT — шаг 10

### Сессия 19.09 — продолжение (вечер)

| Действие | Корректировка времени | Примечание |
|----------|:---------------------:|------------|
| **Пауза №1:** 11:00 → 13:30 | **-2 ч 30 мин** | метки задним числом |
| **Пауза №2:** 14:06 → 19:01 | **-4 ч 55 мин** | метки живые (`Get-Date`), в файлах ранее не зафиксированы — исправлено здесь |
| **Пауза №3:** 20:35 → ⏸️ **активна** | не закрыта | закроется по команде «продолжаем» → `Get-Date` |

- **Старт сессии:** 10:26 (реальное `Get-Date`); итог дня — точный расчёт при «закончили на сегодня»
- **Разбор «зачем Service»:** ответ №1 = 60/100 → письменный повтор = 85/100; вопрос («зачем Service» + «где граница транзакции») в **ротации разминок**; детали — LEARNING_LOG, «Разбор "зачем нужен Service?"»
- **Артефакты шага 5 запушены:** коммит `1b67465` → main (README, CI, PNG+SVG-схемы)
- **Осталось до закрытия шага 5:** git-тег `step-05` + время дня в `STATS.md`
- **Следующая активность:** шаг 6 — REST CRUD над `Account` (DTO, `@Valid`, ProblemDetails, Service-слой) по программе COURSE_HANDBOOK; разминка на старте: `orElse` vs `orElseGet` + «зачем Service / где граница транзакции»
- ⚠️ **Docker не установлен** — шаг 7 начнётся с установки Docker Desktop (WSL2)

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

### Шаг 4 (Records, sealed, pattern matching, ✅ 17.09.2026, средний 89.0/100)
- 4A: `record Deposit(String user, BigDecimal amount, LocalDate date)` + `sealed interface Transaction permits Deposit, Withdraw, Transfer` + default-метод `isLarge()`
- 4B: switch pattern matching БЕЗ `default` (`describe`, `opKind`, `toCsv`) — компилятор сам проверяет exhaustiveness по sealed-иерархии
- 4C: record patterns + `when`-guards в `summarize()` + `Collectors.groupingBy(SealedTransaction::summarize, counting())`
- Экзамен **56/100** — пробелы: exhaustiveness (неполные ветки без `default` НЕ компилируются), `when`-guards vs `if` в теле case

### Частые ошибки шага 3 (для запоминания)
- `Collectors.toList(mapper)` — НЕТ такого! Только `.map(mapper).collect(Collectors.toList())`
- `peek` логирует КАЖДЫЙ элемент по конвейеру, а не «все элементы одним куском» (lazy + промежуточная операция)
- `!=` для строк → только `.equals()`. Защита от NPE: литерал слева `"WITHDRAW".equals(t.type())`
- `groupingBy(classifier, downstream)` — двухуровневые группировки = один вызов с двумя аргументами, не два отдельных stream'а

### Частые ошибки шага 4 (для запоминания)
- switch по sealed-типу НЕ скомпилируется с неполным набором ветвей — нужны все permitted-типы или `default`
- `when` — часть case-паттерна: провал гарда → идём в следующий case; `if` в теле — уже после выбора ветки
- record pattern `case Transfer(var from, var to, ...)` безопаснее `case Transfer tx` — порядок компонентов фиксирован компилятором, опечатки вида `tx.to()` вместо `tx.from()` исключены

### Шаг 5 (в работе, 17.09.2026 — факты для запоминания)
- **Boot 4 модульный:** H2-консоль живёт в отдельном артефакте `org.springframework.boot:spring-boot-h2console`; без него `spring.h2.console.enabled=true` молча игнорируется. Похожий вынос: web-сервер в `spring-boot-web-server` (там лежит `ServerProperties`)
- **Отладка Security:** дефолтная форма логина прячет реальный 404 → `permitAll` как временный отладочный приём обнажает истинную ошибку (сервлета консоли не было в classpath)
- **void-совместимость лямбд:** `frame -> PathRequest.toH2Console()` компилируется, но возвращаемое значение выбрасывается (лямбда-пустышка) — классический кейс собеса
- H2-консоль рендерится в `<frameset>` → нужен `frameOptions().sameOrigin()` (DENY по умолчанию от Spring Security)

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
