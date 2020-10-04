package com.yk.training.leetcode.algorithms.rotate_image;

public final class MatrixUtils {

    private MatrixUtils() {
        throw new IllegalStateException("Instance is not allowed.");
    }

    public static void printMatrix(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(String.format("%4d", matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static int[][] buildMatrix(final int n) {
        int current = 1;
        final int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = current++;
            }
        }

        return res;
    }
}
