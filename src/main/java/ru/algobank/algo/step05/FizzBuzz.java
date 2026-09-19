package ru.algobank.algo.step05;


import java.util.Arrays;
import java.util.stream.Collectors;

public class FizzBuzz {

    public static String convert(int n) {
        if (n % 15 == 0) {
            return "FizzBuzz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(n);
    }
}
