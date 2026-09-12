package ru.algobank.algo.step01;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] findPairHM(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if  (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static int[] findPairBF(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void print(int[] nums, int target) {
        int [] result = findPairHM(nums, target);
        System.out.println(Arrays.toString(nums) + " target=" + target + " -> " + Arrays.toString(result));

    }

    public static void main(String[] args) {

        int[] t1 = {100, 250, 50, 400, 75};  // target=350  -> [0, 1]
        int[] t2 = {100, 250, 50, 400, 75};  // target=1000 -> [-1, -1]
        int[] t3 = {10, 20, 30};             // target=50   -> [1, 2]

        print(t1, 350);
        print(t2, 1000);
        print(t3, 50);
    }
}
