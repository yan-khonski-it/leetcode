package com.yk.training.leetcode.algorithms.divide_two_integers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            if (dividend > 0) {
                return Integer.MAX_VALUE;
            } else if (dividend < 0) {
                return Integer.MIN_VALUE;
            } else {
                return 1;
            }
        }

        if (dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        long copyDividend = dividend;
        long copyDivisor = divisor;

        int sign = 1;
        if (copyDividend < 0) {
            copyDividend = -copyDividend;
            sign = -sign;
        }

        if (copyDivisor < 0) {
            copyDivisor = -copyDivisor;
            sign = -sign;
        }

        if (copyDividend == copyDivisor) {
            return sign > 0 ? 1 : -1;
        }

        int result = 0;
        List<Long> divisorMultiplied = new ArrayList<>();
        int index = 0;
        divisorMultiplied.add(copyDivisor);
        long divisorMultipliedValueBy2 = divisorMultiplied.get(index);
        divisorMultipliedValueBy2 = divisorMultipliedValueBy2 + divisorMultipliedValueBy2;


        while (divisorMultipliedValueBy2 <= copyDividend)  {
            divisorMultiplied.add(divisorMultipliedValueBy2);
            divisorMultipliedValueBy2 = divisorMultipliedValueBy2 + divisorMultipliedValueBy2;
            index++;
            if (index > 31) {
                break;
            }
        }

        while (index >= 0) {
            long part = divisorMultiplied.get(index);
            long delta = copyDividend - part;
            if (delta >= 0) {
                copyDividend = delta;
                result = result + (int) Math.pow(2, index);
            }

            index--;
        }

        return sign > 0 ? result : -result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.divide(Integer.MIN_VALUE, -2);
        System.out.println(res);
    }
}