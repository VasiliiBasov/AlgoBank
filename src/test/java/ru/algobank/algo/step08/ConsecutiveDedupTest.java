package ru.algobank.algo.step08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Шаг 8 · algo «Сжатие подряд-дублей» (тестовое задание с собеседования 30.09.2026).
 * Контракт: {@link ConsecutiveDedup#squeezeConsecutive(int[])} — новый массив без
 * ПОДРЯД идущих повторов; вход не мутируется; null → IllegalArgumentException.
 * Известные значения в ожиданиях — часть приёмки (как в sqldrills).
 */
class ConsecutiveDedupTest {

    @Test
    void emptyStaysEmpty() {
        assertArrayEquals(new int[0], ConsecutiveDedup.squeezeConsecutive(new int[0]));
    }

    @Test
    void nullIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> ConsecutiveDedup.squeezeConsecutive(null));
    }

    @Test
    void singleElementUnchanged() {
        assertArrayEquals(new int[]{42}, ConsecutiveDedup.squeezeConsecutive(new int[]{42}));
    }

    @Test
    void noDuplicates_newArraySameContent() {
        int[] in = {1, 2, 3, 4};
        int[] out = ConsecutiveDedup.squeezeConsecutive(in);
        assertArrayEquals(new int[]{1, 2, 3, 4}, out);
        assertNotSame(in, out); // именно НОВЫЙ массив, не возврат входа
    }

    @Test
    void allSameCollapsesToOne() {
        assertArrayEquals(new int[]{7}, ConsecutiveDedup.squeezeConsecutive(new int[]{7, 7, 7, 7}));
    }

    @Test
    void classicRunCompression() {
        assertArrayEquals(new int[]{1, 2, 3, 1},
                ConsecutiveDedup.squeezeConsecutive(new int[]{1, 1, 2, 2, 2, 3, 1, 1}));
    }

    @Test
    void repeatedValueAfterGapIsKept_keyTrapCase() {
        // гвоздь задачи: 4 встречается дважды, но НЕ подряд → обе остаются
        assertArrayEquals(new int[]{4, 2, 7, 4},
                ConsecutiveDedup.squeezeConsecutive(new int[]{4, 4, 2, 2, 2, 7, 7, 4}));
    }

    @Test
    void negativesAndZeroSupported() {
        assertArrayEquals(new int[]{-1, 0, -1},
                ConsecutiveDedup.squeezeConsecutive(new int[]{-1, -1, 0, 0, -1}));
    }

    @Test
    void inputIsNotMutated() {
        int[] in = {5, 5, 6};
        ConsecutiveDedup.squeezeConsecutive(in);
        assertArrayEquals(new int[]{5, 5, 6}, in); // вход должен остаться нетронутым
    }
}
