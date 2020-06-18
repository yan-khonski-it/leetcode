package com.yk.training.leetcode.numbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class KthSmallestNumber {

    private static final int MAX_INT = 1000000;

    public static void main(String[] args) {
        final int n = 100000;
        final int[] array = buildArray(n);
        int k = 3;
        final int kthSmallest = smallestNumber(array, k);
        Arrays.sort(array);
        final int check = array[k - 1];
        System.out.println("Check: " + check + "; k-th smallest: " + kthSmallest);
    }

    private static int smallestNumber(final int[] array, final int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            maxHeap.add(array[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }

    private static int[] buildArray(final int n) {
        final int[] array = new int[n];
        final Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(MAX_INT);
        }

        return array;
    }
}
