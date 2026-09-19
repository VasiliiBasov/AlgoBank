package ru.algobank.algo.step05;

import org.springframework.stereotype.Component;

@Component
public class BankGreeter {
    public String greet(String name) {
        if (name == null||name.isBlank()) return "Здравствуйте, гость!";
        return "Здравствуйте, " + name + "!";
    }
}
