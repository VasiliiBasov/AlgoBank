package ru.algobank.algo.step06;

import java.util.Objects;

public final class IbanPalindrome {
    public static boolean isPalindrome(String raw) {
        if (Objects.isNull(raw)) return false;
        String norm = raw.chars()
                .filter(c -> Character.isLetterOrDigit(c) && c < 128)
                .map(Character::toUpperCase)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        if (norm.isBlank()) return false;
        for (int lo = 0, hi = norm.length()-1; lo < hi; lo++, hi--) {
            if (norm.charAt(lo) != norm.charAt(hi)) {
                return false;
            }
        }
        return true;

    }

    private IbanPalindrome() {
    }
}
