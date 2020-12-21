package com.yk.training.leetcode.algorithms.duplicates_in_sorted_array;

import java.util.Arrays;

/**
 * Given a sorted array nums,
 * remove the duplicates in-place such that each element appears only once and returns the new length.
 * <p>
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * https://leetcode.com/submissions/detail/433087067/
 */
public class Solution {

    public static void main(String[] args) {
        final Solution solution = new Solution();
        final int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        final int newArraySize = solution.removeDuplicates(array);
        System.out.println(newArraySize);
        System.out.println(Arrays.toString(array));
    }

    public int removeDuplicates(final int[] array) {
        final int size = array.length;
        if (size == 0 || size == 1) {
            return size;
        }

        int previous = array[0];
        int deltaIndex = 0;

        for (int i = 1; i < size - deltaIndex; i++) {
            while (i + deltaIndex < size && previous == array[i + deltaIndex]) {
                deltaIndex++;
            }

            if (i + deltaIndex == size) {
                return size - deltaIndex;
            }

            previous = array[i + deltaIndex];
            array[i] = array[i + deltaIndex];
        }

        return size - deltaIndex;
    }
}
