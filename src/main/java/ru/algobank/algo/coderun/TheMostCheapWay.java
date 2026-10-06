package ru.algobank.algo.coderun;

import java.io.*;
import java.util.Arrays;

public class TheMostCheapWay {
//Вторая задача из coderun
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */
        int[] ints = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = ints[0];
        int y = ints[1];
        int[][] matrix = new int[x][y];

        for (int i = 0; i < x; i++) {
            int[] row = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(row, 0, matrix[i], 0, y);
        }
        System.out.println(Arrays.deepToString(matrix));

        int[][] weight = new int[x][y];


        reader.close();
        writer.close();
    }
}
