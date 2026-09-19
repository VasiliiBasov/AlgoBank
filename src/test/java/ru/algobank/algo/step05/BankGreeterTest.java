package ru.algobank.algo.step05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankGreeterTest {


    BankGreeter bankGreeter = new BankGreeter();

    @Test
    void namedClient_greetsByName() {
        assertEquals("Здравствуйте, Иван!", bankGreeter.greet("Иван"));
    }
    @Test
    void namedClient_greetsByNull() {
        assertEquals("Здравствуйте, гость!", bankGreeter.greet(null));
    }
    @Test
    void namedClient_greetsByEmpty() {
        assertEquals("Здравствуйте, гость!", bankGreeter.greet(""));
    }
    @Test
    void namedClient_greetsBySpace() {
        assertEquals("Здравствуйте, гость!", bankGreeter.greet(" "));
    }
}
