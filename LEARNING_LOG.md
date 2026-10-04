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
### Сессии 25.09 / 28.09 — 🗄 SQL-блок 7 сдан (97/100)

- **25.09 (🗄 SQL 16:57→17:23 = 0.4 ч):** разминка перед блоком — **58.3** (HashMap 70: смешал resize/treeify — деревеет НЕ вся мапа, а бакет при ≥8 узлах + таблица ≥64; `put` перезаписывает только value, ключ старый; DispatcherServlet 60: цепочка есть, но пропущено HandlerMapping→Adapter→ArgumentResolver→HttpMessageConverter; COUNT 45: «COUNT(NULL) = счётчик пустых», NULL≠0). В ротацию: звено mapping/adapter, COUNT×NULL
- **26.09 (вне сессии):** q01–q03 решены, commit `7bd61e4` (23:22). Отметок не было → **время не учитываем** (прямое решение ученика)
- **28.09 (🗄 SQL 11:09–12:09 = 1.0 ч; 14:01–15:53 = 1.9 ч ≈ 2.9 ч):** песочница H2-console (`jdbc:h2:mem:sqldrills`, sa/пусто; приложение `spring-boot:run -Dspring-boot.run.profiles=sqldrill`, второй терминал для mvn). Инфра-находка: **JAVA_HOME в системе отсутствовал вообще** → прописан User-level (jdk-24) + `%JAVA_HOME%\bin` в PATH. q04: первая попытка `FROM account … AMOUNT_MINOR` → тест «колонка не найдена» → фикс `FROM transactions WHERE account_id=1`. Ловушка-урок: «укоротить description в WHERE» = **алиас ТАБЛИЦЫ** (`FROM transactions t`, шаг 1 выполнения → виден везде), алиас колонки в WHERE недоступен (рождается в SELECT, шаг 4). THEORY.md дополнен (§1: алиас таблицы vs колонки, кавычки)
- **✅ БЛОК СДАН: 97/100** (задачи 80/80 — 12/12 зелёных; зачёт **17/20**: минусы — BETWEEN-хак «999 вместо 1000» (ломается на дробях), `_` = ровно один символ, лексикография `'1','10','2'` по мостику, «не нулевых» вместо «не NULL»). **Гейт `sqldrills=on` снят** — `SqlStep07Test` теперь в основном прогоне и CI (регрессия). В ротацию: «лексикографическая сортировка строк vs чисел»
- **Время по блоку 7 (засчитано):** 25.09 0.4 + 28.09 2.9 ≈ **3.3 ч**. След. SQL-блок — шаг 8: JOIN×8 (материалы при старте шага 8)

### 📐 Теория 7medium TransactionDedup (выдана 28.09 ДО решения, по запросу ученика)

1. **Идиома stable-dedup = «фильтр с памятью»:** один проход + `Set` уже виденных ключей; родной брат 7easy `TransactionDuplicates` (тот ищет ДУБЛИ, этот их УБИРАЕТ — один инструмент, две противоположные задачи).
2. **Ядро: `Set.add(key)` возвращает boolean** (true = новый) — одна операция = проверка+запоминание; анти-паттерн `contains` + `add` — два хеширования.
3. **Ключ — record, а не строка-склейка:** record бесплатно даёт корректные `equals/hashCode` по всем компонентам и иммутабельность (ключи HashSet обязаны быть неизменяемыми — шаг 2). Склейка `amount+"|"+date`: коллизия смыслов через разделитель («12|3» vs «1|23»), аллокация строк на каждый элемент, потеря типобезопасности.
4. **Порядок первых вхождений сохраняется автоматически** (без сортировки): добавляем в результат только при `add()==true` → результат идёт в порядке первых появлений.
5. **Сложность:** время O(n), память O(k) уникальных ключей (связка с мини-зачётом 7easy 40/100: растущая коллекция = память от n).
6. **Ловушки:** ключ = весь MoneyTx → id входит в equals и ломает логику; «выживает первое» = возвращаем ИСХОДНЫЙ объект, а не ключ; сортировка для дедупа ломает порядок.
7. **Где ещё:** Stream `distinct()` (stateful-операция), SQL `DISTINCT ON` (Postgres), идемпотентный consumer (same key → same result) — мостик к mock-теме идемпотентности.

**Новые для курса концепты внутри 7medium (по запросу ученика 28.09):**
8. **HashSet = обёртка над HashMap:** внутри — `HashMap<E, Object>` со статической пустышкой `PRESENT` вместо значения (собственного кода хеширования у Set нет: бакеты, порог treeify 8/64 — всё наследуется). Выбор: только членство («видел ли ключ») → Set; ключ→значение (счётчик/сумма/первый объект) → Map. Аналог `add()` на карте — `putIfAbsent(k, v)` (вернёт прежнее значение или null).
9. **java.time.LocalDate:** дата без времени/зоны, ISO `2026-09-28`; immutable → готовый ключ (equals/hashCode из коробки), Comparable (isBefore/isAfter); фабрики `of(y,m,d)` / `parse("2026-09-28")`. Не `java.util.Date` (мутабелен, миллисекунды+зона) и не String (лексикография-ловушка, нет валидации «2026-02-30»). Дата — это тип, не строка.
10. **Вложенный ключ:** record внутри класса — неявно static (внешний `this` не нужен); стиль курса: `private record DedupKey(...)` внутри класса задачи — ключ живёт рядом с алгоритмом, пакет не замусоривается.

### Сессия 28.09 (вечер, ☕ шаг 7) — 7medium сдан, зачёт шага 7 НЕ сдан

- **7medium `TransactionDedup.dedup` ✅** (commit `ffc7609`, ученик): один проход, `Set.add`→boolean-идиома, record-ключ (сумма+дата), 6/6 зелёных; устный зачёт задачи **88/100** (чисто снята O-нотация — реванш за 7easy: «время O(n) при аморт. O(1) на add; память O(k) уникальных» — добрать формулировку; record-vs-строка: типобезопасность/нет аллокаций/equals бесплатно — добрать)
- **❌ Зачёт шага 7: 53/100** (порог 80): провалы — 401 vs 403 (было в mock №1, 2-й заход в ротацию), UNION vs UNION ALL (было в SQL-зачёте в тот же день!), «DISTINCT без ORDER BY — порядок не гарантирован» (мостик к LinkedHashSet-стабильности), «Set.add(dup) НЕ перезаписывает — false, старый элемент остаётся». Вопросы про number-из-id (`@PostPersist`) и BankStatusFilter **аннулированы ментором**: в репо их нет (🔲 заглушки-планы), ученик ответил честно
- Пересдача: новый набор вопросов, проваленные вернутся; тег `step-07` — после пересдачи. Ротация += 4 темы (401/403, UNION/UNION ALL, DISTINCT-порядок, add-семантика)
- Время ☕ шаг 7 за 28.09 (точные метки): 16:03:48–16:08:40 (5 мин, выдача ТЗ) + 20:27:13–21:56:37 (1 ч 29 мин, 7medium + устный зачёт 88) + 22:36:23–23:10:52 (34 мин, зачёт шага 7: 53/100 + доразбор) = **2 ч 8 мин ≈ 2,1 ч**

### 📌 Зачёт шага 7 — эталонные ответы на провальные темы (доразбор 28.09)

1. **JPA ↔ Flyway (добор к 7/10):** entity = маппинг кода на схему, а не создатель схемы; `ddl-auto=validate` — Hibernate при старте только проверяет соответствие, схему версионирует Flyway (единственный источник правды, `flyway_schema_history`, SQL под ревью). Таблицы нет → `SchemaManagementException: missing table` при **старте** (fail-fast, а не 500 на первом запросе). Крючок: «Hibernate проверяет, Flyway создаёт; рассинхрон = не стартуем».
2. **HashSet (поправка «перезаписи»):** элементы Set = ключи внутреннего HashMap, value = одна статическая пустышка `PRESENT`; `add(dup)` → **false**, множество не меняется, старый элемент нетронут (перезаписывает value только `Map.put`); мутация поля у лежащего ключа → «потерянный» элемент (`contains` не находит).
3. **DISTINCT vs LinkedHashSet — вопрос про ПОРЯДОК:** SQL без ORDER BY порядка не гарантирует вообще; LinkedHashSet — детерминированный порядок первых вхождений. DISTINCT-дедуп по всей строке (возвращает ключ), наш дедуп по record-ключу (возвращает объект с id). **UNION** = склейка + дедуп строк (дорого: хеш/сорт); **UNION ALL** = как есть (быстро, дубли); дубли невозможны/неважны → ALL.
4. **401 vs 403 (зубрёжка, 3-й заход):** 401 = **аутентификация** не пройдена (credentials нет/протухли — «кто ты?», лечится логином; историческое «Unauthorized» вводит в заблуждение); 403 = аутентифицирован, но **прав нет** («знаю кто ты — и нельзя», нужен доступ/роль, перелогин не поможет). Рядом: 400 = битый синтаксис запроса (`@Valid`), 422 = семантически невалиден.
5. **DTO vs Entity (3 собес-аргумента):** API — контракт, БД — реализация (переименовал колонку — клиент не сломался); служебные поля entity наружу = утечка; LAZY-коллекции и циклы `Account↔Card` ломают сериализацию (`LazyInitializationException` / циклический JSON). id генерирует БД/сервис, не клиент.
6. **Аннулированные №2/№7:** `number`-из-`id` (`@PostPersist`) и `BankStatusFilter`/OpenFeign — заглушки-планы, в репо отсутствуют (проверено 28.09); OpenFeign запланирован на шаг 8+.

### Сессия 28–29.09 (ночь, ☕ шаг 7) — пересдача №2 зачёта шага 7: 75/100, порог не взят

- **Метки (`Get-Date`):** старт 28.09 23:35:00 (восстановление контекста по HANDOFF + выдача нового набора) → конец зачёта 29.09 00:20:50 = **0:45:50 ≈ 0.8 ч**
- **По вопросам:** Q1 HashSet-капот (HashMap+PRESENT) **85** · Q2 Set.add-семантика **82** · Q3 DISTINCT≠порядок **82** · Q4 UNION vs ALL **65** · Q5 401/403 **100** ✅ · Q6 Flyway/Hibernate **60** · Q7 LinkedList **48** · Q8 DTO-vs-Entity **80** → **итог 75** (53 → 75, динамика есть)
- **Закрыто:** 401/403 — безупречно (3-й заход, **снята с ротации**); Set.add и DISTINCT-порядок — суть взята, остаются на контрольном ретесте (82 + точность формулировок)
- **Эталоны провалов пересдачи №2:**
  1. **UNION дороже UNION ALL — за счёт дедупа:** склейка + удаление дублей = сортировка всего набора (sort+dedup) или хеш-таблица по всем строкам → память + блокирующий оператор (первая строка не отдаётся, пока не обработаны все); UNION ALL — потоковая склейка, почти бесплатна. Шум-примечание: «порядок» к UNION/ALL не относится — порядок гарантирует только ORDER BY.
  2. **История применённых миграций ≠ файлы:** таблица **`flyway_schema_history` в самой БД** (version, description, script, checksum, success); файлы V1/V2… — исходники миграций. Таблица даёт: «now at version v1» (что применено), checksum-валидацию изменённых файлов, защиту от повторного применения.
  3. **LinkedList JDK:** список двусвязный — `node(i)` идёт от головы при `i < size/2`, иначе от хвоста (≈вдвое меньше шагов, асимптотика та же). Цикл `for (i) get(i)` = **O(n²)** (каждый проход заново от конца); итератор/enhanced-for хранит позицию → обход **O(n)**; индексный доступ → ArrayList.
- **Оговорки (на контроль):** Q2 — не сказал «останется 1 элемент»; Q3 — «LinkedSet» → термин **LinkedHashSet** (LinkedList тоже держит порядок вставки, но мостик — про Set+дедуп); «селект может отработать иначе» — точная формулировка: порядок = побочный эффект плана выполнения (index scan / seq scan / параллелизм).
- **Q8:** 3 аргумента засчитаны; не назван 4-й собес-аргумент — сериализация: LAZY → `LazyInitializationException`, циклы Account↔Transaction → бесконечный JSON.
- **Пересдача №3:** новый набор; обязательно вернуть пробелы (UNION-почему-дороже, `flyway_schema_history`, LinkedList node(i)+цикл O(n²)) + контрольные ретесты (Set.add, DISTINCT↔LinkedHashSet с точным термином); валидные темы — на усмотрение; 401/403 снята. Порог 80 → тег `step-07`.

#### Оспаривание итогов пересдачи №2 (29.09, ~00:37, `Get-Date`)

- **Принято ментором:** Q1 и Q2 — штрафы сняты как логически очевидные пропуски (из «выживает первое вхождение» следует «остаётся 1 элемент»): Q1 **85→100**, Q2 **82→90**; Q8 **80→82** (заодно: «понял принял» + 3 аргумента засчитаны).
- **Q3:** ученик сам признал перепутанное имя → **85**, тема в ротации только как контроль термина **LinkedHashSet**.
- **Q4:** ученик возразил «тема будущего». Факт: «дорого: хеш/сорт» был в эталоне доразбора 28.09 — тема НЕ из будущего; но глубина «блокирующий оператор / O(n log n)» — шаг 19 и в обязательный минимум не входит. Минимум курса: «доп. работа по удалению дублей = сортировка/хеш всех строк». В ответе не было даже «почему дороже» → назначен добор (правило №9), финальный балл после него.
- **Q7:** из комментария ученика («O(n) — она и итоговая») следует возможное заблуждение, что цикл `for (i) get(i)` по LinkedList = O(n). Верно: каждый `get(i)` заново идёт от ближайшего конца → сумма проходов 1+2+…+n → **O(n²)**; полный обход за O(n) дают итератор (или ArrayList). Это не придирка, а проверка модели → назначен добор, финальный балл после него.
- **Q6:** остаётся 60 — ученик принял эталон (`flyway_schema_history` — таблица, не файлы); тема в ротации на будущие разминки.
- **Введено правило №9** (см. HANDOFF): уточняющие доборы до итоговой оценки; логически очевидные пропуски не штрафуются; точность имён/терминов — не придирка; контент будущих шагов в минимум не входит.
- **Доборы (29.09 00:46, `Get-Date`):** Q4 ✅ «UNION делает sort+distinct по всем строкам» → **65→85**; Q7 ✅ «цикл = O(n²): для каждого элемента новый проход от конца списка» → **48→75** (честное «не знаю» про `node(i)` от ближайшего конца — в разминку №9).
- **ФИНАЛ пересдачи №2: (100+90+85+85+100+60+75+82)/8 = 84,6 → 85/100 ✅ СДАН (порог 80). ШАГ 7 ЗАКРЫТ: итог 88,3** = avg(7A 90 · 7easy 90 · SQL-блок 97 · 7medium 88 · Docker-зачёт 80 · зачёт 85) → тег `step-07`.
- **Ротация после закрытия шага:** сняты — UNION-«почему дороже», цикл-get O(n²) (доборы пройдены); в разминку №9: `flyway_schema_history` (таблица в БД), LinkedList `node(i)`, термин LinkedHashSet, Set.add-контроль, DTO-LAZY-аргумент + прежние темы (Flyway-vs-Hibernate-validate, Docker-кэш, сложность HashSet-паттернов, mock-пробелы).

### Сессия 29.09 (день, ☕ шаг 8) — СТАРТ ШАГА 8

- **Метка (`Get-Date`):** старт 29.09 16:20:58.
- **SQL-блок 8 (JOIN×8) выдан под гейтом** `-Dsqldrills=on` (инфра — ментор): `SqlStep08Test` — 8 тестов; `docs/sqldrills/step08/README.md` — шпаргалка JOIN, постановки, полные ожидания; заглушки `q01–q08.sql`. Задачи Q1–Q8: INNER · INNER+WHERE · LEFT (Анна без транзакций) · ANTI-JOIN (`IS NULL`) · RIGHT≡LEFT (тот же результат) · FULL с условием в ON (NULL-ы с обеих сторон, NULLS LAST) · self/multy-JOIN «двойники» суммы -450 на разных счетах · JOIN+фильтр+ORDER BY.
- **План шага 8:** 8A @Transactional (прокси, propagation, rollbackFor, checked/unchecked, ловушка самовызова; ACID/изоляции кратко) → зачёт; 8B TransferService + REST (`POST /api/transfers`, `GET /api/accounts`, `GET /api/accounts/{id}/transactions` через DTO) + интеграционный тест отката (исключение посередине → балансы не изменились); algo: easy — сборка графа/обороты, medium — `hasCycle` (DFS-цвета) + бонус сам цикл; зачёт шага → тег `step-08`. Опция по карте SQL-трека: docker-compose PostgreSQL.
- Фронт: скелеты «Счета»/«Переводы+циклы» оживут после 8B (эндпоинты пишет ученик — правило №5; ассистент подключит панели UI).
- Разминка №9 (flyway_schema_history · LinkedList node(i) · точный термин LinkedHashSet) и mock-фикс/отклик EGAR — параллельной ротацией, не отменены.
- 🗄 17:22:14 — открыт SQL-сегмент (команда «на sql»): ученик пишет q01→; по его просьбе выложен `docs/sqldrills/step08/THEORY.md` (теория JOIN по образцу блока 7).
- ⏸ **Пауза (с 29.09 19:31:43, `Get-Date`).** SQL-сегмент на 5/8: q01–q04 зелёные (ревью-фиксы ORDER BY в q01 и `=` вместо LIKE в q02; коммит `c459d4f`), q05 RIGHT-молча дописан и зелёный ✅. Серверы живы: backend :8082 в профиле **sqldrill** (сиды V900; h2-console → `jdbc:h2:mem:sqldrills`, sa/пусто), frontend :5173 (прокси /api проверен). **Инцидент-урок:** H2 2.4 не знает `FULL [OUTER] JOIN` вообще (`Syntax error [42000-240]`) → Q6 переделан на `LEFT JOIN` + условие в ON (5 строк; контрольный вопрос «сколько строк будет при WHERE» = 4), FULL остался теорией §5 + эмуляция UNION'ом (коммит `8735f3c`). Возврат: q06 (FULL→LEFT + ORDER BY a.id, t.id), q07, q08.
- ▶️ **Возврат из паузы 29.09 20:01:44** (`Get-Date`; пауза 19:31:43→20:01:44 = **30 мин 01 с**). Серверы пережили паузу (backend sqldrill :8082 UP, frontend :5173) — консоль/сиды доступны сразу. Продолжение SQL-сегмента: q06 (FULL→LEFT + ORDER BY a.id, t.id), q07, q08.
- 🏁 **SQL-блок 8 ЗАКРЫТ 29.09 21:17:33 — итог 96/100.** Автопроверка 8/8 → ревью (q07: недостающее «разные счета» добавлено после замечания — улетело в ON к a2; для INNER безразлично, на заметку) → зачёт 5 ловушек: предварительно **63** (Q1 10 / Q5 12 — одна и та же **перевёрнутая модель конвейера LEFT JOIN**: «ON не пускает строку левой таблицы»; верно: LEFT всегда выпускает левые строки, ON решает лишь «есть ли пара», убивает NULL-строки WHERE) → доборы правила №9: D1 ✅ (q06+`WHERE t.id IS NULL` = только Анна) · D2 ✅ после честного оспаривания «этого не было в вопросе» (было — но ответ полный: меняются направление LEFT→RIGHT и перестановка таблиц, не меняется результат) · D3 в два раунда (эмуляция FULL = LEFT `UNION ALL` правый anti-join; фильтр `a.id IS NULL` — **IS NULL по НЕсохраняемой стороне**, сторону задаёт направление JOIN; первая попытка `t.id` вернула бы 0 строк) → **финал зачёта 80/100**. Балл блока = 80 + 80/5 = **96**. Гейт `@EnabledIfSystemProperty` снят (как в блоке 7) — общий прогон **`mvn test` = 52/52**; попутный подарок регрессии: прогон после снятия гейта упал на q06 из-за случайно печатанных `в1` перед ORDER BY (символы попали в файл между прогонами) — поймано и вычищено. **Нетто на блок:** 17:22:14→21:17:33 минус пауза 30:01 → **3 ч 25 мин (~3,4 ч)**.
- **В ротацию (разминка №10, новое из блока 8):** конвейер LEFT JOIN вслух по шагам (лямбда-фраза: «LEFT замораживает левую; ON = про пары; WHERE = секира для NULL-строк»); anti-join/FULL-эмуляция — `IS NULL` по несохраняемой стороне; диалекты: H2 2.4 без `FULL [OUTER] JOIN`. Прежние кандидаты №10 силы не теряют (flyway fields+checksum, node(i) «от ближайшего конца», Docker-кэш, HashSet-сложность, DTO-LAZY).




#### Разминка №9 (29.09, 16:42:11 → 17:16:44) — итог 71.7/100

- **Q1 `flyway_schema_history`: 70.** Твёрдо: история — таблица в самой БД, Flyway сравнивает файлы с ней, при расхождении — ошибка ✓. **Провал:** полей записи не назвал ни одного валидного (норма: version, description, script, checksum, success); слово **checksum** не произнесено (правка применённого V1 → checksum файла ≠ checksum в истории → validate-падение при старте); «почему файлы — не источник правды» раскрыто слабо (файл могли удалить/приехать из другой ветки — правда о применённом только в таблице). **Остаётся в ротации** (следующий заход: поля + checksum-валидация).
- **Q2 LinkedList `node(i)`: 65.** Верно: цикл по `get(i)` = O(n²) (сумма проходов, коэффициент отбрасываем); итератор однопроходный; «когда LinkedList? — практически никогда, вставки в начало → ArrayDeque» — **собес-сильный ответ** ✓. **Провал ядра:** механика `node(i)` «**от ближайшего конца**» (`i < size/2` → от головы, иначе от хвоста) снова не озвучена — а это и есть точка ротации; погрешности: Collection — интерфейс (не класс), Iterable≠Iterator. **Остаётся в ротации.**
- **Q3 LinkedHashSet + add: 80.** **✅ Закрыто:** точный термин LinkedHashSet; PRESENT-заглушка в значениях; hashCode→бакет, equals→дубль; `add(dup)` → false без изменений, `add(new)` → запись в конец + true. Минусы: внутри **LinkedHashMap** (не просто HashMap — связный список и даёт порядок вставки); DISTINCT-часть по сути верна («может пройти без сортировки»), но формулировка должна быть «без ORDER BY порядок **не гарантирован вообще**».
- **Ротация после №9:** сняты — термин LinkedHashSet, контроль Set.add; остаются — поля flyway_schema_history + checksum-валидация, node(i) «от ближайшего конца»; прежние — Docker-кэш, сложность HashSet-паттернов, DTO-LAZY, mock-пробелы.



- ⏸ Пауза 29.09 21:36:08 (SQL-блок 8 закрыт 96/100; следующая точка — 8A @Transactional; серверы :8082(sqldrill)/:5173 живы). Команда возврата: «вернулся» (или сразу «даю теорию»).
- ⏸→▶ Возврат 30.09 11:19:22; пауза 13 ч 43 мин 14 с (ночь). Продолжаем: 8A @Transactional.
- 📖 **Конспект 8A: @Transactional** (полная версия — в чате, 30.09 11:19). Тезисы: транзакция = атомарность (ACID: Atomicity/Consistency/Isolation/Durability); механика = **прокси** (JDK/CGLIB: begin → method → commit/rollback), отсюда ловушка **самовызова** (	his.m() обходит прокси — транзакции нет) и «только public»; **откат по дефолту только на RuntimeException/Error — checked Exception = КОММИТ** (лечится ollbackFor = Exception.class, обратное — 
oRollbackFor); propagation: **REQUIRED** (дефолт: присоединюсь/создам, 99% кода), **REQUIRES_NEW** (всегда новая, внешняя ждёт — сценарий audit-лога, неуязвимого к откату), SUPPORTS/NOT_SUPPORTED/MANDATORY/NEVER одной строкой, **NESTED** = savepoint внутри текущей (JDBC; откат вложенной не убивает внешнюю); eadOnly=true — хинт (dirty-checking off, PG реально read-only), для чистых SELECT-методов; ставить на public-методы **сервиса** (слой, владеющий атомарностью), Spring Data методы транзакционны сами; в тестах @Transactional — авто-откат после теста; менеджеры: JpaTransactionManager. Сценарий 8B: перевод атомарен, лёгированная ошибка на 2-й операции → откат обеих. Зачёт 8A — следом.
- 🗣 **Собеседование 30.09 ~11:5x (до паузы)** — первый реальный прогон! Заданные вопросы (по памяти ученика): 1) что такое JVM; 2) [забыт — допишет позже]; 3) HashMap — «тут всё хорошо» ✅ (работа ротаций видна); 4) что такое Hibernate; 5) что такое Maven. Кандидаты на разбор при возврате: эталонные ответы JVM/Hibernate/Maven + проверить глубину HashMap (не только O(1), а capacity/loadFactor/дерево от 8/java8). Связать с EGAR/mock-фиксом — список собес-вопросов копим.
- ⏸ Пауза 30.09 11:51:45 (теория 8A выдана, зачёт ждёт). Команда возврата: «вернулся».
- 🔍 **Проверка itk.academy / itconsult-web.ru (30.09, после собеса):** оба сайта = ОДНО юрлицо — ООО «ИТК», ИНН 6154164899 / ОГРН 1236100010970 (рег. 2023, Таганрог, пер. Тургеневский 11, ком. 1-7), руководитель Тетеревлев И.Н. (он же основатель на главной). Это **образовательная академия с ISA-моделью** («не устроишься — не платим», гарантия за 75 раб. дней «договором»), НЕ работодатель: «собеседование» = воронка «Пройти отбор» в платный курс. Плюсы: гослицензия Л035-01276-61/00736842, Сколково с 2024, ПО в реестре. Звоночки: заявленные «IT-компания 100+ человек» и «230+ трудоустроенных» — самозаявленные; почты ya.ru/gmail; проверки: pb.nalog.ru (среднесписочная) + islod.obrnadki.gov.ru (лицензия) + проект договора читать ДО подписи. Вывод дан ученику: не скам-ништяк, но и не оффер работы — решать осознанно, наш курс покрывает то же бесплатно.
- 📄 **Разбор 'Меморандум о договоренностях' ИТК (30.09):** не договор (ст.429 ГК), денежные условия кроются в 4 последующих договорах. Модель: при трудоустройстве в ИТ — **50% («Премиум») или 38% («Эксперт») от ЛЮБОГО ИТ-дохода x 12 мес**; тарифы: Премиум 21600+14400+54000=90 тыс/мес (≤50%), Эксперт 21600+14400+27000=63 тыс/мес (≤38%); при ЗП 150 тыс = 900/756 тыс за год (огорожено 'скидкой' до цены договоров: обучение 216-450 тыс + трудоустройство 144-350 тыс). 🚩 главные: **SIM-карта на имя ученика с передачей доступа им** (= их сейлзы переписываются с работодателями от его имени!); выход по своей инициативе до трудоустройства = оплата ПОЛНОЙ стоимости пройденного (без скидок); приемка услуг — **5 раб. дней**, молчание = акт подписан; 'поддержка' за 54 тыс/мес после трудоустройства — скрытый апселл. Вердикт: легально, но крайне агрессивно; не подписывать.
- ▶ Сессия 30.09 12:23:44 — мок-разбор собес-вопросов ИТК (JVM / [№2 забытый] / HashMap / Hibernate / Maven): ученик отвечает как на собесе, ментор ловит провисания + эталон. (8A @Transactional: теория выдана, зачёт отложен — вернёмся после мока.)
- 🎤 **Мок-разбор собес-вопросов (30.09, ~12:4x): М1 JVM 8/20 · М2 HashMap 12/20 · М3 Hibernate 11/20 · М4 Maven 10/20 → 41/80 (~51/100).** Провисания: (М1) перепутаны роли javac (компилирует в байт-код) и JVM (исполняет: интерпретация+JIT), кроссплатформенность приписана машинному коду вместо байт-кода (WORA: переносим .class, JVM и машкод — платформенно-зависимы); JDK=JRE+(javac..), JRE=JVM+библиотеки. (М2) коллизия = РАЗНЫЕ ключи в одном бакете (цепочка + equals при get) — не знал; дерево от 8 (при cap≥64) — ✅; дефолты 16/0.75, рост ×2 (а ×1.5 — это ArrayList.grow!); индекс hash&(n-1), hash=h^(h>>>16). (М3) ядро ORM + живой пример validate из AlgoBank ✅; промах: **JPA = спецификация (jakarta.persistence), Hibernate = её реализация** (провайдер по умолчанию в spring-data-jpa); lazy/кэш/диалекты не названы. (М4) 'управление зависимостями' ✅, но фазы lifecycle названы неверно ('тесты→подключение к бд→запуск' — НЕ фазы!): clean + validate→compile→test→package→verify→install→deploy, pom.xml декларативно, транзитивные зависимости, ~/.m2. **Ротация мока: все 4 вопроса** (JVM/JDK/JRE, HashMap-глубина, JPA vs Hibernate, фазы Maven). Вопрос №2 с собеса так и не вспомнен — кандидат в догадку.
- ⏸ Пауза 30.09 14:05:43 (сессия 12:23:44→14:05:43 ≈ 1 ч 42 мин: проверка ИТК + меморандум + мок-разбор 51/100). Открыто: зачёт 8A @Transactional (теория выдана) · повторять мок-вопросы в ротации · забытый вопрос №2 собеса — ученик допишет, когда вспомнит · серверы :8082(sqldrill)/:5173 живы. Команда возврата: «вернулся».
- ⏸→▶ Возврат 30.09 21:26:08; пауза 7 ч 20 мин (14:05:43→21:26:08). Продолжаем: приоритет — зачёт 8A (@Transactional); в ротации мок-вопросы JVM/HashMap/Hibernate/Maven.
- 📖 Дополнение к конспекту 8A: разбор откатов на 7 примерах (выдано в чате 30.09 21:2x): RuntimeEx→откат; checked→КОММИТ (ловушка) и rollbackFor; проглоченное в try/catch исключение→коммит, лечение setRollbackOnly/ре-прокинуть; самовызов this.x()→аннотация мимо; REQUIRES_NEW для audit-лога; NESTED=savepoint.
- 📝 Зачёт 8A @Transactional начат (студент: 'готов'). 5 вопросов x20, порог 80, доборы по правилу №9.
- 🔀 30.09 21:5x: зачёт 8A ОТЛОЖЕН по инициативе ученика («практика, потом зачёт») — переход на **8B: TransferService + REST + интеграционный тест отката**. Вопрос про docker-compose («с compose/без») задан на старте 8B. Зачёт 8A остаётся в очереди после 8B-практики.
- ✅ Решение по 8B: **с docker-compose → PostgreSQL, тест отката на Testcontainers** (рекомендация ментора принята). Стек 8B: compose postgres:16 · профиль prod-БД · миграции Flyway (проверить H2→PG совместимость) · POST /transfer · интеграционный тест отката на PostgreSQLContainer.
- 🚀 **8B выдан 30.09 ~22:1x.** Ментор написал приёмочный TransferServiceAcceptanceTest (Testcontainers postgres:16-alpine, @Testcontainers(disabledWithoutDocker=true) — без Docker скип, 'вечно зелёный' прогон цел): 4 сценария — happy (150000→45000, движения ×2), откат при несуществующем получателе (списание откатилось!), insufficient funds, same-account. Контракт: TransferService#transfer(Long,Long,long), исключения AccountNotFoundException/InsufficientFundsException в ru.algobank.exception. Ученик пишет: pom+postgresql-драйвер, docker-compose.yml (postgres:16), application-pg.yml, доменные debit/credit, сервис, TransferController + DTO + 3 хэндлера в GlobalExceptionHandler. V1 DDL совместим с PG (GENERATED BY DEFAULT AS IDENTITY) — миграции единые. Ручная приёмка: compose up → профиль pg → INSERT счетов в psql → curl POST /api/transfer → сверка в psql.
- ⏸ Пауза 30.09 21:59:08 (перед реализацией 8B). Инфра-инцидент: тест 8B не компилировался из-за Lombok-процессора в Maven (IDE маскировала; main не использовал геттеры) → pom: annotationProcessorPaths; нужен clean (инкрементальные классы старые). Стабы ментора: AccountNotFound/InsufficientFundsException + TransferService TODO. Локально 52✅+4 skip (Docker-демон недоступен), CI покраснеет на 4 тестах 8B — осознанный маяк. Пуш на GitHub. Зачёт 8A отложен; вопрос №2 собеса не вспомнен. Команда возврата: «вернулся».
- ⏸→▶ Возврат 03.10 22:03:15; пауза ровно 3 суток (30.09 21:59:08→03.10 22:03:15). Добытчик: **тестовое задание с собеседования** — метод: массив чисел → новый массив без ПОДРЯД идущих повторов ([4,4,2,2,2,7,7,4]→[4,2,7,4]). Взято в курс как algo-задача шага 8: ConsecutiveDedup.squeezeConsecutive(int[]); ментор: контракт + стаб + 9 красных тестов (edge: пустой/null→IAE/один/без дублей (не тот же инстанс!)/все одинаковые/классика/**4-2-7-4 ловушка не-подряд**/негативы/не мутировать вход); требования O(n), вход не трогать. Ученик реализует → mvn -Dtest=ConsecutiveDedupTest test зелёный → ревью.
- ✅ step08-algo ConsecutiveDedup реализован: 9/9 зелёных, полный прогон 65 (61✅+4 квитанции 8B skip). Нетто ~25 мин с ревью-циклом (22:03→22:28). Ошибка 1-й итерации — классика бана: add вне if, мёртвая переменная. Оценка 95/100 (минус мёртвая 
). Сложность O(n)/O(n) верна. Стек для возврата: мини-зачёт (почему HashSet ломает не-подряд; инвариант одного прохода) → 8B TransferService (Docker!) → зачёт 8A → зачёт шага 8.
- ▶ 03.10 ~22:35 (после паузы 10 мин): ученик потребовал убрать менторские заглушки 8B + приёмный тест — «пишу сам всё, пока не попрошу конкретно». Удалено: TransferService, AccountNotFound/InsufficientFundsException, TransferServiceAcceptanceTest. Политика подтверждена (усиление правила №5): код — только по явному запросу. Состояние: 61/61✅, запушено. 8B: ученик реализует сам по ТЗ из чата (pg-профиль/compose → сервис+исключения+дебет/кредит → контроллер+DTO → хэндлеры → сам пишет тесты). Мини-зачёт ConsecutiveDedup (2 вопроса) отложен до конца 8B.
- ⏸ Пауза 03.10 23:38:32 (8B в процессе). Прогресс 8B: п.1 pom ✅ — ученик сам добавил org.postgresql:postgresql (runtime, версия от BOM; проверка: compile exit=0, dependency:tree → postgresql:jar:42.7.13:runtime). Выяснили: BOM testcontainers добавлять не нужно (Boot управляет: core 2.0.5 / postgres-модуль 1.20.4 — гибрид, держать в уме при Docker-экзотике). Следующее: п.2 инфра pg — compose pg 5433:5432 → application-pg.yml (jdbc:…5433) → V2__pg_identity.sql (identity, не SERIAL — вопрос ревью) → docker compose up -d pg + psql select version(). TODO(step08, ученик): инфра pg. Далее стек: сервис+тесты+хэндлеры (ученик) → mini-зачёт algo → зачёт 8A → экзамен шага.
- ⏸→▶ Возврат 04.10 23:21:54 (пауза ~сутки). Стоянка: pom-драйвер добавлен учеником, но НЕ закоммичен — напомнить про мелкие коммиты. Наработок по инфре pg нет: compose-файл отсутствует/не найден, application-pg.yml и V2 нет. Старт п.2: ученик пишет compose pg (5433:5432) → application-pg.yml → V2 identity.
- ⏸ Пауза 04.10 23:31:15 (8B, п.2 инфра pg — старт). Сделано: pom запушен (2aaf5a4). Выдано ТЗ п.2: docker-compose.yml (pg 5433:5432, env, volume), application-pg.yml (jdbc:…5433, ddl-auto=validate), развилка миграций — открыть V1 и решить: портируемый синтаксис (одна папка) vs H2-специфика (db/migration/h2 + /pg, V2 identity в pg). Жду от ученика: V1 + решение + 3 файла. Проверка: docker compose up -d pg → psql select version().
- 🧠 Коуч-заметка 04.10 ~23:40+: ученик сообщил о фокус-тумане несколько дней (садится — не понимает задание, мысли уходят). Разбор: причина не в лени, а в непрозрачности инфра-шага (нет точки входа и быстрого фидбека в отличие от algo/sql с зелёными тестами). Рекомендации: дробление до 10-минутных шагов, pomodoro-lite 25 мин, совещание с ментором ДО тумана, опора на журнал как доказательство компетентности. Предложен перезапуск п.2 микро-шагами + тактильный контакт (ручной psql).
- ▶ Перезапуск п.2 инфры pg микро-шагами (04.10): 6 шагов по ~10 мин с критерием 'готово' у каждого — 1) разведка V1 (выписать id-синтаксис/H2-специфику) 2) тактильный pg: docker run + psql select version() 3) compose-скелет + docker compose config/up 4) решение миграций (портируемая V1 vs h2/pg-разводка) 5) application-pg.yml + старт с профилем pg (Flyway-лог) 6) сквозная проверка данных в psql. Правило: застрял >10 мин — стоп, вопрос ментору.
- ✅ 8B п.2 микро-шаги 1-2 приняты (04.10 поздний вечер): разведка V1 — синтаксис id уже портируемый (GENERATED BY DEFAULT AS IDENTITY + H2 MODE=PostgreSQL) → V2 отменён, одна папка миграций (решение ученика подтверждено факт-чеком); тактильный pg — docker run postgres:16 → psql select version() = PostgreSQL 16.15, контейнер убран. Изучено на ходу: identity vs ALWAYS vs SERIAL. Следующее: шаг 3 — compose-скелет (pg 5433:5432, env, volume) + docker compose config/up.
- ✅ 8B инфра pg ЗАВЕРШЕНА (05.10 00:36): шаги 3/5/6 — compose pg (5433:5432, volume pgdata), application-pg.yml, старт на профиле pg. Три боевые грабли и их уроки: 1) docker compose ищет файл в текущей директории (запускать из корня) 2) YAML отступ=путь: driver-class-name уехал в spring.driver.class.name → молчаливо проигнорирован, унаследовался h2-драйвер → 'claims to not accept jdbcUrl' (читать стек с самого глубокого Caused by) 3) Flyway>=10: 'Unsupported Database: PostgreSQL' → добавлен модуль flyway-database-postgresql (версия от Boot BOM). Факт-чек: V1 применена (flyway_schema_history success=t), GET /api/accounts/1 → 404 на pg. Открытый вопрос для зачёта 8B: что дал MODE=PostgreSQL и как изменились риски кода на настоящем PG. Далее: п.3 сервис TransferService + исключения (ученик) → п.4-5 REST/хэндлеры → тесты ученика (Docker!) → mini-зачёт algo → зачёт 8A → экзамен шага 8.
- ⚠ Коррекция ментора (05.10): мой 'факт-чек GET /api/accounts/1 → 404' был невалиден — такого эндпоинта НЕТ (только HelloBankController /api/hello,/api/greet); 404 был 'нет маппинга', а не 'сущность не найдена'. Инфра pg тем не менее доказана: psql видит запись Ивана, actuator health=PostgreSQL UP. Ученик дважды выполнил INSERT (id 1,2) — на приборку: DELETE id=2. Уроки: 404 двух природ (нет маппинга vs брошенное NotFound), irm бросает исключение на не-2xx (PS 5.1). REST-проверка данных переносится в п.4 (TransferController + опц. GET /api/accounts/{id}).
- ⏸ Пауза 05.10 ~00:50 (конец сессии). Вечер: возврат ~23:21 → инфра pg закрыта полностью (pom→compose→профиль→Flyway на PG 16.15, Иван вставлен/прочитан psql). Процессы погашены: java PID 16208 (порт 8082) остановлен, algobank-pg остановлен (docker compose stop pg; данные в volume algobank_pgdata). Утренний старт: п.3 TransferService (ученик сам): сигнатура transfer(fromId,toId,amount) @Transactional + 2 исключения + debit/credit в SQL-репо. Стек: п.3-4-5-6 → mini-зачёт algo (2 вопроса) → зачёт 8A @Transactional (вопрос №2 собеса) → экзамен шага 8. Команда возврата: «продолжим».
