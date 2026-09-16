package ru.algobank.algo.step03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaPlayground {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Carol", "Dave", "Eve");

        List<String> longNames = names.stream()
                .filter(name -> name.length() > 3)
                .toList();
        System.out.println("Long names: " + longNames);

        names.forEach(System.out::println);

        names.stream()
                .sorted((a, b) -> b.length() - a.length())
                .forEach(System.out::println);

        Function<String, String> toUpper = String::toUpperCase;
        List<String> upper = names.stream().map(toUpper).toList();
        System.out.println("Upper: " + upper);

        Supplier<List<String>> emptyList = ArrayList::new;
        List<String> list = emptyList.get();
        list.add("generated");
        System.out.println("Generated list: " + list);

        BiFunction<String, String, String> concat = String::concat;
        System.out.println("Concat: " + concat.apply("Hello, ", "World!"));
    }
}
