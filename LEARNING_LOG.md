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

### 8. Профиль ученика
- ✅ Заходят: длинные разборы с аналогиями, ASCII-схемы, проекты-обёртки, много задач
- ❌ Не заходят: готовый код классов целиком, варианты A/B/C/D, мало задач
- ⚠️ Слабые места: путает похожие концепции, доверяет недавней памяти, ошибки в формулировках закрепляются → давать сравнительные вопросы и требовать явные таблицы отличий

---

## 📋 Структура папок проекта (план)

```
Algoritm/
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
