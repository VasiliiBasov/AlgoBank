import { useCallback, useEffect, useState } from "react";
import type { FormEvent } from "react";
import { api, ApiError } from "./api";
import type { Greeting, Health, ProblemDetail } from "./api";

/* ---------------- состояние запросов ---------------- */

type Result<T> =
  | { kind: "idle" }
  | { kind: "loading" }
  | { kind: "ok"; data: T }
  | { kind: "err"; status?: number; message: string; problem?: ProblemDetail | null };

const IDLE: Result<never> = { kind: "idle" };

function toErr(e: unknown): Result<never> {
  if (e instanceof ApiError) {
    return {
      kind: "err",
      status: e.status,
      problem: e.problem,
      message: e.problem?.detail ?? e.problem?.title ?? `Ошибка HTTP ${e.status}`,
    };
  }
  return {
    kind: "err",
    message: "Бэкенд недоступен — подними AlgoBankApplication (порт 8082) и попробуй снова",
  };
}

function fmtInstant(iso: string): string {
  const d = new Date(iso);
  return Number.isNaN(d.getTime()) ? iso : d.toLocaleString("ru-RU");
}

const BACKEND = "http://localhost:8082";

const ROADMAP = [
  {
    step: "шаг 8",
    title: "Счета",
    text: "GET /api/accounts — список счетов из H2. Оживёт, когда появится AccountController.",
  },
  {
    step: "шаг 8",
    title: "Переводы + циклы в графе",
    text: "POST /api/transfers — @Transactional перевод между счетами; отрисуем граф и найденные циклы.",
  },
  {
    step: "шаг 9–10",
    title: "Логин / JWT",
    text: "Форма аутентификации: Spring Security → JWT в Authorization-заголовке.",
  },
  {
    step: "шаг 11",
    title: "Top-K транзакций",
    text: "Запросы Spring Data: топ операций по счёту с сортировкой и лимитом.",
  },
];

/* ---------------- мелкие вьюхи ---------------- */

function GreetingView({ g }: { g: Greeting }) {
  return (
    <div className="well">
      <div className="kv">
        <span className="k">bankName</span>
        <span className="v v--accent">{g.bankName}</span>
      </div>
      <div className="kv">
        <span className="k">message</span>
        <span className="v">{g.message}</span>
      </div>
      <div className="kv">
        <span className="k">timestamp</span>
        <span className="v">{fmtInstant(g.timestamp)}</span>
      </div>
      <details className="raw">
        <summary>сырый JSON</summary>
        <pre>{JSON.stringify(g, null, 2)}</pre>
      </details>
    </div>
  );
}

function ErrorView({ r }: { r: Extract<Result<never>, { kind: "err" }> }) {
  return (
    <div className="well well--err">
      <div className="kv">
        <span className="k">status</span>
        <span className="chip chip--rose">{r.status ?? "нет ответа"}</span>
      </div>
      {r.problem?.title && (
        <div className="kv">
          <span className="k">title</span>
          <span className="v">{r.problem.title}</span>
        </div>
      )}
      <div className="kv">
        <span className="k">detail</span>
        <span className="v">{r.message}</span>
      </div>
      {r.problem?.instance && (
        <div className="kv">
          <span className="k">instance</span>
          <span className="v">{r.problem.instance}</span>
        </div>
      )}
    </div>
  );
}

function Spinner({ label }: { label: string }) {
  return (
    <div className="well well--loading">
      <span className="spin" aria-hidden />
      <span>{label}</span>
    </div>
  );
}

/* ---------------- карточки ---------------- */

function HelloCard() {
  const [r, setR] = useState<Result<Greeting>>(IDLE);

  const load = async () => {
    setR({ kind: "loading" });
    try {
      setR({ kind: "ok", data: await api.hello() });
    } catch (e) {
      setR(toErr(e));
    }
  };

  return (
    <section className="card">
      <header className="card-head">
        <div>
          <span className="method method--get">GET</span>
          <code className="path">/api/hello</code>
        </div>
        <span className="tag tag--cyan">шаг 5B</span>
      </header>
      <p className="card-text">Приветствие банка — первый JSON-response проекта.</p>
      <button className="btn" onClick={load} disabled={r.kind === "loading"}>
        Запросить
      </button>
      {r.kind === "loading" && <Spinner label="GET /api/hello…" />}
      {r.kind === "ok" && <GreetingView g={r.data} />}
      {r.kind === "err" && <ErrorView r={r} />}
    </section>
  );
}

function GreetCard() {
  const [name, setName] = useState("");
  const [r, setR] = useState<Result<Greeting>>(IDLE);

  const submit = async (e: FormEvent) => {
    e.preventDefault();
    setR({ kind: "loading" });
    try {
      setR({ kind: "ok", data: await api.greet(name) });
    } catch (err) {
      setR(toErr(err));
    }
  };

  return (
    <section className="card">
      <header className="card-head">
        <div>
          <span className="method method--post">POST</span>
          <code className="path">/api/greet</code>
        </div>
        <span className="tag tag--violet">шаг 6A–6B</span>
      </header>
      <p className="card-text">Персональное приветствие через бин BankGreeter.</p>
      <form onSubmit={submit} className="form">
        <input
          className="input"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Имя… (напр. Vasilii)"
        />
        <button className="btn" type="submit" disabled={r.kind === "loading"}>
          Поздороваться
        </button>
      </form>
      <p className="hint">
        ✦ оставь имя пустым или одни пробелы → увидишь наш ProblemDetail 400 из шага 6B
      </p>
      {r.kind === "loading" && <Spinner label="POST /api/greet…" />}
      {r.kind === "ok" && <GreetingView g={r.data} />}
      {r.kind === "err" && <ErrorView r={r} />}
    </section>
  );
}

function HealthCard({ health, checkedAt, refresh }: { health: Result<Health>; checkedAt: Date | null; refresh: () => void }) {
  return (
    <section className="card">
      <header className="card-head">
        <div>
          <span className="method method--get">GET</span>
          <code className="path">/actuator/health</code>
        </div>
        <span className="tag tag--mint">actuator</span>
      </header>
      <p className="card-text">Жив ли бэкенд: авто-опрос каждые 10 секунд.</p>
      <div className="well">
        <div className="kv">
          <span className="k">status</span>
          <span className="v">
            {health.kind === "ok" ? (
              <span className={health.data.status === "UP" ? "mint" : "rose"}>{health.data.status}</span>
            ) : health.kind === "err" ? (
              <span className="rose">недоступен</span>
            ) : (
              <span className="muted">проверяю…</span>
            )}
          </span>
        </div>
        <div className="kv">
          <span className="k">checked</span>
          <span className="v">{checkedAt ? checkedAt.toLocaleTimeString("ru-RU") : "—"}</span>
        </div>
      </div>
      <button className="btn btn--ghost" onClick={refresh}>
        Обновить сейчас
      </button>
    </section>
  );
}

function SkeletonCard({ step, title, text }: { step: string; title: string; text: string }) {
  return (
    <section className="card card--skel">
      <header className="card-head">
        <span className="skel-ico" aria-hidden>
          ✦
        </span>
        <span className="tag tag--ghost">{step}</span>
      </header>
      <h3 className="skel-title">{title}</h3>
      <p className="card-text">{text}</p>
    </section>
  );
}

/* ---------------- каркас ---------------- */

export default function App() {
  const [health, setHealth] = useState<Result<Health>>(IDLE);
  const [checkedAt, setCheckedAt] = useState<Date | null>(null);

  const refreshHealth = useCallback(async () => {
    try {
      const data = await api.health();
      setHealth({ kind: "ok", data });
    } catch (e) {
      setHealth(toErr(e));
    } finally {
      setCheckedAt(new Date());
    }
  }, []);

  useEffect(() => {
    refreshHealth();
    const id = setInterval(refreshHealth, 10_000);
    return () => clearInterval(id);
  }, [refreshHealth]);

  const up = health.kind === "ok" && health.data.status === "UP";

  return (
    <div className="app">
      <div className="container">
        <header className="topbar">
          <div className="brand">
            <span className="logo-mark">₽</span>
            <div>
              <div className="brand-name">AlgoBank</div>
              <div className="brand-sub">demo ui · внешний контур</div>
            </div>
          </div>
          <div className="top-actions">
            <span className={`pill ${health.kind === "idle" || health.kind === "loading" ? "" : up ? "pill--up" : "pill--down"}`}>
              <span className="dot" />
              {health.kind === "idle" || health.kind === "loading" ? "проверяю…" : up ? "backend UP" : "backend DOWN"}
            </span>
            <a className="btn btn--ghost btn--sm" href={`${BACKEND}/swagger-ui/index.html`} target="_blank" rel="noreferrer">
              Swagger ↗
            </a>
            <a className="btn btn--ghost btn--sm" href={`${BACKEND}/h2-console`} target="_blank" rel="noreferrer">
              H2 Console ↗
            </a>
          </div>
        </header>

        <section className="hero">
          <h1>
            Что умеет наш банк <span className="grad">снаружи</span>
          </h1>
          <p>
            Живые эндпоинты — уже сейчас; скелеты ниже зажгутся по мере прохождения шагов курса.
            Прокси <code>/api</code> и <code>/actuator</code> → <code>localhost:8082</code>, CORS не нужен.
          </p>
        </section>

        <main className="grid">
          <HelloCard />
          <GreetCard />
          <HealthCard health={health} checkedAt={checkedAt} refresh={refreshHealth} />
          {ROADMAP.map((s) => (
            <SkeletonCard key={s.title} {...s} />
          ))}
        </main>

        <footer className="foot">
          Demo UI живёт вне учебного трека (React + Vite + TS, пишется ассистентом) — бэкенд-эндпоинты
          по-прежнему пишет ученик по шагам курса. ✦ AlgoBank · шаг 7/26 закрыт · впереди переводы
        </footer>
      </div>
    </div>
  );
}
