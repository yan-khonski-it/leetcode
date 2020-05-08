package com.yk.leetcode.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.yk.leetcode.utils.MatrixUtils.buildMatrix;

public class FileUtils {

    /**
     * Reads resource file content and builds integer matrix of size {@code n * m};
     * where {@code n} is number of lines, {@code m} - number of elements in the first line.
     * <p>
     * Note, it does not read files in test directory of src.
     */
    public static int[][] readMatrix(final String filename) {
        final List<String> lines = readFileContentAsLines(filename);
        return buildMatrix(lines);
    }

    public static List<String> readFileContentAsLines(final String filename) {
        final InputStream is = getResourceInputStream(filename);
        return readLines(is);

    }

    private static List<String> readLines(final InputStream is) {
        final List<String> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = br.readLine();
            while (line != null) {
                res.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input stream:", e);
        }

        return res;
    }

    private static InputStream getResourceInputStream(final String filename) {
        final ClassLoader classLoader = FileUtils.class.getClassLoader();
        return classLoader.getResourceAsStream(filename);
    }
}
