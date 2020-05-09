package com.yk.training.leetcode.utils;

import java.util.List;

public class MatrixUtils {

    public static void printMatrix(final int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(String.format("%3d", element) + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(final char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                if (element == '0') {
                    System.out.print("0 ");
                } else {
                    System.out.print(Character.forDigit(element, 10));
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    public static int[][] buildMatrix(final List<String> lines) {
        final int n = lines.size();
        final int m = lines.get(0).split(" ").length;
        final int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            final String[] lineI = lines.get(i).split(" ");
            for (int j = 0; j < m; j++) {
                res[i][j] = Integer.parseInt(lineI[j]);
            }
        }

        return res;
    }

    /**
     * Util method which I used to test BFS performance.
     */
    public static int[][] zeroMatrix(final int n, final int m) {
        return new int[n][m];
    }
}

