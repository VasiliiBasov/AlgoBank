// Контракты бэкенда AlgoBank (см. ru.algobank.dto + GlobalExceptionHandler).

/** record Greeting(String bankName, String message, Instant timestamp) */
export interface Greeting {
  bankName: string;
  message: string;
  /** Instant сериализуется в ISO-строку */
  timestamp: string;
}

/** RFC 9457: Spring ProblemDetail (наш GlobalExceptionHandler, шаг 6B) */
export interface ProblemDetail {
  type?: string;
  title?: string;
  status?: number;
  detail?: string;
  instance?: string;
}

/** Actuator /actuator/health */
export interface Health {
  status: string; // UP / DOWN / OUT_OF_SERVICE / UNKNOWN
}

export class ApiError extends Error {
  readonly status: number;
  readonly problem: ProblemDetail | null;

  constructor(status: number, problem: ProblemDetail | null) {
    super(problem?.detail ?? problem?.title ?? `HTTP ${status}`);
    this.name = "ApiError";
    this.status = status;
    this.problem = problem;
  }
}

async function request<T>(input: string, init?: RequestInit): Promise<T> {
  const res = await fetch(input, init);
  if (!res.ok) {
    let problem: ProblemDetail | null = null;
    try {
      problem = (await res.json()) as ProblemDetail;
    } catch {
      // тело не-JSON — оставляем null, покажем просто статус
    }
    throw new ApiError(res.status, problem);
  }
  return (await res.json()) as T;
}

export const api = {
  hello: () => request<Greeting>("/api/hello"),
  greet: (name: string) =>
    request<Greeting>("/api/greet", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name }),
    }),
  health: () => request<Health>("/actuator/health"),
};
