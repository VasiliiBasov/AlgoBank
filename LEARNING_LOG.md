# 📓 Learning Log — дневник теории

Сюда пишем **всё**: разборы шагов, новые концепции, шпаргалки для собеса, открытия, ошибки.

**Формат (v2, по аналогии с SpringBootProject):**
- `## Шаг N: <название>` — заголовок шага
- Под ним: **микро-шаги (теория порциями + микро-задания ученика) → задачи → мини-экзамен → итог**
- Каждый микро-шаг: 1-2 абзаца теории + 1 микро-задание ученику («создай класс X» / «запусти вот так» / «пришли вывод»)
- Задачи (2-3 на шаг): условие → решение ученика → разбор ассистента
- Мини-экзамен — **после** всех микро-шагов и задач, проверяет итог
- Шпаргалки для собеса — в конце файла, таблицей

---

## Шаг 0: Служебный — инициализация проекта (сделано 11.09.2026)

### Что сделали

- Разведали состояние `Algoritm/`: каталог и `pom.xml` есть, но это **Maven Archetype**-артефакт (`archetype-resources/`, `META-INF/maven/`), не реальный проект
- Удалили артефакты архетипа (`archetype-resources/`, `META-INF/`)
- Создали нормальный `pom.xml` (Spring Boot 4.0.8 parent, Java 21, все нужные стартеры)
- Обновили `.gitignore` (target, IDE, env, H2 data, logs)
- Создали `AlgoBankApplication.java` (стандартный `SpringApplication.run`)
- Создали `application.yml` (порт 8082, H2 in-memory, Flyway, Actuator, профиль dev)
- Создали структуру пакетов под алгоритмические задачи
- Создали 6 файлов-дневника: `HANDOFF.md`, `PROGRESS.md`, `STATS.md`, `LEARNING_LOG.md`, `OVERALL_STATS.md`, `COURSE_HANDBOOK.md`
- Инициализировали git, сделали первый коммит

### Концепция AlgoBank

> **Главная идея:** всё, что нужно для собеса (Spring + Java Core + алгоритмы + SQL), изучается **внутри одного живого проекта** — банковского backend.

Банковский домен выбран потому что:
- ✅ Естественные структуры данных (счета, транзакции, иерархия клиентов)
- ✅ Алгоритмы из реальной жизни (обнаружение мошенничества, циклы переводов, топ клиентов)
- ✅ Понятные бизнес-фичи (регистрация, переводы, история, аналитика)
- ✅ Хорошо ложится на Spring (REST API, JPA, Security, Cache)
- ✅ Можно показать на собесе как pet-project

### На что обратить внимание перед шагом 1

- Java Core помнить нужно подтянуть (JavaRush 4 года назад)
- Алгоритмические задачи решаются в пакете `ru.algobank.algo.step01`+ — ученик пишет сам, ассистент даёт подсказки
- Мини-экзамен после каждого шага — без вариантов ответа
- `Get-Date` для времени, никогда не угадывать

---

## 📌 Педагогические правила курса AlgoBank (обновлено 11.09.2026)

> Уточнения ученика, **обязательные к исполнению** всеми ассистентами курса.

### 1. Алгоритмические задачи — ученик решает сам
- Ассистент даёт **условие + подсказки + направление**, но **не пишет код задач целиком**
- Исключение: мелкие правки в `*.md`, шпаргалки, иногда 1-2 строки в коде (например, сигнатура метода)

### 2. 2-3 задачи на шаг
- Easy + Medium, иногда Hard для топ-компаний
- Задачи привязаны к домену AlgoBank (банковские операции)
- Это **главная фишка** курса — теория + задачи внутри одного проекта

### 3. Мини-экзамены без вариантов ответа, без утечек
- Ученик сам формулирует ответ
- В вопросах и пояснениях к ним ответа быть не должно
- «Идея на пальцах» (объяснение новой темы) может содержать ответы — это нормально

### 4. Теория и практика вплетены (v2-формат)
- ❌ Неправильно: «Теория блоком → ученик читает → мини-экзамен → коммит»
- ✅ Правильно: каждый кусок теории сопровождается микро-заданием ученику

### 5. `Get-Date` перед паузой/окончанием
- Никогда не угадывать время

### 6. Не угадывать усталость
- Ждать явных команд «пауза» / «закончили на сегодня»

### 7. Git commit после каждого шага
- Страховка от потери прогресса
- Коммит + пуш обязательны

### 8. Только фактическое время — никаких «на глаз» (правило с 16.09.2026)
- Любая запись в дневники про время — только через `Get-Date -Format 'yyyy-MM-dd HH:mm:ss'`
- **v2 (16.09.2026):** всё между «продолжим» и «пауза»/«закончили на сегодня» — **рабочее время** (чтение, написание, размышление), даже если ученик молчит
- Включая оценки: «заняло ~5 мин» считаем как `[Get-Date_2] − [Get-Date_1]` (в формате HH:mm)
- Если забыл зафиксировать время — пишем «оценочно», а не подставляем круглую цифру
- **Старые данные (до 16.09.2026) скорректированы коэффициентом ×1.85** (учёт реальной работы, разборов, чтения). Было 7.9 ч → стало 14.7 ч. Все цифры в дневниках пересчитаны.

### 9. Никаких коэффициентов вперёд (правило с 16.09.2026)
- Коэффициент ×1.85 — **только для шагов 0-3** (ретроспективно).
- Для шага 4 и далее — **только фактическое время по `Get-Date`**, без повышающих коэффициентов.
- Если забыл зафиксировать время — пиши «оценочно», не умножай.

### 10. Профиль ученика
- ✅ Заходят: длинные разборы с аналогиями, ASCII-схемы, проекты-обёртки, много задач
- ❌ Не заходят: готовый код классов целиком, варианты A/B/C/D, мало задач
- ⚠️ Слабые места: путает похожие концепции, доверяет недавней памяти, ошибки в формулировках закрепляются → давать сравнительные вопросы и требовать явные таблицы отличий

### 11. Разминка в начале сессии (spaced repetition, с 17.09.2026)
- Каждая сессия начинается с 3 вопросов из ПРОШЛЫХ шагов (ротация), ~5 минут, без конспекта
- Цель: лечить «доверие недавней памяти» интервальным повторением
- Ближайшая разминка: ретест шага 4 (exhaustiveness в switch, when-guards, record patterns)

### 12. Mock-собеседование каждые ~5 шагов (с 17.09.2026)
- После шагов 8, 14, 19, 24 + финал на шаге 26
- 15 минут, письменные ответы, без конспекта, без вариантов ответа
- Цель: тренировать формулировки под нагрузкой (слабость: ошибки в формулировках закрепляются)

### 13. JUnit-тест к каждой задаче (с шага 5)
- Каждая algo-задача/микро-шаг сопровождается 1-2 тестами, которые пишет ученик
- Папка `src/test/java/ru/algobank/...` зеркалит `main`
- К шагу 14 (тестирование) JUnit уже должен быть привычным инструментом, а не новинкой

### 14. ASCII-схема архитектуры после backend-шагов (с шага 5)
- После шагов 5, 7, 9, 11, 13 ученик САМ дорисовывает схему «запрос → контроллер → сервис → БД»
- Схема живёт в этом файле, в секции соответствующего шага

### 15. Намеренная мина (AI-код-ревью, с 17.09.2026)
- Ассистент иногда встраивает осмысленный баг в пример/подсказку — ученик ревьюит и ищет
- Прецедент: `tx.to()` вместо `tx.from()` в шаге 4 — ученик нашёл и починил сам
- Современный навык: ревью сгенерированного кода, а не слепое Ctrl+C/Ctrl+V

### 16. Git-теги на завершение шага
- Коммит завершения шага помечается тегом `step-NN` (например, `step-04`)
- Ретро-теги поставлены 17.09.2026: step-00 … step-04

---

## 📋 Структура папок проекта (план)

```
AlgoBank/
├── pom.xml
├── README.md
├── .gitignore
├── COURSE_HANDBOOK.md       ← master-файл
├── HANDOFF.md               ← краткое резюме
├── PROGRESS.md              ← навигация
├── STATS.md                 ← дашборд
├── LEARNING_LOG.md          ← этот файл
├── OVERALL_STATS.md         ← сводка
├── INTERVIEW_CHEATSHEET.md  ← (создаётся на шаге 26)
└── src/
    ├── main/
    │   ├── java/ru/algobank/
    │   │   ├── AlgoBankApplication.java
    │   │   ├── controller/
    │   │   ├── service/
    │   │   ├── repository/
    │   │   ├── domain/
    │   │   ├── dto/
    │   │   ├── config/
    │   │   └── algo/
    │   │       ├── step01/   (задачи шага 1)
    │   │       ├── step02/
    │   │       └── ...
    │   └── resources/
    │       ├── application.yml
    │       └── db/migration/
    └── test/
        └── java/ru/algobank/
```

---

---

## Шаг 1: Collections framework (✅ 11-12.09.2026, 85/100)

### 1A: ArrayList vs LinkedList benchmark (11.09.2026)
- ArrayList внутри — массив, `add(0, x)` сдвигает хвост на n-1 элементов вправо → O(n)
- LinkedList внутри — двусвязный список, `add(0, x)` O(1), но `get(i)` O(i)
- **Замеры на n=10⁵:** `get(i)` ArrayList 2700x быстрее, `add(0,x)` ArrayList 66x медленнее, `addLast` ArrayList ~2x медленнее
- **Cache locality:** ArrayList — contiguous memory, CPU prefetcher работает
- **Вердикт:** для Account.transactions — ArrayList (чтений больше)

### 1B: HashMap playground (11.09.2026)
- `Map<String, Long>` с балансами клиентов
- HashMap: массив бакетов, hash → индекс через `hash & (capacity-1)`, цепочки → дерево при 8+ коллизиях
- **Контракт equals/hashCode:** `a.equals(b) → a.hashCode() == b.hashCode()` обязательно
- **Нарушение:** HashMap ищет в другом бакете → null, данные потеряны

### 1C: Two Sum (12.09.2026)
- **HashMap O(n):** `for i: if map.contains(target-i) → return; map.put(nums[i], i)`
- **Brute force O(n²):** два вложенных цикла
- **На n=10⁶:** HashMap 10⁶ оп vs brute force 10¹² → в 10⁶ раз быстрее

### 1D: Transaction grouping (12.09.2026)
- `record Transaction(String client, String type, long amountKopecks)` — immutable POJO
- Stream: `groupingBy(type, summingLong(amountKopecks))`, `groupingBy(client, counting())`, `sorted+limit` для top-K

### Мини-экзамен шага 1 (85/100)
- ArrayList vs LinkedList для Account.transactions → ArrayList ✅
- **Не хватало:** cache locality + memory layout

---

## Шаг 2: Generics, equals/hashCode, immutability (✅ 12-14.09.2026, 89.6/100)

### 2A: Generics playground (12.09.2026, 80/100)
- **`List<?>`** — любой тип, можно читать (Object), нельзя писать
- **`List<? extends Number>`** — producer, читаем Number, писать нельзя
- **`List<? super Integer>`** — consumer, пишем Integer, читаем только Object
- **PECS:** Producer Extends, Consumer Super
- **Type erasure:** в рантайме `List<String>` = `List<Object>`
- **Почему нельзя `new T()`:** после стирания `T` = `Object`, не знаем тип
- **Решения:** `Class<T>`, `Supplier<T>`, reified generics (Kotlin)
- **Ошибка ученика:** `addIntegers(List<? super Number>)` вместо `? super Integer` — работало из-за авто-боксинга, но семантика неправильная

### 2B: Money value object (12.09.2026, 95/100)
- **`final class Money`** — запрет наследования
- **`final` поля** + `Objects.requireNonNull` в конструкторе
- **equals через pattern matching** (Java 16+): `if (!(o instanceof Money money)) return false;`
- **hashCode:** `Objects.hash(...)`
- **toString:** `amount.toPlainString()` — без экспоненты
- **Нюанс BigDecimal:** `new BigDecimal("100.50").equals(new BigDecimal("100.5"))` → false. Для денег правильнее `compareTo(...) == 0`
- **Почему final на классе:** иначе `BonusMoney extends Money` ломает симметричность → HashMap теряет данные

### 2C: Account immutable (13.09.2026, 85/100)
- **Defensive copy в конструкторе:** `this.history = List.copyOf(history);` — копия + immutable
- **Альтернативы:** `Collections.unmodifiableList(new ArrayList<>(history))` (копия + view), `Collections.unmodifiableList(history)` (только view, ОПАСНО)
- **Безопасный геттер:** `return history;` (уже immutable)
- **Иммутабельность = thread-safety бесплатно**
- **Иммутабельность = кэшируемый hashCode**
- **Забыл `final` на классе** — без него можно сломать контракт
- **String immutability причины:** HashMap + thread-safety + **String Pool** (главная) + security
- **HashMap/HashSet/LinkedHashMap/Hashtable/IdentityHashMap/WeakHashMap/ConcurrentHashMap** — все используют hashCode
- **TreeMap/TreeSet** — НЕ используют, используют compareTo

### 2D: Money extended (13.09.2026, 95/100)
- **`Comparable<Money>` + `@Override compareTo`** — сортировка через `Collections.sort`, TreeSet, PriorityQueue
- **Контракт compareTo:** отрицательный/ноль/положительный; транзитивность; консистентность; согласованность с equals (РЕКОМЕНДУЕТСЯ)
- **Integer vs IllegalStateException:** аргументы → `IllegalArgumentException`, состояние объекта → `IllegalStateException`
- **`requireSameCurrency` в compareTo:** без неё `100 RUB == 100 USD` → TreeSet потеряет элементы, sort упадёт
- **Статические фабрики:** `Money.of(String, String)` удобнее конструктора + `Money.zero(Currency)`
- **`BigDecimal.ZERO`** вместо `new BigDecimal(0)` — идиоматичнее
- **BigDecimal vs double:** double — IEEE 754 приближённое (`0.1 + 0.2 = 0.30000000000000004`), BigDecimal — точное, для денег обязательно
- **Нюанс BigDecimal scale:** `100.50.equals(100.5)` = false, но `100.50.compareTo(100.5) == 0`. Для денег правильнее compareTo

### Мини-экзамен шага 2 (14.09.2026, 93/100)
- **Q1 HashSet vs TreeSet с согласованным compareTo** — 10/10: «не будет разницы, т.к. compareTo согласован с equals»
- **Q2 requireSameCurrency** — 8/10: «100 RUB == 100 USD было бы неверное сравнение». Не упомянул TreeSet потеряет элементы
- **Q3 ImmutablePoint код** — 10/10: правильный код, корректный вывод

### Шпаргалки для собеса

#### HashCode & Equals
- **Контракт:** `a.equals(b) → a.hashCode() == b.hashCode()` (обратное НЕ обязательно)
- **Шаблон equals:** `this == o → true; o instanceof T t → fields; else → false`
- **Шаблон hashCode:** `Objects.hash(field1, field2, ...)`
- **HashMap:** hash → bucket index через `hash & (n-1)`, цепочки → дерево при 8+
- **Коллизия:** разные hashCode → один bucket. По hash ищем bucket, по equals — внутри

#### Immutability
- **Правило:** `final` класс + `final` поля + `Objects.requireNonNull` + defensive copy для mutable
- **Defensive copy:** вход `List.copyOf(...)` или `new ArrayList<>(...)`, выход `List.copyOf` или `Collections.unmodifiableList`
- **Где:** ключи в HashMap, thread-safe без synchronized, кэшируемый hashCode
- **String immutability:** String Pool + HashMap + thread-safety + security

#### Generics
- **Wildcards:** `?` (любой), `? extends T` (producer), `? super T` (consumer)
- **PECS:** Producer Extends, Consumer Super
- **Type erasure:** в рантайме тип стёрт
- **Нельзя:** `new T()`, `new T[size]`, `instanceof T` (с типом, не wildcard)
- **Можно:** `Class<T>`, `Supplier<T>`, reified (Kotlin)

#### Comparable vs Comparator
- **Comparable:** в самом классе, `implements Comparable<T>`, `int compareTo(T other)`, один «естественный» порядок
- **Comparator:** отдельный класс/лямбда, `int compare(T a, T b)`, сколько угодно порядков
- **compareTo контракт:** знак, транзитивность, консистентность, NPE на null, **согласованность с equals (рекомендуется)**
- **Comparable даёт бесплатно:** `Collections.sort`, `list.sort(null)`, `TreeSet`, `TreeMap`, `PriorityQueue`, `stream.sorted()`
- **Нарушение согласованности:** BigDecimal — `HashSet` size=2, `TreeSet` size=1 (классический пример)
- **IllegalArgumentException** vs **IllegalStateException:** аргументы метода vs состояние объекта

---

*Обновлено 14.09.2026 после мини-экзамена шага 2.*
## Шаг 3: Stream API + Optional + лямбды + Collectors (14-16.09.2026, 89.5/100)

### Что прошли

**3A — Лямбды и method references**
- Функциональные интерфейсы: Consumer<T>, Supplier<T>, Function<T,R>, BiFunction<T,U,R>, Predicate<T>, BiPredicate<T,U>
- Лямбды: (args) -> { body }, типы выводятся, return обязателен только в { } форме
- Method references: :: для статических методов, методов экземпляра, конструкторов (ClassName::new)

**3B — Stream API**
- Создание: Collection.stream(), Stream.of(T...), Stream.builder(), IntStream.range()
- Промежуточные (lazy): filter, map, flatMap, sorted, distinct, peek, limit, skip
- Терминальные: collect, forEach, findFirst, count, min/max, reduce, anyMatch/allMatch/noneMatch
- Специализированные: mapToInt/Long/Double + sum, average, max, min, summaryStatistics
- Lazy: все операции выполняются только при терминальной. Каждый элемент проходит конвейер по одному.
- Одноразовый: Stream нельзя переиспользовать после терминальной операции

**3C — Optional**
- Создание: Optional.of(T) (не null), Optional.ofNullable(T), Optional.empty()
- Достать: get() (опасно), orElse(T) (жадно), orElseGet(Supplier<T>) (лениво), orElseThrow()
- Преобразования: map, filter, flatMap (для Optional<Optional<T>>), ifPresent(Consumer)
- Защита: "x".equals(maybeNull) — литерал слева, чтобы не получить NPE
- Главная мысль: Optional — это контейнер «может быть пусто», а не замена null

**3D — Collectors**
- Коллекции: toList, toSet, toMap(keyMapper, valueMapper, mergeFunction)
- Группировки: groupingBy(classifier), groupingBy(classifier, downstream) — двухуровневые
- Разбиение: partitioningBy(predicate) — всегда 2 ключа (true/false)
- Агрегация: counting, summingInt/Long/Double, averagingInt/Long/Double, summarizingInt/Long/Double
- Составные: mapping(mapper, downstream) — mapper + downstream коллектор
- Поиск: maxBy(comparator), minBy(comparator) → возвращают Optional<T>

**3E — TransactionAnalytics (5 методов)**
- countByUser: groupingBy(user, counting())
- balanceByUser: два stream по DEPOSIT и WITHDRAW, потом Map.merge или for-цикл
- top3Active: groupingBy(user, summingDouble) + entrySet().stream().sorted(comparingByValue().reversed()).limit(3)
- firstTransactionOfDay: groupingBy(localDate, minBy(comparing(time)) + .mapValues(Optional::get) (Java 16+) или entrySet().stream().collect(toMap)
- suspiciousUsers: max(time) → oneHourAgo → filter WITHDRAW && time>=oneHourAgo → counting → filter >3 → Set<String>

### Шпаргалка: 8 самых важных коллекторов

| Коллектор | Результат | Пример |
|-----------|-----------|--------|
| Collectors.toList() | List<T> | список строк |
| Collectors.toSet() | Set<T> | уникальные id |
| Collectors.toMap(k, v) | Map<K,V> | id→name |
| Collectors.groupingBy(c) | Map<K, List<T>> | группировка |
| Collectors.partitioningBy(p) | Map<Boolean, List<T>> | разделение да/нет |
| Collectors.joining(s) | String | CSV |
| Collectors.counting() | Long | счётчик |
| Collectors.summingDouble(m) | Double | сумма |

### Шпаргалка: Stream vs коллекция

| | Коллекция | Stream |
|---|---|---|
| Цель | Хранение | Обработка |
| Изменяемость | Да | Нет |
| Итерация | Внешняя | Внутренняя |
| Повторное использование | Сколько угодно | Один раз |
| Lazy | Нет | Да |
| Размер | Известен | Нет (или бесконечный) |
| API | add, remove, get, size | filter, map, collect |

### Мини-экзамен: 5 вопросов, 74/100

| # | Тема | Оценка | Главная ошибка |
|---|------|--------|----------------|
| 1 | Stream базовые | 8/10 | Collectors.toList(mapper) — нет такого, нужен .map(mapper) |
| 2 | Stream vs коллекция | 8/10 | не хватило lazy/eager упоминания |
| 3 | Lazy / peek | 5/10 | peek1: abcd — должно быть каждый элемент 2 раза |
| 4 | Optional | 10/10 | идеально |
| 5 | Вложенные Collectors | 6/10 | синтаксис groupingBy с downstream не уверенно |

### Копилка фактов для собеса

- Stream не мутирует источник — все операции чистые функции
- peek — для отладки, в продакшене используй forEach или map
- findFirst() возвращает Optional<T> — даже если лист не пустой, поток может быть пустым
- Collectors.toList() vs Stream.toList() (Java 16+) — последний immutable
- Параллельный stream: .parallelStream() — НЕ всегда быстрее
- flatMap — выравнивание вложенных структур (Stream<Stream<T>> → Stream<T>)
- Optional не serializable (не передаётся через сеть)
- Empty Optional не значит null — empty это «значение отсутствует», нормальный результат

### Сделанные ошибки для запоминания

1. != для строк в balanceByUser → поправил на .equals(). Привычка: литерал слева.
2. Collectors.toList(String::toUpperCase) в мини-экзамене → перепутал где преобразование делается. Привычка: .map(...) всегда перед .collect(...).
3. peek в мини-экзамене → peek не «раз логирует», а для каждого элемента в конвейере. Привычка: видишь два peek = два дебага в потоке.

---

## Шаг 4: Records, sealed, pattern matching (Java 21) (✅ 17.09.2026 — микро-шаги 100/100/100, экзамен 56/100)

> Записано пост-фактум по коду и коммитам (`e70fc72` → `5edb075` → `ea40155` → `bddf1de`): сессия была ускоренной (весь шаг за ~1.4 ч), разбор короче обычного.

### 4A: Records + sealed (17.09.2026)
- `record Deposit(String user, BigDecimal amount, LocalDate date)` — компоненты неявно `private final`; accessors `user()`/`amount()` (БЕЗ `get`-префикса)
- `sealed interface Transaction permits Deposit, Withdraw, Transfer` — закрытая иерархия; наследник обязан быть `final` / `sealed` / `non-sealed` (record — всегда final)
- В sealed-интерфейсе можно держать default-методы: `default boolean isLarge()` с порогом 100000
- Автогенерация: канонический конструктор, `equals`/`hashCode`/`toString` — котелок бойлерплейта исчезает

### 4B: Record patterns + when-guards (17.09.2026)
- Распаковка прямо в case: `case Transfer(var from, var to, var amount, var date) when amount.compareTo(BIG) > 0 -> ...`
- **`when` — часть паттерна:** гард не прошёл → проверяется СЛЕДУЮЩИЙ case. `if` в теле — проверка уже ПОСЛЕ выбора ветки (провал = выход из switch)
- switch по sealed-типу без `default`: компилятор знает иерархию и требует ПОЛНОЕ покрытие (exhaustiveness)

### 4C: Stream + groupingBy + method reference (17.09.2026)
- `txs.stream().collect(Collectors.groupingBy(SealedTransaction::summarize, Collectors.counting()))`
- Классификатор `::summarize` внутри себя использует switch с record patterns — современный стек Java 21 одной связкой
- Файл: `src/main/java/ru/algobank/algo/step04/SealedTransaction.java`

### Шпаргалка: records / sealed / switch pattern matching

| Фича | Синтаксис | Подводный камень |
|---|---|---|
| record | `record Deposit(String user, BigDecimal amount, LocalDate date) {}` | accessor `user()`, не `getUser()`; компоненты `private final` |
| компактный конструктор | `public Deposit { Objects.requireNonNull(user); }` | присваивание полям делает компилятор; руками `this.user = ...` НЕ пишем |
| sealed | `sealed interface Transaction permits Deposit, Withdraw, Transfer {}` | наследник обязан быть `final` / `sealed` / `non-sealed`; permits — только прямые наследники |
| switch PM (тип) | `case Deposit d -> ...` | exhaustiveness: для sealed — все ветви ИЛИ `default`; без этого НЕ компилируется |
| record pattern | `case Transfer(var f, var t, var a, var d) -> ...` | порядок `var` = порядку компонентов record |
| when-guard | `case Deposit d when d.amount().compareTo(X) > 0 -> ...` | гард внутри паттерна: провал → следующий case; `if` в теле — уже после выбора |
| `case null` | `case null -> ...` | без него `switch(null)` падает с NPE |

### Мини-экзамен: 5 вопросов, 14/25 = 56/100

| # | Тема | Оценка | Главная ошибка |
|---|------|--------|----------------|
| 1 | record (синтаксис) | 4/5 | мелочь в формулировке |
| 2-5 | sealed, exhaustiveness, record pattern, when vs if | 10/20 суммарно | exhaustiveness: думал, что скомпилируется без `default` при неполных ветках; when-guards vs `if` внутри case — путаница в моменте проверки |

(По-вопросный разбор 2-5 утерян вместе с контекстом сессии; зафиксированы итог и пробелы — этого достаточно для ретеста.)

### Решение по итогам экзамена
- ✅ **Ретест на старте шага 5 — проведён 17.09.2026: 38/60.** Темы: exhaustiveness в switch, when vs if, record patterns. `record pattern` остался в ротации повторения (давать в разминках следующих сессий)
- Правило курса усвоено заново: ошибка → письменный правильный ответ → ретест

### Сделанные ошибки для запоминания
1. Баг `tx.to()` → `tx.from()` в `summarize()` — при `case Transfer tx` опечатка ловится только глазами; при record pattern `case Transfer(var from, var to, ...)` её просто негде сделать
2. «Switch скомпилируется и без полного покрытия» — НЕТ: для sealed-типа компилятор требует все ветви или `default`

---

---

## Шаг 5: Старт Spring Boot + REST basics (в работе, 17.09.2026)

### 5A: @SpringBootApplication, автоконфигурация, встроенный Tomcat
- Сыграна 🪤 Security-ловушка: `security`-стартер в classpath → первый `GET /api/hello` встретила форма логина (401 за ней). Плановый разбор Security — шаг 9, пока временный конфиг
- Ученик написал `ru.algobank.config.SecurityConfig`: `anyRequest().permitAll()`, `csrf.disable()`, TODO про JWT на шаге 9

### 5B: HelloBankController + H2-консоль (двойной баг!)
- `HelloBankController` (`@RestController`, `@GetMapping("/api/hello")`) + record `Greeting(String app, String message, Instant timestamp)` → JSON, timestamp с nanos (Jackson JavaTimeModule)
- **Баг №1 (код):** `.frameOptions(frame -> PathRequest.toH2Console())` — лямбда-пустышка: method invocation в теле совместим с void-функциональным интерфейсом, возвращаемое значение выброшено → frameOptions остался DENY. Фикс: `frame -> frame.sameOrigin()`
- **Баг №2 (Boot 4 модульность):** H2-консоль вынесена из spring-boot-autoconfigure в отдельный артефакт `org.springframework.boot:spring-boot-h2console` — без него `spring.h2.console.enabled=true` игнорируется. Добавлена в pom.xml (без версии, управляет BOM). Проверка: «Test successful» (`jdbc:h2:mem:algobank`, user `sa`, пустой пароль)
- Рефрейминг: `permitAll` — отладочный приём: убрал security-ширму → обнажился истинный 404 (сервлета консоли в classpath просто не было)

### 5C: application.yml вглубь (✅ закрыт 18-19.09.2026)
- **Пирамида приоритетов:** CLI `--key=val` > JVM `-Dkey=val` > OS env (`SERVER_PORT`) > `application-dev.yml` (профильный) > `application.yml` (общий) > дефолты автоконфигурации. Мнемоника: «чем ближе к запуску — тем сильнее»
- **Relaxed binding:** `server.port` ⇄ `SERVER_PORT` (env: точки → `_`, kebab-case убирается, верхний регистр)
- **@ConfigurationProperties:** ключи `server.*` биндятся в POJO `ServerProperties` (Boot 4: пакет `org.springframework.boot.web.server.autoconfigure`, модуль `spring-boot-web-server`). На шаге 6 — свои props-классы; собес-вопрос: `@Value` vs `@ConfigurationProperties` (группировка, валидация, IDE-автодополнение)
- Профили ученик уже знает (SpringBootProject, шаг 2) — не разжёвывать
- Задание 5Cα «война портов»: запуск на 9099 через `--server.port=9099` + 2 экзамен-вопроса (кто победит из трёх источников; что будет без `spring.profiles.active: dev`)

**Итоги 5C (сессия 18-19.09):**
- Разминка №3 (модульность Boot 4): **75/100** — «тонкая настройка, платим явным подключением дефолтов». Добавлено в разборе: главный мотив — худой classpath (меньше автоконфигураций под сканирование: память/старт/security-аудит); вторая цена — молчаливый игнор (настройка есть, модуля нет, ошибки нет — см. H2-консоль). Аналогия: Boot 3 = шведский стол, Boot 4 = меню, забыл отметить блюдо — официант молчит
- Экзамен В2 (пирамида, 3 источника): **70/100** — «запустится из аргумента» ✅, но пирамида: env ↔ `-D` перепутаны местами, забыт уровень «дефолты кода» (ServerProperties: 8080). На собесе называть число-ответ явно
- Экзамен В3 (без `spring.profiles.active: dev`): **60/100** — «включится default» ✅ (fallback!), но упущено главное: application-dev.yml перестаёт читаться + `@Profile("dev")`-бины не создаются. Маркеры логов: `The following 1 profile is active: "dev"` vs `No active profile set, falling back to 1 default profile: "default"` (без слова active!)
- **Находка:** `application-dev.yml` в проекте вообще не существует — профиль dev активен, но пуст
- Практика «война портов» ✅: логи `Tomcat started on port 9099` (CLI) и `8082` (обычный) — пирамида подтверждена вживую, Run Configuration очищен

### Задачи шага 5 (✅ 19.09.2026)
- **FizzBuzz** (`convert(int)`): 90/100. Порядок проверок 15 → 5 → 3 верный. Ловушка ученика: `Objects.requireNonNull(n)` на примитиве — мёртвый код (int не бывает null; лишний boxing в Integer ради невозможной проверки) — удалена после разбора. Правило: защитные null-проверки — только для ссылочных типов
- **BankGreeter** (`greet(String)`): 95/100. `name == null || name.isBlank()` — null-check ЛЕВЕЕ (ленивый `||`: short-circuit спасает от NPE). Бонус-вопрос верно: `isBlank()` (Java 11) = пустая или только whitespace; `isEmpty()` = только length==0
- **Первые JUnit 5 тесты ученика:** FizzBuzzTest 4/4 ✅, BankGreeterTest 4/4 ✅. Мелкий todo: имена в BankGreeterTest (`testName` → поведенческие `namedClient_greetsByName`)

### Копилка фактов шага 5 (для собеса)

| Факт | Суть |
|---|---|
| Boot 4 модулен | H2-консоль — отдельный артефакт `spring-boot-h2console`; web-сервер — `spring-boot-web-server` |
| Лямбда-пустышка | `x -> someFactory()` компилируется под void-ФИ, результат выбрасывается — «тихий» баг |
| frameOptions | H2-консоль = `<frameset>` → `sameOrigin()`, иначе браузер режет (DENY от Spring Security) |
| Пирамида конфигов | CLI > -D > env > профильный yml > общий yml > дефолты кода (`ServerProperties`) |
| Логи профилей | `...1 profile is active: "dev"` vs `No active profile set, falling back to 1 default profile: "default"` |
| Ленивый `\|\|` | null-check всегда левее: `name == null \|\| name.isBlank()` — иначе NPE |
| isBlank vs isEmpty | `isBlank()` (Java 11): пустая или только пробелы; `isEmpty()`: length==0 |
| requireNonNull | Только для ссылочных типов; на примитиве — мёртвый код + boxing |

---

*Обновлено 19.09.2026 (ночь): шаг 5 — 5A/5B/5C ✅ + задачи FizzBuzz/BankGreeter с первыми JUnit 5 тестами ✅ (90/95). Остались артефакты: README, GitHub Actions CI, ASCII-схема, тег step-05.*
