package ru.algobank.algo.step07;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionDuplicatesTest {
    @Test
    void blankList() {
        assertEquals(Set.of(), TransactionDuplicates.findDuplicates(List.of()));
    }

    @Test
    void withoutDuplicates() {
        assertEquals(Set.of(), TransactionDuplicates.findDuplicates(List.of(900001L, 900002L, 900003L)));
    }

    @Test
    void oneDuplicate() {
        assertEquals(Set.of(90L), TransactionDuplicates.findDuplicates(List.of(900001L, 90L, 900002L, 900003L, 90L)));
    }

    @Test
    void manyDuplicates() {
        assertEquals(Set.of(900003L, 90L), TransactionDuplicates.findDuplicates(List.of(900003L, 900001L, 90L, 900002L, 900003L, 90L)));
    }

    @Test
    void threeDuplicates() {
        assertEquals(Set.of(900003L, 90L), TransactionDuplicates.findDuplicates(List.of(90L, 900003L, 900001L, 90L, 900002L, 900003L, 90L)));
    }


}
