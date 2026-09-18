package ru.algobank.algo.step05;

public class BankGreeter {
    public static String greet(String name) {
        if (name == null||name.isBlank()) return "Здравствуйте, гость!";
        return "Здравствуйте, " + name + "!";
    }
}
