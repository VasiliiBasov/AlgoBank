package ru.algobank.algo.step05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    void multipleOfFive_returnsBuzz() {
        assertEquals("Buzz", FizzBuzz.convert(5));
    }
    @Test
    void multipleOfThree_returnsFizz() {
        assertEquals("Fizz", FizzBuzz.convert(3));
    }
    @Test
    void multipleOfFifteen_returnsFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.convert(15));
    }
    @Test
    void multipleOfNumber_returnsString() {
        assertEquals("2", FizzBuzz.convert(2));
    }
}
