package ru.algobank.algo.step07;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionDedupTest {

    @Test
    void emptyInput_returnsEmpty() {
        assertEquals(List.of(), TransactionDedup.dedup(List.of()));
    }

    @Test
    void noDuplicates_returnsSameList() {
        assertEquals(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 6000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(2, 6000, LocalDate.of(2006, 07, 04))),
                TransactionDedup.dedup(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 6000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(2, 6000, LocalDate.of(2006, 07, 04)))));
    }

    @Test
    void sameKeyDuplicate_isDropped() {
        assertEquals(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 6000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2006, 07, 04))),
                TransactionDedup.dedup(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 6000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(3, 6000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2006, 07, 04)))));
    }

    @Test
    void sameDateDifferentAmounts_areKept() {
        assertEquals(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 5000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2006, 07, 04)),
                        new TransactionDedup.MoneyTx(5, 8000, LocalDate.of(2006, 07, 04))),
                TransactionDedup.dedup(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 5000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2006, 07, 04)),
                        new TransactionDedup.MoneyTx(5, 8000, LocalDate.of(2006, 07, 04))
                )));
    }

    @Test
    void twoIdentical_firstSurvives() {
        assertEquals(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 5000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2004, 07, 04)),
                        new TransactionDedup.MoneyTx(5, 8000, LocalDate.of(2006, 07, 04))),
                TransactionDedup.dedup(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 5000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2004, 07, 04)),
                        new TransactionDedup.MoneyTx(5, 8000, LocalDate.of(2006, 07, 04)),
                        new TransactionDedup.MoneyTx(6, 1000, LocalDate.of(2000, 01, 01))
                )));
    }

    @Test
    void threeIdentical_firstSurvives() {
        assertEquals(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 5000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2004, 07, 04)),
                        new TransactionDedup.MoneyTx(5, 8000, LocalDate.of(2006, 07, 04))),
                TransactionDedup.dedup(List.of(new TransactionDedup.MoneyTx(1, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(2, 5000, LocalDate.of(2001, 07, 04)),
                        new TransactionDedup.MoneyTx(4, 6000, LocalDate.of(2004, 07, 04)),
                        new TransactionDedup.MoneyTx(5, 8000, LocalDate.of(2006, 07, 04)),
                        new TransactionDedup.MoneyTx(6, 1000, LocalDate.of(2000, 01, 01)),
                        new TransactionDedup.MoneyTx(7, 1000, LocalDate.of(2000, 01, 01))
                )));
    }
}
