package com.yk.training.leetcode.algorithms.binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch
 * <p>
 * https://leetcode.com/problems/binary-watch/discuss/601642/C%2B%2B-straight-solution-with-tables-of-hours-and-minutes
 */
public class CountingHoursAndMinutesLedsSolution {

    // Hours combinations depending on leds number
    private static final int[] hours0 = calculateLedsNumbers(0, 12);
    private static final int[] hours1 = calculateLedsNumbers(1, 12);
    private static final int[] hours2 = calculateLedsNumbers(2, 12);
    private static final int[] hours3 = calculateLedsNumbers(3, 12);
    private static final int[] hours4 = calculateLedsNumbers(4, 12);

    // Minutes combinations depending on leds number
    private static final int[] minutes0 = calculateLedsNumbers(0, 60);
    private static final int[] minutes1 = calculateLedsNumbers(1, 60);
    private static final int[] minutes2 = calculateLedsNumbers(2, 60);
    private static final int[] minutes3 = calculateLedsNumbers(3, 60);
    private static final int[] minutes4 = calculateLedsNumbers(4, 60);
    private static final int[] minutes5 = calculateLedsNumbers(5, 60);
    private static final int[] minutes6 = calculateLedsNumbers(6, 60);

    private static final String[] minutesFormatted = initFormattedMinutes();
    private static final String[] hoursFormatted = initFormattedHours();


    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            final List<String> possibleWatch = readBinaryWatch(i);
        }

        long end = System.nanoTime();
        System.out.println(end - start);
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

    private static int[] calculateLedsNumbers(final int nLeds, int maxNumber) {
        final List<Integer> res = new ArrayList<>();

        for (int m = 0; m < 60; m++) {
            if (Integer.bitCount(m) == nLeds && m < maxNumber) {
                res.add(m);
            }
        }

        final int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }

        return array;
    }

    public static List<String> readBinaryWatch(final int nLeds) {
        if (nLeds < 1) {
            return List.of("0:00");
        }

        if (nLeds >= 10) {
            return List.of();
        }

        final List<String> result = new ArrayList<>(191);
        for (int hoursLeds = 0; hoursLeds < 4; hoursLeds++) {
            int[] possibleHours = getHoursFromLed(hoursLeds);
            for (int minutesLeds = 0; minutesLeds < 6; minutesLeds++) {
                if (hoursLeds + minutesLeds > nLeds) {
                    break;
                }

                if (hoursLeds + minutesLeds == nLeds) {
                    int[] possibleMinutes = getMinutesFromLed(minutesLeds);
                    combineHoursAndMinutes(possibleHours, possibleMinutes, result);
                }
            }
        }

        return result;
    }

    private static void combineHoursAndMinutes(int[] possibleHours, int[] possibleMinutes, List<String> result) {
        for (int possibleHour : possibleHours) {
            for (int possibleMinute : possibleMinutes) {
                result.add(hoursFormatted[possibleHour] + minutesFormatted[possibleMinute]);
            }
        }
    }

    private static int[] getHoursFromLed(final int nLed) {
        switch (nLed) {
            case 0:
                return hours0;
            case 1:
                return hours1;
            case 2:
                return hours2;
            case 3:
                return hours3;
            default:
                return hours4;
        }
    }

    private static int[] getMinutesFromLed(final int nLed) {
        switch (nLed) {
            case 0:
                return minutes0;
            case 1:
                return minutes1;
            case 2:
                return minutes2;
            case 3:
                return minutes3;
            case 4:
                return minutes4;
            case 5:
                return minutes5;
            default:
                return minutes6;
        }
    }
}
