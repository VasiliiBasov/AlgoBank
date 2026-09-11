package ru.algobank.algo.step01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListBenchmark {

    public static void main(String[] args) {
        ArrayList<Integer> list = IntStream.range(0,100_000).boxed().collect(Collectors.toCollection(ArrayList::new));
        LinkedList<Integer> linkedList = IntStream.range(0,100_000).boxed().collect(Collectors.toCollection(LinkedList::new));

        System.out.println("ArrayList: " + getCenter1k(list) + " | " + addLast1k(list) + " | " + addStart1k(list));
        System.out.println("LinkedList: " + getCenter1k(linkedList) + " | " + addLast1k(linkedList) + " | " + addStart1k(linkedList));
    }

    public static String getCenter1k(List<Integer> list){
        long time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.get(50000);
        }
        long elapsed = System.nanoTime() - time;
        return "get(50000)=" + (elapsed/1000) + " мкс";
    }

    public static String addLast1k(List<Integer> list){
        long time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(1);
        }
        long elapsed = System.nanoTime() - time;
        return "addLast=" + (elapsed/1000) + " мкс";
    }

    public static String addStart1k(List<Integer> list){
        long time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.add(0, 1);
        }
        long elapsed = System.nanoTime() - time;
        return "addStart1k time: " + (elapsed/1000) + " мкс";
    }
}
