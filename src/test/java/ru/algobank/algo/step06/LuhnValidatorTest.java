package ru.algobank.algo.step06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LuhnValidatorTest {

    @Test
    void digitsAfterNormalization_returnsTrue() {
        assertTrue(LuhnValidator.isValid("4111 1111 1111 1111"));
    }

    @Test
    void separatedByHyphens_returnsTrue() {
        assertTrue(LuhnValidator.isValid("4111-1111-1111-1111"));
    }

    @Test
    void trueTestCard_returnsTrue() {
        assertTrue(LuhnValidator.isValid("4242424242424242"));
    }

    @Test
    void notValidDegits_returnsFalse() {
        assertFalse(LuhnValidator.isValid("4111 1111 1111 1112"));
    }

    @Test
    void notValidBeautyDegits_returnsFalse() {
        assertFalse(LuhnValidator.isValid("1234567812345678"));
    }

    @Test
    void notValidDegitsIn_returnsFalse() {
        assertFalse(LuhnValidator.isValid(null));
        assertFalse(LuhnValidator.isValid(""));
        assertFalse(LuhnValidator.isValid(" "));
    }

    @Test
    void lengthOfDigitsLessThanTwo_returnsFalse() {
        assertFalse(LuhnValidator.isValid("0"));
    }

    @Test
    void charInDegits_returnsFalse() {
        assertFalse(LuhnValidator.isValid("4111A111111111111"));
    }
}
