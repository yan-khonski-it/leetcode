package com.yk.training.leetcode.rotate_image;

import static com.yk.training.leetcode.rotate_image.MatrixUtils.buildMatrix;
import static com.yk.training.leetcode.rotate_image.MatrixUtils.printMatrix;

/**
 * Rotate square matrix by 90 degrees (clockwise).
 * <p>
 * https://leetcode.com/problems/rotate-image/
 */
class Solution {

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final int[][] matrix2 = {{1, 2}, {3, 4}};
        solution.rotate(matrix2);
        printMatrix(matrix2);

        System.out.println();
        final int[][] matrix3 = buildMatrix(3);
        solution.rotate(matrix3);
        printMatrix(matrix3);

        System.out.println();
        final int[][] matrix4 = buildMatrix(4);
        solution.rotate(matrix4);
        printMatrix(matrix4);

        System.out.println();
        final int[][] matrix5 = buildMatrix(5);
        solution.rotate(matrix5);
        printMatrix(matrix5);
    }

    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }

        final int layersCount = matrix.length / 2;
        final int[] row0 = new int[matrix.length]; // common buffer for all layers row[0].

        for (int layer = 0; layer < layersCount; layer++) {
            final int layerSize = matrix.length - layer * 2;
            if (layerSize <= 0) {
                return;
            }

            copyArray(matrix[layer], row0, layer, layerSize);

            final int layerBorder = matrix.length - 1 - layer;

            rotateColumnIntoRowUpper(matrix, layer, layer, layer, layerSize);
            rotateRowIntoColumnLeft(matrix, layerBorder, layer, layer, layerSize);
            rotateColumnIntoRowLower(matrix, layerBorder, layerBorder, layer, layerSize);
            copyArrayIntoColumn(matrix, row0, layerBorder, layer, layerSize);
        }
    }

    private void copyArray(final int[] source, final int[] destination, final int startPosition, final int elementsNumber) {
        for (int i = 0; i < elementsNumber; i++) {
            destination[i] = source[startPosition + i];
        }
    }

    private void copyArrayIntoColumn(final int[][] matrix, final int[] array, final int column, final int start, final int nElements) {
        for (int i = 0; i < nElements; i++) {
            matrix[start + i][column] = array[i];
        }
    }

    private void rotateColumnIntoRowUpper(final int[][] matrix, final int row, final int column, final int start, final int nElements) {
        for (int i = 0; i < nElements; i++) {
            matrix[row][start + nElements - 1 - i] = matrix[start + i][column];
        }
    }

    private void rotateColumnIntoRowLower(final int[][] matrix, final int row, final int column, final int start, final int nElements) {
        for (int i = 0; i < nElements; i++) {
            matrix[row][start + i] = matrix[start + nElements - 1 - i][column];
        }
    }

    private void rotateRowIntoColumnLeft(final int[][] matrix, final int row, final int column, final int start, final int nElements) {
        for (int i = 0; i < nElements; i++) {
            matrix[start + i][column] = matrix[row][start + i];
        }
    }
}