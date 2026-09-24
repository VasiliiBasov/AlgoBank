# 🏦 AlgoBank

Это учебный банковский backend на Spring Boot, 
через который я готовлюсь к собеседованию Java-разработчика.
Курс идёт с AI-ментором: задачи и код пишу сам, ассистент ставит вопросы,
проверяет, разбирает ошибки.
В планах фронтенд на react.

## 🛠 Технологии
- Java 21 / Spring Boot 4.0.8
- Maven, JUnit 5
- H2 (dev), Flyway, Spring Data JPA
- springdoc-openapi 3.x (Swagger UI), Lombok

## 🚀 Как запустить

```bash
git clone https://github.com/VasiliiBasov/AlgoBank.git
cd AlgoBank
mvn spring-boot:run
```

- Проверка: http://localhost:8082/api/hello
- H2-консоль: http://localhost:8082/h2-console (JDBC URL: `jdbc:h2:mem:algobank`, user `sa`, пароль пустой)

## 📡 Сейчас в проекте
- `GET /api/hello` → JSON-приветствие
- `POST /api/greet` → приветствие по имени: DTO + `@Valid`, ошибки валидации по RFC 9457 (`application/problem+json`)
- Swagger UI: `/swagger-ui/index.html` (springdoc-openapi 3.x, линейка для Boot 4)
- H2-консоль: `/h2-console` (jdbc:h2:mem:algobank)
- JPA-слой (в работе, шаг 7): `entity/Account` ↔ `entity/Transaction` + Flyway-миграции
- Алгоритмические задачи: `ru.algobank.algo.step01..06` + JUnit-тесты

Схема потока `GET /api/hello`: embedded Tomcat → SecurityConfig → HelloBankController → record Greeting. H2 подключена, но в запросах пока не участвует — ждёт JPA.

## 🧪 Тесты

```bash
mvn test
```

Каждая алгоритмическая задача шагов закрывается JUnit 5 тестами (правило курса). На 21.09.2026 покрыт **21 тест-кейс** (FizzBuzz, BankGreeter, IbanPalindrome, LuhnValidator).

## 🗺 Статус

Учебный курс-проект: **26 шагов** (Java Core → Spring Boot → многопоточность → SQL → алгоритмы → mock-собеседование).

**Текущий шаг: 7 / 26** — JPA entities + репозитории (Docker basics #1 ✅ 80/100; миграция Flyway V1 в работе).

Дневники прогресса ведутся прямо в репозитории: `PROGRESS.md`, `STATS.md`, `LEARNING_LOG.md`.
