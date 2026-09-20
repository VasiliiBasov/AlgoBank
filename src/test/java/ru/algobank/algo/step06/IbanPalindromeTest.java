package ru.algobank.algo.step06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IbanPalindromeTest {

    @Test
    void formattedPalindrome_ignoresSpacesAndHyphens() {
        assertTrue(IbanPalindrome.isPalindrome("NO16 8496-1111 6948-61ON"));
    }
    @Test
    void realIban_notPalindrome_returnsFalse() {
        assertFalse(IbanPalindrome.isPalindrome("NO16 8496 1111 9000"));
    }
    @Test
    void nullInput_returnsFalse() {
        assertFalse(IbanPalindrome.isPalindrome(null));
    }
    @Test
    void emptyAfterNormalization_returnsFalse() {
        assertFalse(IbanPalindrome.isPalindrome(""));
    }
    @Test
    void mixedCase_isPalindromeIgnoresCase() {
        assertTrue(IbanPalindrome.isPalindrome("a B a"));
    }
}
