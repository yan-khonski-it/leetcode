package com.yk.training.leetcode.two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> reminders = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = target - nums[i];
            Integer index1 = reminders.get(num1);

            if (index1 != null) {
                return new int[]{index1, i};
            }

            reminders.put(nums[i], i);
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 7, 9};
        System.out.println(arrayToString(twoSum(array, 11)));
    }

    private static String arrayToString(final int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }

        return sb.toString();
    }
}