# AlgoBank Demo UI

Внешняя витрина учебного REST API **AlgoBank** (React + Vite + TypeScript, «мягкий неон» / premium glass).

> Живёт **вне учебного трека**: код бэкенда (Java) пишет ученик по шагам курса,
> этот фронт пишется ассистентом как наглядный «внешний контур» — видно, что именно
> меняется снаружи на каждом шаге.

## Запуск

```bash
# 1) поднять бэкенд (порт 8082):  mvn spring-boot:run  из корня проекта (JDK 24)
# 2) из папки frontend:
npm install
npm run dev     # → http://localhost:5173
```

CORS не нужен: dev-server Vite проксирует `/api` и `/actuator` на `http://localhost:8082`
(см. `vite.config.ts`).

## Что уже живо

| Панель | Эндпоинт | Шаг курса |
|---|---|---|
| Приветствие | `GET /api/hello` | 5B |
| Персональный greet + ProblemDetail 400 | `POST /api/greet` | 6A–6B |
| Статус бэкенда (поллинг 10 с) | `GET /actuator/health` | actuator |

## Скелеты (зажгутся на шагах)

- **Счета** — шаг 8 (`AccountController`)
- **Переводы + циклы в графе** — шаг 8 (`@Transactional`)
- **Логин / JWT** — шаги 9–10
- **Top-K транзакций** — шаг 11

## Прод-путь (опционально, позже)

```bash
npm run build   # dist/ → можно скопировать в src/main/resources/static/ и отдавать тем же Spring Boot
```
