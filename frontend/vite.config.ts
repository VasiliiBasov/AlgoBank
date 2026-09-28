import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// Dev-server :5173; /api и /actuator проксируются на бэкенд :8082 → CORS не нужен.
export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
    proxy: {
      "/api": { target: "http://localhost:8082", changeOrigin: true },
      "/actuator": { target: "http://localhost:8082", changeOrigin: true },
    },
  },
});
