# 📊 Overall Stats — общая статистика по всем проектам

> **Назначение:** агрегатор по **всем** проектам ученика в стиле «обучение через проект».
> Не дублирует `STATS.md` каждого проекта — там детали (по сессиям, по темам).
> Здесь — сводка: общее время, баллы, пройденные темы, **сквозные пробелы**.

> ⚠️ **Внимание новому ассистенту:** это **основной** `OVERALL_STATS.md` для всех трёх проектов ученика (SpringCoreProject, SpringBootProject, AlgoBank). Если ученик упомянул только этот файл — ищи `COURSE_HANDBOOK.md` в каждом из трёх проектов.

---

## 🧭 Как пользоваться этим файлом

- **Если новый ассистент** — открыть первым делом после `COURSE_HANDBOOK.md`. Здесь видно **общую картину**.
- **Если ученик** — здесь смотреть «а сколько я вообще на обучение потратил за всё время?»
- **При старте нового проекта** — добавить новую строку в таблицу «Проекты».

---

## 📁 Проекты ученика (в стиле «обучение через проект»)

| # | Проект | Тема | Статус | Шагов | Часов | Балл | Ссылка на дневник |
|---|--------|------|--------|-------|-------|------|-------------------|
| 1 | **SpringCoreProject** | Spring Core (без Boot) | ✅ Завершён | 12 / 12 | 17.2 | ~85% | `SpringCoreProject/COURSE_HANDBOOK.md` |
| 2 | **SpringBootProject** | Spring Boot + JPA + Security | ⏳ В процессе | 9 / 15 (шаг 9 закрыт) | 21.7+ | ~82% | `SpringBootProject/COURSE_HANDBOOK.md` |
| 3 | **AlgoBank** | **Java Core повт. + Spring Boot + Алгоритмы + SQL** | ⏳ Старт сегодня | **0 / 26** (шаг 0 закрыт) | **0.2** (старт 11.09.2026) | — | `Algoritm/COURSE_HANDBOOK.md` |

### Не использовать как проекты в этой статистике

> ⚠️ В `C:/Users/Vasilii/IdeaProjects` есть **другие каталоги**, которые **НЕ входят** в обучающие проекты:

| Каталог | Что это | Указание новому ассистенту |
|---------|---------|----------------------------|
| `SpringCoreMyProject/` | **Черновики и наброски** ученика до формата обучения | **Не считать** частью курса |
| `CriptoAnalizer/` | Старый учебный проект (криптоанализ) | **Игнорировать** |
| `dancer/`, `Frontend/`, `rain-lab/`, `Web/` | Другие направления | **Игнорировать** |

---

## ⏱ Суммарное время на обучение

| Проект | Даты | Часов |
|--------|------|-------|
| SpringCoreProject (Core) | 24.08.2026 → 28.08.2026 | 17.2 |
| SpringBootProject (Boot) | 28.08.2026 → _TBD_ | 21.7+ (в процессе) |

## 🎯 Пройденные темы (сквозной чеклист)

### ✅ Spring Core (курс №1, проект 1)

- [x] IoC-контейнер, `BeanFactory` vs `ApplicationContext`
- [x] DI: constructor / setter / field
- [x] Bean scope: singleton / prototype
- [x] `@Bean` методы в `@Configuration`
- [x] `BeanPostProcessor`
- [x] Lifecycle: `@PostConstruct` / `@PreDestroy`
- [x] AOP: `ProxyFactory`, JDK Dynamic Proxy vs CGLIB
- [x] SpEL / `@Value` / `${}` / `#{}`
- [x] `@PropertySource` и приоритеты
- [x] `@ConfigurationProperties` (relaxed binding)
- [x] События (`@EventListener`, Spring 4.2+ POJO)
- [x] **Теория:** Spring Core vs Spring Boot (автоконфигурация)

### ⏳ Spring Boot (курс №2, проект 2 — в процессе)

- [x] Старт Spring Boot проекта (шаг 1, 🟡 без практики)
- [x] Автоконфигурация, профили (шаг 2, 🟢 80%)
- [x] REST API: `@RestController`, `@GetMapping` (шаг 3, 🟢 93%)
- [x] DTO + валидация, `@RestControllerAdvice` (шаг 4, 🟢 85%)
- [x] Spring Data JPA: `@Entity`, `JpaRepository` (шаг 5)
- [x] `@Transactional`
- [x] Миграции: Flyway (шаг 7)
- [x] Query: JPQL, native, Specification (шаг 8, 🟢 ~75%)
- [x] Spring Security basics (шаг 9, 🟢 ~87%)
- [ ] JWT (шаг 10 — запланирован)
- [ ] Method Security (`@PreAuthorize`) (шаг 11)
- [ ] Testing (шаг 12)
- [ ] Actuator (шаг 13)
- [ ] Кэширование (шаг 14)
- [ ] Финал / ревью (шаг 15)

### ⏳ AlgoBank (курс №3, проект 3 — старт сегодня)

- [ ] **Шаг 1:** Collections framework (List/Set/Map, HashMap внутри)
- [ ] **Шаг 2:** Generics, equals/hashCode, immutability
- [ ] **Шаг 3:** Stream API + Optional + лямбды
- [ ] **Шаг 4:** Records, sealed, pattern matching (Java 21)
- [ ] **Шаги 5-14:** Spring Boot (REST, JPA, Security, JWT, кэш, тесты) внутри AlgoBank
- [ ] **Шаги 15-17:** Многопоточность + JVM
- [ ] **Шаги 18-19:** SQL для собеседования
- [ ] **Шаги 20-21:** Структуры данных
- [ ] **Шаги 22-24:** Алгоритмы (паттерны)
- [ ] **Шаг 25:** LeetCode марафон
- [ ] **Шаг 26:** Финальная шпаргалка + mock-собеседование

---

## 🏆 Готовность к собеседованию (общая оценка)

| Уровень | Описание | Текущий статус |
|---------|----------|----------------|
| 🟢 Junior+ | Знает Spring Core, может ответить на базовые вопросы | **Достигнут** после Core (85%) |
| 🟡 Middle | Знает Spring Boot, JPA, транзакции, умеет писать REST API | **В процессе** (Boot 82%) |
| 🔴 Middle+ | Знает Security, тесты, deployment, оптимизации, алгоритмы, SQL, многопоточность, JVM | **Цель AlgoBank** |

**Текущая оценка:** Junior+ (после SpringCore и в процессе SpringBoot).
**Цель после AlgoBank:** Middle (универсал — пройдёт везде).

---

## 📅 Цели и дедлайны (заполняется учеником)

| Цель | Дедлайн | Статус |
|------|---------|--------|
| Пройти Spring Core | 28.08.2026 | ✅ done |
| Пройти Spring Boot | _TBD_ | ⏳ шаг 9/15 |
| Пройти AlgoBank | _TBD_ | ⏳ шаг 0/26 (старт сегодня) |
| Сдать собеседование | _TBD_ | ⏳ |

---

## 🔖 Контрольные точки (чеклист «готов к собесу»)

По окончании AlgoBank ученик должен уметь:

- [x] Объяснить IoC, DI, Bean Lifecycle своими словами (курс №1, 85%)
- [x] Написать REST API на Spring Boot с валидацией (SpringBootProject, шаги 3-4 ✅, ~89%)
- [x] Подключить БД через Spring Data JPA, написать `@Transactional` сервис (SpringBootProject, шаги 5-6 ✅, ~78%)
- [x] Написать миграции через Flyway, делать JPQL/native/Specification запросы (SpringBootProject, шаги 7-8 ✅, ~73%)
- [x] Spring Security basics (SpringBootProject, шаг 9 ✅, ~87%)
- [ ] Защитить endpoints через Spring Security + JWT (SpringBootProject, шаг 10)
- [ ] Написать интеграционный тест с `@SpringBootTest` (SpringBootProject, шаг 12)
- [ ] **Уверенный Java Core** (AlgoBank, шаги 1-4)
- [ ] **60+ алгоритмических задач** (AlgoBank, шаги 1-25)
- [ ] **SQL JOIN/CTE/оконные функции + EXPLAIN** (AlgoBank, шаги 18-19)
- [ ] **Многопоточность** (AlgoBank, шаги 15-16)
- [ ] **JVM heap/stack/GC** (AlgoBank, шаг 17)
- [ ] **Финальная шпаргалка** (AlgoBank, шаг 26)

**Прогресс:** 5 / 13 (38%) — по контрольным точкам чеклиста

**Прогресс по шагам:** 21 / 53 (40%) — Spring Core (12) + Spring Boot (9) + AlgoBank (0)

---

*Файл создан 28.08.2026 при старте курса №2. Последнее обновление: 11.09.2026 (добавлен AlgoBank как проект №3).*


## 🔴 Сквозные пробелы (по всем проектам)

> Эти темы остались с баллом <70% или не разбирались. Тянутся в AlgoBank.

| Тема | Где пробел | Балл | План |
|------|------------|------|------|
| Java Core | AlgoBank, не начинали | 🔴 слабо (JavaRush 4 года назад) | Экспресс-повторение в шагах 1-4 |
| Несколько конструкторов в бине | Core, шаг 1 | 🔴 30% | Закрыть в AlgoBank |
| Lazy initialization (`@Lazy`) | Core, не разбирали | 🔴 10% | SpringBootProject, шаг 6 |
| `ApplicationContext` internals | Core, не разбирали | 🔴 10% | SpringBootProject, шаг 6 |
| Транзакции | Boot, шаг 6 | 🟢 65–95% | OK |
| Spring Security | Boot, шаг 9 | 🟢 87% | OK, JWT на шаге 10 |
| Тестирование | Core, не разбирали | — | AlgoBank, шаг 14 |
| Алгоритмы | AlgoBank, не начинали | 🔴 слабо | Шаги 1-25 (60-80 задач) |
| SQL | AlgoBank, не начинали | 🟡 средне | Шаги 18-19 |
| Многопоточность | AlgoBank, не начинали | 🔴 слабо | Шаги 15-16 |
| JVM | AlgoBank, не начинали | 🔴 слабо | Шаг 17 |

---

| AlgoBank | 11.09.2026 → _TBD_ | 0.2 (старт сегодня) |
| **ИТОГО** | | **39.1+ ч** |

**Средняя скорость по Core:** ~1.4 ч/шаг

---
