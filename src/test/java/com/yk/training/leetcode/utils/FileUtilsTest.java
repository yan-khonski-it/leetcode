package com.yk.training.leetcode.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileUtilsTest {

    @Test
    public void shouldReadResourceFileLines() {
        String filename = "testFile.txt";
        List<String> actualStrings = FileUtils.readFileContentAsLines(filename);
        assertEquals(List.of("One", "Two"), actualStrings);
    }

    @Test
    public void shouldReadMatrix() {
        int[][] expectedMatrix = {
                {0, 0, 1, 1, 0, 0,},
                {0, 1, 1, 1, 1, 0,},
                {0, 0, 0, 1, 1, 0,},
                {0, 0, 0, 0, 0, 0,}
        };

        String filename = "number_of_islands/world_map.txt";
        int[][] matrix = FileUtils.readMatrix(filename);
        assertTrue(matrixEqual(matrix, expectedMatrix));
    }

    private boolean matrixEqual(int[][] matrix, int[][] expectedMatrix) {
        if (matrix.length != expectedMatrix.length) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (!arrayEquals(matrix[i], expectedMatrix[i])) {
                return false;
            }
        }

        return true;
    }

    private boolean arrayEquals(final int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
}