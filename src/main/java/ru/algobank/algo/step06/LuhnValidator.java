package ru.algobank.algo.step06;

public final class LuhnValidator {
    private LuhnValidator() {
    }

    //Для читаемости сохраняем в пременную. Немного символов (<34)
    //не влияет на скорость. При больших количествах можно сделать
    //одной проходкой (O(1)).
    public static boolean isValid(String cardNumber) {
        if (cardNumber == null || cardNumber.isBlank()) return false;

        if (cardNumber.chars().anyMatch(c -> !(c >= '0' && c <= '9')
                && c != ' ' && c != '-')) return false;

        String numbs = cardNumber.chars().filter(c -> c >= '0' && c <= '9')
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        if (numbs.length() < 2) return false;
        int sum = 0;
        for (int i = numbs.length() - 1; i >= 0; i--) {
            int num = numbs.charAt(i) - '0';
            if ((numbs.length() - i - 1) % 2 == 1) {
                num *= 2;
            }
            if (num > 9) num -= 9;
            sum += num;
        }
        return sum % 10 == 0;
    }
}
