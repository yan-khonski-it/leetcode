package com.yk.training.leetcode.algorithms.binay_search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    private static final int MAX_INT = 10000;

    public static void main(final String[] args) {
        final int n = 1000;
        final int[] array = buildArray(n);
        Arrays.sort(array);

        long start = System.nanoTime();
        for (int i = 0; i < MAX_INT; i++) {
            linearSearch(array, i);
        }
        long end = System.nanoTime();
        long total = end - start;
        System.out.println("Linear : " + total);

        long start1 = System.nanoTime();
        for (int i = 0; i < MAX_INT; i++) {
            binarySearch(array, i);
        }
        long end1 = System.nanoTime();
        long total1 = end1 - start1;
        System.out.println("Binary : " + total1);
    }

    private static int[] buildArray(final int n) {
        final int[] array = new int[n];
        final Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(MAX_INT);
        }

        return array;
    }

    private static int linearSearch(final int[] array, final int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(final int[] array, final int element) {
        if (array == null || array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return array[0] == element ? 0 : -1;
        }

        int startIndex = 0;
        int endIndex = array.length;
        int middleIndex;

        if (array[0] > element || array[array.length - 1] < element) {
            return -1;
        }

        while (startIndex + 1 < endIndex) {
            middleIndex = (endIndex + startIndex) / 2;

            if (element == array[middleIndex]) {
                return middleIndex;
            } else if (element < array[middleIndex]) {
                endIndex = middleIndex;
            } else {
                startIndex = middleIndex;
            }
        }

        if (element == array[startIndex]) {
            return startIndex;
        } else if (element == array[endIndex]) {
            return endIndex;
        }

        return -1;
    }
}
