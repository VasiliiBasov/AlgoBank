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

### 17. «⚡ Точка восстановления» ведётся каждую сессию (с 24.09.2026)
- Блок наверху `HANDOFF.md`: шаг / что сдано / что в работе / 🔄 ротация разминок / что дальше / хвосты
- Обновлять **при каждой смене состояния** и на старте/конце сессии — паспорт сессии на случай смерти контекста ассистента (сработало 24.09: восстановление за минуты по дневникам+git+коду)
- Ротация разминок (что на ретесте) живёт именно там — единая точка правды

### 18. HANDOFF компактный, логи сессий — в архив LEARNING_LOG (с 24.09.2026)
- Операционные логи сессий (тайминги, паузы, ход сдачи) НЕ копим в HANDOFF — переносим/пишем в раздел «🗄 Архив операционных логов» этого файла
- HANDOFF = ⚡ точка восстановления + текущий статус + дайджест «что изучено»; цель — вход в контекст за 2 минуты

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

### Разбор «зачем нужен Service?» (19.09, преддверие шага 6)
- **Ответ №1 ученика:** «отделить бэкенд-логику от взаимодействия с фронтом; в сервисах — все сложные алгоритмы» → **60/100**. Интуиция изоляции верна, но: ① путаница фронт/HTTP — фронт отделён самим протоколом HTTP (другой процесс/машина), Controller = **HTTP/транспортный слой** (принять, распарсить JSON→объект, `@Valid`, вернуть DTO + статус); ② не названа **транзакционная граница** — главный аргумент для банка
- **Эталонный ответ (3 причины):** ① SRP — Controller адаптирует HTTP↔объекты, Service держит правила домена (лимиты, комиссии, «нельзя в минус»); ② **`@Transactional` живёт на методе сервиса**: перевод = списание + зачисление + запись истории; любой шаг бросил исключение из метода → откат всех трёх (rollback), иначе деньги списаны, но не зачислены; ③ переиспользование (тот же сервис дёргают `@Scheduled`-задачи, Kafka-листенеры, CLI) + тестируемость без HTTP
- **Аналогия (ресторан):** Controller = официант, Service = повар (отвечает за блюдо целиком — «подано всё или отмена»), Repository = кладовщик
- **Письменный повтор ученика:** «контроллер: принять → отвалидировать → распарсить → делегировать сервису; сервис выполняет задачу атомарно; контроллер оборачивает результат в ответ клиенту» → **85/100** («клиент» вместо «фронта» усвоено ✅). Отточить: rollback = исключение **вылетело из `@Transactional`-метода** → полный откат, а не «не выполнит транзакцию». 🪤 Ловушка собеса: по дефолту откат только на `RuntimeException`/`Error`; checked-исключения коммитятся, пока не укажешь `rollbackFor`
- **В ротации разминок:** «зачем Service, если Controller может вызвать Repository напрямую?» + «где граница транзакции?»

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
| Слои C → S → R | Controller = HTTP-адаптер (не «фронт»!), Service = доменные правила + `@Transactional`-граница, Repository = доступ к данным; Entity = модель (не слой) |
| `@Transactional` | Граница = метод сервиса; исключение наружу → rollback всех операций; checked-исключения без `rollbackFor` коммитятся |
| DTO ≠ бин, сервис ≠ DTO | `@Component` на record падает на старте; стрелки: controller→dto, controller→service; service про dto не знает |
| `@Valid` | На параметре контроллера, не на классе DTO; без него констрейнты на полях игнорируются |
| Failure vs Error | Failure — assert не сошёлся; Error — исключение из тела теста (NPE) |
| curl на Windows | `curl.exe` (alias `curl` = Invoke-WebRequest!), JSON в одинарных кавычках, `-i` = статус ответа |
| Входящий/исходящий DTO | Вход (CreateXRequest) валидируем; выход валиден по построению — аннотации там мертвы |
| `message` в теле ошибок | Скрыт с Boot 2.3: `server.error.include-message=never` по умолчанию (sec: утечка внутренностей). Дефолт-тело = timestamp/status/error/path |

---

---

## Шаг 6: DTO + валидация (в работе, ночь 19-20.09.2026)

### 6A: DTO + Bean Validation (✅ 92/100, ночь 20.09)
- **DTO = контракт API; сервис про DTO не знает.** Стрелки зависимостей смотрят внутрь: `controller → dto`, `controller → service`; service работает с чистыми типами/доменом. Красный флаг: `service → dto` (приклеен к API-контракту; `@Scheduled`/Kafka не вызовут; в юнит-тесте DTO из воздуха)
- **Аналогия:** DTO — бланк заказа (вещь зала); официант (controller) снимает суть словами; повар (service) бланк не читает — завтра бланк v2, повар тот же
- **Входящий vs исходящий:** `CreateGreetingRequest(@NotBlank String name)` — вход, валидируем; `Greeting` — выход, валиден по построению (аннотации там мертвы)
- **`@Valid` ставится на параметр контроллера** (`@Valid @RequestBody`), без него ограничения на DTO игнорируются. Не на класс, не на record!
- **Jackson/конвертеры:** контроллер возвращает объект; JSON делает `HttpMessageConverter` по `Content-Type`/`Accept` (собес-формулировка)
- **Разобранные ошибки 6A (вживую, с дифов):**
  1. `@Component` + `static`-метод — оксюморон: бин создан, статический вызов его обходит (бин — мёртвый груз; IDEA серым). Fix: убрать `static` → `greeter.greet(...)`
  2. `@Component` на record `Greeting` — component-scan пытается создать бин record'а без дефолтного конструктора → старт падает (`No qualifying bean of type String`). DTO — НЕ бины
  3. Вызов `greet(...)` с выброшенным результатом + эхо клиенту — «лямбда-пустышка» дух №2 (метод отработал, значение в никуда)
  4. NPE в тесте 4/4: поле объявлено, объект не создан — **в JUnit нет Spring-контекста**, `new BankGreeter()` руками (аргумент «тестируемость» сервисного слоя — вживую)
- **Тесты:** BankGreeterTest → поведенческие имена (`namedClient_greetsByName`), `new` вместо статики, 4/4 ✅ (todo шага 5 закрыт)
- **Failure vs Error в surefire:** Failure = `assert*` не сошёлся; Error = исключение из тела теста (NPE). Разные природы
- **HTTP-запросы (теория для п.4):** стартовая строка (метод + путь + версия) → заголовки → пустая строка → тело; `Content-Type: application/json` — без него **415**; Windows: `curl.exe` (НЕ alias `curl` = Invoke-WebRequest), JSON в одинарных кавычках, `-i` = статус+заголовки ответа, `-v` = весь обмен. Создан `http/greet.http` (IDEA HTTP Client, 4 запроса: GET-регрессия / 200 / 400 / 415)
- **Хвосты ученику:** мёртвые импорты (Greeting ×3, контроллер ×1) — вычищать `Ctrl+Alt+O`; пробел `@PostMapping (` — `Ctrl+Alt+L`
- **Вопрос-крючок к 6B:** какие поля у дефолтного тела 400 от Spring?
- **Факт из прогона ученика:** реальное тело 400 = `{timestamp, status, error, path}` — БЕЗ `message` (Boot ≥2.3, см. копилку). Дефолт не сообщает даже ЧТО не так → мотивация 6B только усилилась
- **Разминка №4 (20.09 вечер, 90/100, снята с ротации):** забытый `@Valid` → blank-имя проходит мимо валидации, но `BankGreeter` сам ловит `isBlank` → 200 «Здравствуйте, гость!». **Defense in depth**: фасад (Bean Validation на `@RequestBody`) и домен (проверка в сервисе) — два независимых слоя защиты; валидатор НЕ «исчезает» без `@Valid` — он просто не вызывается (аннотация-ограничение — декларация, `@Valid` — триггер)
- **Теория 6B (выдана подробно, 20.09 22:06+):** как пишутся хэндлеры — DispatcherServlet ловит проброшенное из контроллера исключение и ищет **best-match** `@ExceptionHandler` по типу (сначала локальный в контроллере, потом глобальные `@RestControllerAdvice` по `@Order`); `@RestControllerAdvice` = `@ControllerAdvice` + `@ResponseBody` (возврат сериализуется в JSON, как из контроллера); скелет: аннотация = КАКИЕ типы ловим, параметр метода = само исключение, возврат = тело ответа; `ProblemDetail` выставляет и статус ответа (он `ErrorResponse`); грабли: исключения из servlet-фильтров/вне dispatcher — НЕ ловятся advice (поэтому 401/404 до контроллера идут мимо), зато ошибки парсинга тела (`HttpMessageNotReadableException`) — ловятся
- **Задача 6 (easy) ✅ палиндром IBAN — 93/100 (20→21.09 ночь), мини-зачёт сложности 85/100.** Финальная форма каноническая: `public final class IbanPalindrome` + `private` ctor + `public static boolean isPalindrome(String raw)`. Грабли/уроки: (1) IntStream-нормализация — трёхаргументный `collect(StringBuilder::new, appendCodePoint, append)`, ASCII-отсечка `isLetterOrDigit && c < 128` (isDigit/isLetterOrDigit пускают Unicode: арабская ٣ → true; спека IBAN — только ASCII); (2) **баг `charAt(hi-lo)`** — склейка двух схем (зеркальная формула + движущиеся указатели); маскировался при `lo==0` и на нечётной длине 3 → урок «пограничные индексы», пойман чётным кейсом длины 20 (он же и есть регрессионный замок — отдельный тест не нужен); (3) регресс против вчерашних договорённостей: `assertEquals(true,…)`→`assertTrue/assertFalse`, имена `One..Five`→поведенческие, зомби-`@Component` дважды (экземплярная версия + потерянный сэйв); (4) **сложность — правильный ответ:** время O(n) (нормализация O(n) + сравнение n/2 пар = O(n); константы отбрасываем), память O(n) (строка `norm`); вариант «указатели сами пропускают мусор на ходу» = O(1) по памяти ценой читаемости — для n≤34 выбрана читаемость (осознанный трейд-офф, собес-формулировка отрепетирована); (5) теория: **IBAN = ISO 13616** (`CC` 2 буквы + `99` контрольные цифры mod-97 + BBAN ≤30 → длина 15…34; NO=15), пробелы — только раскладка для людей; mod-97 = мостик к Luhn (mod-10, карты)

- **6B ✅ ЗАКРЫТ (20.09 вечер): реализация 90/100, зачёт 70/100.** Хэндлер набран самостоятельно (отступления от скелета как доказательство), правки `joining("; ")` + sentence-case title внесены; регрессия 8/8; прогон: `Content-Type: application/problem+json`, `detail: "name: не должно быть пустым"`, `instance: "/api/greet"`, `type` (about:blank) на Boot 4 не сериализуется. **Зачётный ответ ученика:** преимущество = «клиент видит понятную ошибку» ✅ (и это сильно на фоне Boot≥2.3, где message скрыт), бонус про `path` → ответил «instant» — верно по сути = `instance` (опечатка принята). Не назвал: RFC 9457 = **межплатформенный контракт** (один парсер ошибок на любые API, не только Spring), расширяемость (`type` → документация, `setProperty` → машинные коды / map ошибок), семантический Content-Type. Честное «не вижу координальной разницы» — точка роста: ценность стандарта видна на уровне **системы** (много клиентов/сервисов), а не одного запроса

- **Разминка №5 (21.09 утро, 85/100 — ✅ СНЯТА с ротации):** ретест зачёта 6B. Ученик: «фронт может обработать по стандарту» + «не отдаём лишних данных». Доведено до собес-формулировок: (1) контракт RFC 9457 обслуживает ЛЮБЫХ клиентов — один парсер ошибок под все API, распознавание problem по `Content-Type: application/problem+json`; (2) «не лишнее» = **контроль поверхности утечки**: дефолт исторически сдавал внутренности (message/timestamp/path = инфраструктура), мы курируем `detail`; не упомянуты `instance` (URI упавшего запроса, диагностика) и расширяемость (`type`→доки, `setProperty`→машинные коды). С дня 20.09 (зачёт 70 + «не вижу разницы») — рост на +15 и содержательный сдвиг


- **6C (21.09 день, 90/100; зачёт 85/100):** springdoc-openapi-starter-webmvc-ui v3.x (линейка под Boot 4), `@Tag` + `@Operation` на контроллер самостоятельно; приёмка: api-docs-вывод + Try-it-out 400 problem+json из браузера (связка 6A+6B+6C). Зачёт: «springdoc=библиотека / OpenAPI=формат / Swagger UI=страница» и «спека из кода → не устаревает» уверенно; «сваггер оставить на тест-профиле» = верное решение без названной причины (прод = атак-сёрфейс: карта API для злоумышленника; механика `springdoc.swagger-ui.enabled=false` + `springdoc.api-docs.enabled=false`). **🏁 Шаг 6 закрыт: итог 88.9/100, тег `step-06`**


*День 20→21.09 закрыт 21.09 01:23:35 (`Get-Date`): нетто 2 ч 01 мин (гросс 5:17:08 − паузы 3:15:53). Итоги: 6B ✅ 90/100 (зачёт 70 → ротация 21.09), задача easy IBAN-палиндром ✅ 93/100 (баг `hi-lo` — урок пограничных индексов), мини-зачёт сложности 85/100, тесты 13/13 зелёные. Завтра: ретест RFC 9457 → Luhn (medium) → 6C springdoc.*

---

## 🗄 Архив операционных логов (из HANDOFF)

> Перенесено 24.09.2026 по правилу №18: HANDOFF держим компактным (⚡ точка восстановления + текущий статус + правила); операционная история сессий живёт здесь.

### Шаг 5 — история (✅ закрыт 20.09.2026, ночь)

- ✅ Разминка-ретест шага 4 проведена 17.09: **38/60** — `record pattern` остался в ротации повторения (давать в разминках)
- ✅ Разминка 19.09 (старт сессии): record pattern **75** → снят с ротации; пирамида конфигов **90** → снята; `orElse` vs `orElseGet` — «не помню» → разобрано заново → **ретест ночью: 85/100 → снят с ротации** (заточки: аргумент `orElse` вычисляется до вызова — механика Java; `orElse` ок для дешёвых констант, лямбда — лишний объект)
- ✅ **5A** (автоконфигурация + первая 401 → SecurityConfig `permitAll`) и **5B** (`/api/hello` JSON + H2-консоль после двойного бага: лямбда-пустышка `PathRequest.toH2Console()` и модуль `spring-boot-h2console` в Boot 4)
- ⏳ **5C:** `application.yml` — пирамида приоритетов (CLI > -D > env > профильный yml > общий yml > дефолты), relaxed binding, `ServerProperties`. Роздано задание 5Cα «война портов» (--server.port=9099) + 2 экзамен-вопроса (кто победит из 3 источников; что без `spring.profiles.active`) — ✅ закрыто 19.09: разм.№3=75, экзамен-1 (пирамида)=70, экзамен-2 (профили)=60; практика «война портов» подтверждена логами (CLI 9099 победил, без аргумента — 8082). Найденное: `application-dev.yml` вообще не существует — dev-профиль пустой, строка `spring.profiles.active: dev` висит на будущее
- ✅ Задачи: FizzBuzz (90/100; мёртвый requireNonNull на примитиве — удалён после разбора) + BankGreeter (95/100; null-check левее ||, isBlank vs isEmpty верно) — первые JUnit 5 тесты: FizzBuzzTest 4/4 ✅, BankGreeterTest 4/4 ✅. Мелкий todo: переименовать тесты BankGreeterTest в поведенческий стиль
- ✅ Артефакты (коммит `1b67465`, запушен в main): README.md + PNG-схема ученика → `docs/architecture-step05.png` + SVG-схема целевых слоёв `docs/architecture-step06-07.svg` + `.github/workflows/ci.yml` (maven verify, JDK 21 temurin). ✅ git-тег `step-05` поставлен 20.09 ночью — шаг закрыт
- 🆕 Новые практики с шага 5 (правила №11-16 в LEARNING_LOG): разминка-квиз на старте сессии, JUnit-тест к каждой задаче, git-теги шагов
- ✅ Security-ловушка сыграна: первый запрос дал 401 → разобрали и временно починили SecurityConfig'ом; по-честному Security — шаг 9, JWT — шаг 10


### Сессия 19.09 — продолжение (вечер)

| Действие | Корректировка времени | Примечание |
|----------|:---------------------:|------------|
| **Пауза №1:** 11:00 → 13:30 | **-2 ч 30 мин** | метки задним числом |
| **Пауза №2:** 14:06 → 19:01 | **-4 ч 55 мин** | метки живые (`Get-Date`), в файлах ранее не зафиксированы — исправлено здесь |
| **Пауза №3:** 20:35 → 23:57 | **-3 ч 22 мин** | закрыта по «продолжаем» (`Get-Date`: 20:35:48 → 23:57:31) |

- **Сессия: 10:26 → 20.09 02:13:51** (`Get-Date` обе метки); гросс 15 ч 48 мин − паузы 10 ч 47 мин = **нетто 5 ч 01 мин** → записано в STATS (день «19.09», строки 25-26)
- **Разбор «зачем Service»:** ответ №1 = 60/100 → письменный повтор = 85/100; вопрос («зачем Service» + «где граница транзакции») в **ротации разминок**; детали — LEARNING_LOG, «Разбор "зачем нужен Service?"»
- **Артефакты шага 5 запушены:** коммит `1b67465` → main (README, CI, PNG+SVG-схемы)
- **Шаг 5 ЗАКРЫТ (20.09, ночь):** git-тег `step-05` ✅ + итог дня в `STATS.md` ✅ (5.0 ч нетто)
- **Следующая сессия (20.09):** шаг 6 — **6B**: `@RestControllerAdvice` + ProblemDetail (RFC 9457). Заготовка ученика уже в репо: `exception/GlobalExceptionHandler.java` (пустой `@RestControllerAdvice`). План: хэндлер на `MethodArgumentNotValidException` → `ProblemDetail` (400, title «Validation failed», detail из `BindingResult.getFieldErrors()` через stream + joining) → прогон `greet.http` → зачётный вопрос: 2-3 преимущества ProblemDetail над дефолтом. Затем 6C (springdoc) + задачи: палиндром IBAN (easy) + Luhn (medium). Хвосты: мёртвый `import jakarta.validation.constraints.NotBlank` в `HelloBankController` (ученик при чек-ауте дня вычистил Greeting-импорты ✅ и пробел `@PostMapping` ✅). Ротация разминок пуста — наполнить темами 6B/6C
- ⚠️ **Docker не установлен** — шаг 7 начнётся с установки Docker Desktop (WSL2)


### Сессия 20.09 (вечер)

- **Старт:** 20:06:27 (`Get-Date`); план: разминка (включатель `@Valid`) → 6B ProblemDetail → задачи палиндром IBAN / Luhn
- **Разминка №4 «сломанный включатель»:** забытый `@Valid` + `{"name":"   "}` → ответ ученика «200 + «Здравствуйте, гость!» — валидатор не сработал, сервис сам обработал» = **90/100**, снято с ротации. Уточнение: движок валидации на classpath ЕСТЬ — `@Valid` это триггер вызова, а «валидатора нет» грубовато. Красивый вывод ученика: defense in depth — фасад (валидация) и домен (BankGreeter.isBlank) защищают независимо
- **ТЗ 6B выдано** (метод на `MethodArgumentNotValidException` → ProblemDetail 400 «Validation failed» + detail из FieldErrors через joining("; "); регрессия `mvn test`; прогон greet.http = тело до/после + `Content-Type: application/problem+json`; зачётный вопрос — 2-3 преимущества ProblemDetail; бонус: какое поле заменило `path`) + хвост: Ctrl+Alt+O в контроллере
- **⏸→▶ Пауза 20:18:59 → 22:05:53 (1 ч 46 мин 54 с)**. Хвост из 6A снят: `import ...NotBlank` в контроллере снесён ✅ (проверено чтением файла — импорты чистые). Ждём реализацию хэндлера 6B
- **Запрошена и выдана теория «как пишутся хэндлеры»:** DispatcherServlet ловит проброс → best-match `@ExceptionHandler` (локальный в контроллере > глобальные advice по `@Order`); `@RestControllerAdvice` = advice + `@ResponseBody`; скелет с построчным разбором; аналогия «операционист/диспетчер/справочник регламентов»; грабли (фильтры мимо advice; `HttpMessageNotReadableException` ловится)
- **Хэндлер 6B написан учеником + ревью:** `onValidationError(MethodArgumentNotValidException)` → ProblemDetail (400, title, detail из FieldError-стримом с `getField()+": "+getDefaultMessage()`). Регрессия `mvn test` зелёная 8/8 (surefire 22:24). Косметика по ТЗ: `joining(", ")` → `"; "`, title sentence case. Свидетельство самостоятельности: отступления от скелета (набран руками ✅)
- **⏸→▶ Пауза №2: 22:27:11 → 23:56:10 (1 ч 28 мин 59 с)** — ученик забыл сказать «вернулись», конец восстановлен задним числом: −20 мин от 00:16:10 (`Get-Date`); совпадает по порядку: прогон greet.http шёл в 23:45:38 MSK (уже самостоятельно, в конце паузы). **6B ЗАКРЫТ: реализация 90/100, зачёт 70/100** — правки внесены (`"; "`, title), прогон greet.http: `application/problem+json` + `instance`, `type` about:blank не сериализуется (Boot 4). Зачёт: информативность ✅ + instance ✅ (сказал «instant»), не назвал стандарт-контракт RFC 9457 и расширяемость — разобрано в ответе. Далее: задачи палиндром IBAN (easy) + Luhn (medium), затем 6C
- **🔄 Ротация разминок на 21.09:** «преимущества ProblemDetail / RFC 9457 над дефолтным телом» (зачёт 70 < 80 → ретест; вспомнить разбор: контракт-стандарт, `application/problem+json`, `type`→документация, `setProperty`)
- **Вопрос-уточнение 6B (конец сессии):** «мы сейчас сделали обработчик ошибок по стандарту — чтобы фронт мог правильно принимать и обрабатывать ошибки?» → подтверждено с уточнениями: (1) это перехватчик ИСКЛЮЧЕНИЙ (advice), а не обработчик запросов (контроллер); (2) охват пока один сценарий — валидация тела; битый JSON/404/500 — пока дефолт; (3) «правильно принимать» = у фронта появляется предсказуемый контракт 400+{title,detail,status,instance}+problem+json. Показана фронт-сторона контракта (fetch → media type → title/detail). Рост политики ошибок — шаг 8
- **Задача 6 (easy) IbanPalindrome — ✅ ЗАКРЫТА 93/100 (01:1x 21.09),** 2 итерации ревью: правки стиля (assertTrue/assertFalse + поведенческие имена + final+static+private ctor) → баг `charAt(hi-lo)` (пойман его же чётным кейсом длины 20 — он и есть замок) → зомби-`@Component` снят после «забыл сохранить». **13/13 зелёно**. Мини-зачёт сложности 85/100 (время O(n) с верным обоснованием; память O(n) дополнил я). Далее: **Luhn (medium)** с JUnit + 6C springdoc; ретест-разминка «преимущества RFC 9457» на следующей сессии
- **✅ Сессия 20.09 ЗАКРЫТА 21.09 01:23:35** (`Get-Date`): нетто **2 ч 01 мин** (гросс 5:17:08 − паузы 3:15:53, пауза №2 закрыта задним числом −20 мин). **Завтра (21.09):** разминка-ретест «преимущества ProblemDetail/RFC 9457» → **Luhn (medium)** с JUnit → **6C** springdoc OpenAPI (сваггер на `get|post /api/greet`)


### Сессия 21.09 (утро)

- **Старт:** 10:38:03 (`Get-Date`); план: разминка-ретест RFC 9457 → Luhn (medium) → 6C. Ротация: RFC 9457 (зачёт 70→ретест)
- **Разминка №5 (ретест RFC 9457, 10:38+):** «фронт может правильно обработать по стандарту» + «не отдаём лишних данных клиенту» = **85/100 → СНЯТА с ротации** ✅. Дополнено до полного: контракт для ЛЮБЫХ клиентов (один парсер), механизм — Content-Type `application/problem+json`; «не отдаём лишнего» = контроль поверхности утечки (detail курируем мы); пропущены `instance`/расширяемость — записаны в разбор. Ротация снова пуста
- **Luhn (medium) — в работе:** ученик сам нащупал ошибку («filter молча выкидывает буквы → вопрос: как вернуть false?») → разобрано: `anyMatch` валидация алфавита + `filter` нормализация; ASCII-граница для Луна `c >= '0' && c <= '9'` (Character.isDigit('٤')==true → мусор математики; тот же урок, что `isLetterOrDigit` + c<128); альтернатива — один цикл с `continue`/`return false`
- **⏸→▶️ ПАУЗА: 21.09 11:19:24 → 12:28:37** (`Get-Date`) = 1 ч 09 мин
- **Luhn — первая попытка:** 3 теста (только assertTrue) падают → ревью нашло два бага: (1) `charAt(i) * 2` удваивал КОД символа ('1'=49→98→89, забыт `- '0'` — обратная сторона вчерашней ASCII-границы); (2) цикл с конца с шагом −2: удваивал с ПОСЛЕДНЕЙ (неверная парность) и не складывал неудвоенные цифры вовсе (16 вместо 30 для "4111...")
- **Luhn ✅ 92/100 (~13:10):** оба бага исправлены самостоятельно (`- '0'` + `(length-i-1)%2==1`), покрытие 3 pos + 5 neg = **8 тестов, всего 21/21 зелёные**. Минусы: `- 9` вне блока удвоения (мёртвое условие на неудвоенных), опечатка `Degits`, имя `numbs`→`digits`. Мини-зачёт сложности: **85/100** (время O(n) ✅ — три прохода: anyMatch+filter+loop; память O(n) ✅ по выводу, но обоснование «для каждого своя переменная» → поправили: O(n) = промежуточная строка numbs, переменные sum/num/i = O(1)). Вопрос «одной проходкой без строки» пропущен → разобран: счётчик цифр справа `digitIndex % 2 == 1` + skip пробелов/дефисов (тот же O(1)-паттерн, что указатели в палиндроме). **Задача Luhn ЗАКРЫТА**, далее 6C springdoc
- **6C стартован (~12:40):** theory выдана (OpenAPI=спека из кода, Swagger UI интерактив; springdoc 3.1.1 для Boot 4); ТЗ: dependency → swagger-ui + /v3/api-docs → @Tag/@Operation → прогон Try-it-out с problem+json
- **⏸→▶️ ПАУЗА №2: 21.09 13:01:15 → 14:04:26** (`Get-Date`) = 1 ч 03 мин
- **6C ✅ 90/100 (14:04):** springdoc-starter-webmvc-ui (Boot 4 → 3.x) в pom ✓; `@Tag("Greetings")` на контроллере + `@Operation(summary)` на обоих методах ✓ (импорты io.swagger.v3.oas.annotations чистые); api-docs с тегами/summary показан как доказательство. Минус: Try-it-out 400 problem+json не показан; огрех «yours name» съехал. Зачёт 6C: 3 вопроса (UI vs спека vs springdoc; откуда берётся спека; что с UI в проде)
- **Зачёт 6C — 85/100 (14:20):** «springdoc=библиотека / OpenAPI=формат / Swagger UI=страница» ✅; «спека из кода, меняется вместе с ним — всегда актуальна» ✅; «оставить на тест-профиле для QA и показа заказчику» ✅ по решению, но не названа ПРИЧИНА выключения в проде (открытый сваггер = карта API для атакующего; механика: `springdoc.swagger-ui.enabled=false` + `api-docs.enabled=false` в prod-профиле). Try-it-out 400 problem+json подтверждён («все работает»)
- **🏁 ШАГ 6 ЗАКРЫТ (21.09, день):** 6A 92 + 6B 90 + 6C 90 + задачи 93/92 + зачёты 80 → **итог 88.9/100**, тег `step-06`. Коммит `d47bab8` (9 файлов, +126) запушен; тег сперва уехал на `5ba49c3` (апостроф `- '0'` порвал PS-строку в одинарных кавычках — тот же урок, что со step-05) → переставлен `git tag -f` + force-push ✅. Следующий шаг 7 (JPA) — блокер: Docker Desktop (WSL2) не установлен
- **⏸ ПАУЗА №3: 21.09 14:19:02** (`Get-Date`). Между паузой и возвратом ученик спросил amd64 vs arm64 (Intel Core Ultra 5 125H → amd64) и **установил Docker Desktop: `Docker version 29.8.0` ✅**
- **🔚 День 21.09 ЗАКРЫТ задним числом 23.09:** конец = 14:19:02 (пауза №3 как последняя фиксация), нетто **1 ч 29 мин ≈ 1.5 ч** (гросс 3:40:59 − паузы 2:12:24). 22.09 — пропуск. Итог AlgoBank: **28.2 ч / 11 дней**


### Сессия 23.09 (вечер)

- **Старт:** 19:01:40 (`Get-Date`); Docker ✅ 29.8.0; план: разминка №6 (Luhn O(1)-память — пропущенный вопрос) → шаг 7: Docker basics #1 (`hello-world`, образ vs контейнер, run/ps/stop/rm/logs/exec, `-p`) → JPA entities (Account ↔ Transaction). Ротация пуста
- **⏸→▶️ ПАУЗА №1: 23.09 19:06:03 → 20:36:12** (`Get-Date`) = 1 ч 30 мин — разминка №6 задана, ответ ждёт после возврата
- **Разминка №6 (23.09, 65/100 → 🔄 В РОТАЦИЮ):** «Luhn без строки = по очереди с начала и с конца, шум скипать, невалид → false» — скип/false верно, но два указателя = мышление палиндромом; в Луне сравнивать нечего, вес зависит от позиции СРЕДИ ЦИФР справа → один проход справа + счётчик `digitIndex`: чётный → удвоить. Паттерн-урок: «счётчик отфильтрованных элементов вместо индексов символов». Тема ротации: «парность чек-суммы = счётчик цифр справа»
- **Docker: WSL доустановлен** (`wsl --install`: WSL 2.7.14 + Ubuntu, user vasilii) — Docker Desktop жил без бэкенда, демон молчал (npipe dockerDesktopLinuxEngine отсутствовал)
- **Демон поднят (23.09 ~20:45):** exe найден в user-scope `%LOCALAPPDATA%\Programs\DockerDesktop\Docker Desktop.exe`; запуск → PIPE UP за 3 с → `client=29.8.0 server=29.8.0 (linux/amd64)`. `docker run hello-world` ✅ (pull hello-world:latest из Hub, amd64). Теория по живым артефактам: образ (class/шаблон, 25.9kB в кэше) vs контейнер (объект/процесс, `df4282a374f0` Exited(0), имя-автоген `eager_poincare`); `ps` только Up, `ps -a` все; run = pull+create+start+stream. **Практика задана:** повторный run (кэш), `rm`, цикл `nginx -d -p 8080:80 --name web` → curl → logs → stop/rm. Приёмка: вывод `docker ps` (Up) + curl-ответ
- **⏸→🔚 ПАУЗА №2: 23.09 23:04:30, возврат не зафиксирован** → **день 23.09 закрыт задним числом 24.09: нетто 2 ч 33 мин ≈ 2.5 ч** (гросс 4:02:50 − пауза №1 1:30:09). Конец = старт паузы №2. Итог AlgoBank: **30.7 ч / 12 дней** (22.09 — пропуск). Nginx-цикл задан, не сдан

### Сессия 24.09 (день)

- **Старт:** 12:36:21 (`Get-Date`); план: сдать nginx-цикл → зачёт Docker basics #1 → JPA entities (Account ↔ Transaction) + задачи шага 7 (HashSet-дубликаты). Ротация: «парность чек-суммы = счётчик цифр справа»
- **Nginx-цикл СДАН ✅ (24.09 ~12:44):** pull nginx:latest (7 слоёв) → Up с `0.0.0.0:8080->80/tcp` → curl **200 OK «Welcome to nginx!»** → `docker logs web` (стартовые логи + его строка `172.17.0.1 GET / 200 896`) → `stop; rm`. Самородки: curl в PS = алиас Invoke-WebRequest (предупреждение о сценариях; настоящий = `curl.exe`); 172.17.0.1 = хост в bridge-сети docker0; `logs` = stdout PID 1 контейнера. **Зачёт-вопросы заданы:** (1) пословный разбор `run -d -p 8080:80 --name web`, (2) после stop+rm что в `docker images` и `ps -a`
- **Ответы (24.09):** (1) порты ✅ (8080 хост / 80 контейнер), флаги — «не знаю, материала мало» → справедливо, дан полный разбор: run=create+start, `-d` detach, `-p host:container` (можно неск.), `--name`, +вперёд: `-e`/`-v`/`--rm`/`-it`; (2) «images очистятся?» ❌ → разобрано: `rm` только контейнер (объект ≠ класс), образ чистится `docker rmi`, слои в кэше → повторный run мгновенный. **Эмпирическая проверка задана:** `docker images` (оба образа живы) + `ps -a` (пусто)
- **Зачёт Docker basics #1: 80/100 ✅ (24.09):** эмпирическая проверка подтвердила — images оба живы, web удалён; **сюрприз:** ps -a НЕ пуст — вчерашний `eager_poincare` (df4) пережил ночь + рестарт демона (п.3 вчерашней практики был пропущен); парадокс «Created 16 h ago / Exited 9 min ago» = процесс стартовал при поднятии демона утром. Урок: контейнеры живут до `docker rm`. Дана зачистка `docker rm df4`. **В ротацию не летит** (флаги докинуты по нотации, концепция образ/контейнер подтверждена опытом)
- **JPA-блок стартован (ТЗ выдано):** теория JDBC→JPA(спека)→Hibernate(реализация), ORM: строка↔объект; pom += `spring-boot-starter-data-jpa` + H2 (runtime, заглушка до шага 8 — PostgreSQL позже без смены кода); `entity/Account` (id IDENTITY, ownerName, **balanceMinor long** — наследие конвертера 5B, деньги целыми), `entity/Transaction` (amountMinor, @ManyToOne @JoinColumn account_id), `repository/AccountRepository extends JpaRepository`. Ловушка: transaction — слово зарезервировано, потому @Table с именем во мн. числе. Приёмка: DDL create table accounts/transactions + fk account_id в логах mvn spring-boot:run. **Фикс:** в сниппетах ошибся пакетом (com.bank.algobank вместо ru.algobank) — ученик поймал до сборки. Верные пути: ru/algobank/entity/ + ru/algobank/repository/
- **Падение старта (24.09 13:17):** `Schema validation: missing table [account]`. Детектив по логу: в pom появился `spring-boot-starter-flyway` (pom вырос: +security/cache/actuator/testcontainers/h2console; дубликаты data-jpa×2, h2×2 — на зачистку) → Boot 4: Flyway первым (миграций нет → пустая схема), Hibernate в validate вместо create-drop → fail-fast до Started. Имя `[account]` = его @Table. Урок: Flyway = версионированные SQL-миграции (прод), Hibernate DDL — наброски. **Фикс-ТЗ:** `db/migration/V1__create_accounts_transactions.sql` (конвенция V1__двойное__подчёркивание; IDENTITY-колонки ↔ GenerationType.IDENTITY; camelCase→snake_case; FK `account_id NOT NULL` на стороне transactions). Приёмка: `Successfully applied 1 migration` + Started. ⚠️ Security теперь требует Basic Auth (401 на curl до шага 14)
- **▶ Продолжение 24.09 (13:30 `Get-Date`):** смена ассистента (у прошлого кончилась память) → контекст восстановлен по 6 дневникам + git + коду. Добавлен блок «⚡ Точка восстановления» наверху файла; README синхронизирован с шагом 6 (было устаревшее: «шаг 5», «8 тестов»). План сессии: разминка №7 (ротация: Luhn O(1)) → 7A миграция V1 (пишет ученик) → приёмка старта → задачи шага 7
- **▶ Продолжение 24.09 (13:30 `Get-Date`):** смена ассистента (у прошлого кончилась память) → контекст восстановлен по 6 дневникам + git + коду. Добавлен блок «⚡ Точка восстановления» наверху файла; README синхронизирован с шагом 6 (было устаревшее: «шаг 5», «8 тестов»). План сессии: разминка №7 (ротация: Luhn O(1)) → 7A миграция V1 (пишет ученик) → приёмка старта → задачи шага 7

---

## Вечер 24.09 (второй ассистент, продолжение)

- **Синхронизация документов по правилам №17-18:** HANDOFF похудел — логи 19.09→24.09 дословно перенесены в архив выше; хендбук: шаг 7 (+пометка про поля даты/типа в V2), шаг 8 (+docker-compose, +Flyway-эволюция V2), шаг 11 (+MapStruct), шаг 13 (+structured logging JSON, +хвост micrometer-registry-prometheus)
- **Разминка №7 задана (3 вопроса):** Q1 — ретест «Luhn O(1) по памяти»; Q2 — порядок Flyway→Hibernate и падение до `Started`; Q3 — что в `docker images` после `stop`+`rm`
- **Q1 отвечен: 88/100 → Luhn O(1) СНЯТА с ротации ✅** («идём справа; чётность цифры с конца — в счётчик; skip пробелы/дефисы; буква/знак → false; нечётные ×2, итд») — направление справа ✅ (якорь чётности в конце), счётчик цифр вместо индексов символов ✅ (урок разминки №6 усвоен), skip/валидация ✅. Минус: «итд» проглотило хвост алгоритма (after ×2: >9 → −9; сумма в одном int; финал `sum % 10 == 0`) — договорились проговаривать. Ждут: Q2, Q3
- **Q2 отвечен: 75/100 → 🔄 В РОТАЦИЮ:** «первым flyway, т.к. hibernate бы дописал таблицы; правильно — flyway не пропустил ошибку» — порядок ✅, идея fail-fast ✅, но ошибка атрибуции: без миграций падает НЕ Flyway (пустой `db/migration` = ок, создаётся только `flyway_schema_history`), а **Hibernate на `validate`** (текст `Schema validation: missing table [account]` — его). Причина порядка: Hibernate должен валидировать УЖЕ готовую схему — DDL владеет Flyway. По запросу выдана теория Flyway (миграции = код схемы в git; history-таблица; checksum; V-версию не редактируем; режимы ddl-auto). Ждёт: Q3
- **Q3 отвечен: 75/100 → 🔄 В РОТАЦИЮ:** «images останется (класс в Java), исчезнет объект-процесс; процесс кэшируется, docker достанет из кэша» — часть 1 ✅ (образ жив, `ps -a` пуст, аналогия класс/объект на месте); часть 2 с ошибкой: кэшируется НЕ процесс (мёртв и удалён), а **слои образа** в локальном image store → повторный `run` = НОВЫЙ контейнер/процесс без скачивания. **Разминка №7 закрыта: Q1 88 / Q2 75 / Q3 75.** Далее 7A: миграцию V1 пишет ученик
- **⏸→▶ ПАУЗА: 24.09 14:44:22 → 18:25:20** (`Get-Date`) = 3 ч 41 мин — на столе: 7A, V1-миграция за учеником (ТЗ выдано; компас: имя таблицы = `@Table` из `Account.java`)
- **Запрошена и выдана теория SQL-миграций (24.09 вечер):** ученик честно сказал «не помню/не знаю синтаксис» → разобрана анатомия `CREATE TABLE` (DDL vs DML, типы BIGINT/VARCHAR, `GENERATED BY DEFAULT AS IDENTITY` — SQL-стандарт, берём его, а не MySQL-`AUTO_INCREMENT`, чтобы тот же файл пережил переезд на PostgreSQL в шаге 8) + пример на **нейтральной** области (customer/orders) с построчным разбором и таблицей маппинга его entity; сам файл V1 пишет ученик (правило курса — код миграции не пишу)
- **7A: прогон успешный (24.09 ~18:52):** лог прислан фрагментом — `Successfully validated 1 migration` + DispatcherServlet «Completed initialization» (нитка с IP 192.168.3.14 → приложение УЖЕ отвечает по HTTP, видимо открыт /h2-console). Урок точности логов: **«validated ≠ applied»** (validate — сверка checksum истории; applied — реальное выполнение V1); доказательство по логике: приложение поднялось → Hibernate validate прошёл → таблицы есть → V1 применилась. Запрошены канонические строки `Successfully applied 1 migration` + `Started AlgoBankApplication` для формальной приёмки. - **7A: формальная приёмка ЗАКРЫТА (24.09 вечер):** притащена каноническая строка `Successfully applied 1 migration to schema "PUBLIC", now at version v1` (тот же PID 34092, +3 с до DispatcherServlet ⇒ Started состоялся). **7A = 90/100 ✅.** Выданы ТЗ задач шага 7: easy `TransactionDuplicates.findDuplicates(List<Long>) → Set<Long>` (дубли ID через HashSet, O(n)) и medium `TransactionDedup.dedupe(List<MoneyTx>) → List<MoneyTx>` (дедуп по ключу сумма+дата через record-ключ, выживает первое вхождение, порядок сохранить); пакет `algo/step07`, конвенции Luhn (final/приватный ctor/статик/поведенческие тесты). Мини-зачёт: сложности обеих + «почему record-ключ, а не строка-склейка»
- **⏸→▶ ПАУЗА: 24.09 19:01:46 → 19:49:54** (`Get-Date`) = 48 мин — на столе: коммит+push (хвост) + задачи step07 (ТЗ выданы, не начаты). Оффтоп на паузе: рекомендации сериалов про программистов («Мифический квест» стартован учеником)
- **⏸→▶ ПАУЗА №2 (вечер): 24.09 19:50:34 → 19:54:51** (`Get-Date`) = 4 мин — состояние на столе без изменений (коммит+push + задачи step07)
- **Коммит 7A: `2d38ea2` запушен в main (24.09 ~19:5x)** — 11 файлов, +227/−71 (entities, repository, V1, pom + документы курса); по поручению ученика коммитил ассистент. Хвост «закоммитить entities + pom» снят ✅. Далее: задачи step07 → зачёт → тег `step-07`
- **⏸→▶ ПАУЗА: 24.09 20:18:23 → 22:51:23** (`Get-Date`) = 2 ч 33 мин — прогресс к паузе: 7easy решение + 1 тест из 5 готовы (написаны учеником, ревью/прогон не было); осталось: 4 теста → `mvn test` → ревью → 7medium
- **7easy: выдана таблица фикстур (24.09 ~22:52)** — по запросу ученика: пять пар «вход `List<Long>` → ожидание `Set<Long>`» по сценариям ТЗ (пустой / без дублей / один дубль / несколько разных / ID ×3; дубли разнесены, не смежные) — сами тесты пишет ученик
- **7easy ЗАКРЫТА: 90/100 ✅ (24.09 ~23:1x), итерация №2 — 26/26 зелёные:** 5 правок из 6 приняты (явные импорты, `Set`-локалки, `seen`, Shift+F6-тест, без `public`); 🧹 нит: двойные пробелы в main не отформатированы (Ctrl+Alt+L к коммиту шага). **Мини-зачёт сложности: 40/100 → 🔄 в ротацию** — ответ «время O(1), память O(1): одна проходка, 2 переменные» обе части неверны: один проход по n = время **O(n)** (O(1) время = константа, см. `set.add`); «2 переменные» = 2 ссылки на РАСТУЩИЕ HashSet до n элементов = память **O(n)** (тот же урок, что `numbs` в Luhn); контраст: в O(1)-варианте Луна `sum`/`digitIndex` — фиксированные примитивы. Тема ротации: «сложность = про рост от n, а не про счёт переменных». Далее 7medium
- **7easy в работе: запрошена подсказка «как проверять Set в тестах»** → дана: (1) основной паттерн `assertEquals(Set.of(...), actual)` — Set.equals сравнивает по содержимому, порядок не важен (встроено в контракт сета); (2) empty-кейс `assertTrue(actual.isEmpty())`; (3) анти-паттерн: никогда не проверять порядок итерации HashSet — flaky-тесты; (4) стиль взять из `LuhnValidatorTest` (поведенческие snake_case-имена, плоские ассерты без сообщений)
- **День 24.09 закрыт: 25.09 00:12:30** (`Get-Date`) — нетто **8,2 ч** (гросс 11:36 = 12:36:21 → 00:12:30(+1) − паузы 3:25 = 48+4+153 мин). Итог дня: nginx-цикл + зачёт Docker basics 80/100 ✅ · разминка №7 (88/75/75: Flyway-validate + Docker-кэш → ротация) ✅ · JPA entities + V1 Flyway 90/100 ✅ + commit `2d38ea2` ✅ · 7easy 90/100 ✅ · мини-зачёт сложности 40/100 → 🔄 ротация. STATS/OVERALL_STATS синхронизированы. След. сеанс: 7medium → зачёт шага → тег `step-07` → разминка №8

