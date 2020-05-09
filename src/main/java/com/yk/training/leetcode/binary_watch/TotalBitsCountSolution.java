package com.yk.training.leetcode.binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * This solution counts bits of hours and minutes and compares them with total leds number.
 */
public class TotalBitsCountSolution {

    private static final String[] minutesFormatted = initFormattedMinutes();
    private static final String[] hoursFormatted = initFormattedHours();

    public static void main(String[] args) {

        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            final List<String> possibleWatch = totalBitsCountSolution(i);
        }
        long end = System.nanoTime();
        System.out.println(((float) (end - start)) / 1000000);

    }

    /**
     * https://leetcode.com/problems/binary-watch/discuss/589892/java-solution
     */
    private static List<String> totalBitsCountSolution(final int nLeds) {
        if (nLeds == 0) {
            return List.of("0:00");
        }

        if (nLeds >= 10 || nLeds < 1) {
            return List.of();
        }

        final List<String> res = new ArrayList<>(191);
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == nLeds) {
                    // Same as System.out.println(String.format("%d:%02d", h, m));, but faster.
                    res.add(hoursFormatted[h] + minutesFormatted[m]);
                }
            }
        }

        return res;
    }

    private static String[] initFormattedHours() {
        final String[] hoursFormatted = new String[12];
        for (int i = 0; i < 12; i++) {
            hoursFormatted[i] = i + ":";
        }

        return hoursFormatted;
    }

    private static String[] initFormattedMinutes() {
        final String[] minutesFormatted = new String[60];
        for (int i = 0; i < 10; i++) {
            minutesFormatted[i] = "0" + i;
        }

        for (int i = 10; i < 60; i++) {
            minutesFormatted[i] = i + "";
        }

        return minutesFormatted;
    }
}
