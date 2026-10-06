package ru.algobank.algo.coderun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MiddleElement {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        String str = reader.readLine();
        int[] ints = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        writer.write(String.valueOf(ints[1]));
        reader.close();
        writer.close();
    }
}
