package ru.algobank.algo.step08;

import java.util.ArrayList;

/**
 * Шаг 8 · algo (тестовое задание с реального собеседования, 30.09.2026).
 * <p>
 * «Сжатие подряд идущих дубликатов»: принять массив чисел и вернуть НОВЫЙ массив,
 * в котором удалены повторы, идущие ПОДРЯД. Подряд — ключевое слово:
 * [4, 4, 2, 2, 2, 7, 7, 4] → [4, 2, 7, 4]  (последняя 4 НЕ удаляется — не подряд!).
 * <p>
 * ЗАГЛУШКА ментора (компиляция для красных тестов). Реализацию пишет ученик (правило №5).
 * Требования: O(n) по времени, исходный массив не изменять, null → IllegalArgumentException.
 * Приёмка: src/test/java/ru/algobank/algo/step08/ConsecutiveDedupTest.java — 9 зелёных.
 */
// TODO(step08-algo, ученик): реализовать тело метода
public class ConsecutiveDedup {

    public static int[] squeezeConsecutive(int[] nums) {

        if (nums == null) throw new IllegalArgumentException();
        if (nums.length == 0) return new int[0];
        int n = nums[0];
        ArrayList<Integer> clean = new ArrayList<>();
        clean.add(n);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) clean.add(nums[i]);
        }
        return clean.stream().mapToInt(Integer::intValue).toArray();
    }
}
