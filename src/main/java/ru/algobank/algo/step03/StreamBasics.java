package ru.algobank.algo.step03;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class StreamBasics {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("Java", "Stream", "API", "Lambda", "Function", "Optional");

        //1
        List<Integer> evens = numbers.stream()
                .filter(s -> s%2==0)
                .toList();
        System.out.println("Evens: " + evens);

        //2
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("Squares: " + squares);

        //3
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println("EvenSquares: " + evenSquares);

        //4
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        //5
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);
        System.out.println("Max: " + max.orElse(-1));

        //6
        boolean hasBig = numbers.stream().anyMatch(n -> n > 5);
        System.out.println("HasBig: " + hasBig);

        //7
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("AllPositive: " + allPositive);

        //8
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println("firstEven: " + firstEven.orElse(-1));

        //9
        int sumOfSquares = numbers.stream()
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("Сумма квадратов (IntStream): " + sumOfSquares);

        //10
        List<String> digits = numbers.stream()
                .map(n -> String.valueOf(n))
                .flatMap(s -> Arrays.stream(s.split("")))
                .distinct()
                .sorted()
                .toList();
        System.out.println("Уникальные цифры: " + digits);

        //11
        int longest = words.stream()
                .mapToInt(String::length)
                .max().getAsInt();
        System.out.println("Longest: " + longest);

    }
}
