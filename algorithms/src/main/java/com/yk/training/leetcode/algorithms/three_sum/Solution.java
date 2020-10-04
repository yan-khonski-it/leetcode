package com.yk.training.leetcode.algorithms.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(array);
        printRes(res);
    }

    private static void printRes(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return List.of();
        }

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);


        for (int i = 1; i < nums.length - 1; i++) {
            int right = nums.length - 1;
            int left = 0;

            while (left < i && i < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    res.add(List.of(nums[left++], nums[i], nums[right--]));

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
