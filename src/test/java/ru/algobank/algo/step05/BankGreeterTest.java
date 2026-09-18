package ru.algobank.algo.step05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankGreeterTest {

    @Test
    void testName() {
        assertEquals("Здравствуйте, Иван!", BankGreeter.greet("Иван"));
    }
    @Test
    void testNameNull() {
        assertEquals("Здравствуйте, гость!", BankGreeter.greet(null));
    }
    @Test
    void testNameEmpty() {
        assertEquals("Здравствуйте, гость!", BankGreeter.greet(""));
    }
    @Test
    void testNameSpace() {
        assertEquals("Здравствуйте, гость!", BankGreeter.greet(" "));
    }
}
