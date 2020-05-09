package com.yk.training.leetcode.number_of_islands;

import java.util.LinkedList;

import static com.yk.training.leetcode.utils.MatrixUtils.printMatrix;

/**
 * {@code matrix[x][y]} is {@code 0} - water.
 * {@code matrix[x][y]} is {@code 1} - land which we have not visited.
 * {@code matrix[x][y]} is {@code 2, 3, ...} - land which we have checked. We do not want to visit it again.
 * <p>
 * See {@link BFSMatrix}.
 */
public class VisitIslandsCharSolution {

    private static final LinkedList<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        final char[][] grid = Holder.create();

        long start = System.nanoTime();
        final int islands = countIslands(grid);
        long end = System.nanoTime();
        float delta = end - start;
        float total = delta / 1000000;
        System.out.println(total);
        System.out.println(islands);

        // World map.
        System.out.println();
        printMatrix(grid);
    }

    private static int countIslands(final char[][] matrix) {
        final int n = matrix.length;
        if (n < 1) {
            return 0;
        }

        final int m = matrix[0].length;
        if (m < 1) {
            return 0;
        }

        char landCounter = '1'; // 0 - water, 1 - unvisited land, 2, 3, ..., N - visited island land.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // water or visited land
                if (matrix[i][j] != '1') {
                    continue;
                }

                landCounter++; // Discover and explore new land.
                boolean unvisitedNeighbors = hasUnvisitedNeighbors(matrix, n, m, i, j);
                if (!unvisitedNeighbors) {
                    matrix[i][j] = '0';
                } else {
                    exploreLand(matrix, n, m, Point.of(i, j));
                }
            }
        }

        return landCounter - '1';
    }

    /**
     * This optimization allows me to pass {@code test_Case1.txt}.
     */
    private static boolean hasUnvisitedNeighbors(char[][] matrix, int n, int m, int i, int j) {
        if (i >= 1) {
            if (matrix[i - 1][j] == '1') {
                return true;
            }
        }

        if (i < n - 1) {
            if (matrix[i + 1][j] == '1') {
                return true;
            }
        }

        if (j >= 1) {
            if (matrix[i][j - 1] == '1') {
                return true;
            }
        }

        if (j < m - 1) {
            return matrix[i][j + 1] == '1';
        }

        return false;
    }

    /**
     * Visit the land using Breadth First search.
     */
    private static void exploreLand(final char[][] matrix,
                                    final int n,
                                    final int m,
                                    final Point coordinates) {

        queue.add(coordinates);

        while (!queue.isEmpty()) {
            final Point visited = queue.remove();
            if (matrix[visited.x][visited.y] != '1') {
                continue;
            }

            // Visit current cell
            matrix[visited.x][visited.y] = '0';

            // Visit neighbors.

            // Left
            final int yLeft = visited.y - 1;
            if (yLeft >= 0) {
                final int xLeft = visited.x;
                if (matrix[xLeft][yLeft] == '1') {
                    queue.add(new Point(xLeft, yLeft));
                }
            }

            // Right
            final int yRight = visited.y + 1;
            if (yRight < m) {
                final int xRight = visited.x;
                if (matrix[xRight][yRight] == '1') {
                    queue.add(new Point(xRight, yRight));
                }
            }

            // Upper
            final int xUpper = visited.x - 1;
            if (xUpper >= 0) {
                final int yUpper = visited.y;
                if (matrix[xUpper][yUpper] == '1') {
                    queue.add(new Point(xUpper, yUpper));
                }
            }

            // Lower
            final int xLower = visited.x + 1;
            if (xLower < n) {
                final int yLower = visited.y;
                if (matrix[xLower][yLower] == '1') {
                    queue.add(new Point(xLower, yLower));
                }
            }
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point of(int x, int y) {
            return new Point(x, y);
        }
    }
}
