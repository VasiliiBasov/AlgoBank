package ru.algobank.algo.step02;

import java.util.ArrayList;
import java.util.List;

public class GenericsPlayground {

    public static void printList(List<?> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach( item -> {
            if (sb.length() > 0) sb.append(", ");
            sb.append(item);
        });
        System.out.println(sb);
    }

    public static double sumNumbers(List<? extends Number> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void addIntegers(List<? super Integer> sink) {
        sink.add(1);
        sink.add(2);
        sink.add(3);
    }

    public static void main(String[] args) {
        List<String> strings = List.of("alice", "bob", "carol");
        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        List<Double> doubles = List.of(1.5, 2.5, 3.0);
        List<Number> numbers = new ArrayList<>();

        printList(strings);
        System.out.println("Сумма чисел ints: " + sumNumbers(ints));
        System.out.println("Сумма чисел doubles: " + sumNumbers(doubles));
        addIntegers(numbers);
        System.out.println("Numbers: " + numbers);
    }
}
