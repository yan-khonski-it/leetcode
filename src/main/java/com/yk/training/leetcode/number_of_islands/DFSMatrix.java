package com.yk.training.leetcode.number_of_islands;

import com.yk.training.leetcode.utils.FileUtils;

import java.util.LinkedList;

/**
 * https://algorithms.tutorialhorizon.com/depth-first-search-dfs-in-2d-matrix-2d-array-iterative-solution/
 * <p>
 * We have matrix of nodes. Where node is some value and visited flag.
 */
public class DFSMatrix {

    public static void main(String[] args) {
        final DFSMatrix dfsMatrix = new DFSMatrix();
        final int[][] numericMatrix = FileUtils.readMatrix("utils/test_matrix.txt");
        final Node[][] nodeMatrix = buildNodeMatrix(numericMatrix);

        long start = System.nanoTime();
        dfsMatrix.visitMatrixNodesDFS(nodeMatrix);
        long end = System.nanoTime();
        float delta = (end - start);
        float total = delta / 1000000;
        System.out.println();
        System.out.println(total);
    }

    private static Node[][] buildNodeMatrix(final int[][] numericMatrix) {
        final int n = numericMatrix.length;
        final int m = numericMatrix[0].length;

        Node[][] nodeMatrix = new Node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nodeMatrix[i][j] = new Node(numericMatrix[i][j]);
            }
        }

        return nodeMatrix;
    }

    public void visitMatrixNodesDFS(final Node[][] matrix) {
        final LinkedList<Point> stack = new LinkedList<>();
        // Add element (0, 0).
        stack.push(new Point(0, 0));
        final int n = matrix.length;
        final int m = matrix[0].length;

        // While not all visited
        while (!stack.isEmpty()) {
            final Point visited = stack.pop();

            if (matrix[visited.x][visited.y].visited) {
                continue;
            }

            // Visit point.
            matrix[visited.x][visited.y].visited = true;
            System.out.print(matrix[visited.x][visited.y] + " ");

            // Add all neighbors.
            // It is faster to make individual checks for each coordinates as it is here then it was in the example.

            // Visit left
            final int yLeft = visited.y - 1;
            if (yLeft >= 0) {
                final int xLeft = visited.x;
                if (!matrix[xLeft][yLeft].visited) {
                    stack.push(new Point(xLeft, yLeft));
                }
            }

            // visit right
            final int yRight = visited.y + 1;
            if (yRight < m) {
                final int xRight = visited.x;
                if (!matrix[xRight][yRight].visited) {
                    stack.push(new Point(xRight, yRight));
                }
            }

            // Visit upper
            final int xUpper = visited.x - 1;
            if (xUpper >= 0) {
                final int yUpper = visited.y;
                if (!matrix[xUpper][yUpper].visited) {
                    stack.push(new Point(xUpper, yUpper));
                }
            }

            // Visit lower
            final int xLower = visited.x + 1;
            if (xLower < n) {
                final int yLower = visited.y;
                if (!matrix[xLower][yLower].visited) {
                    stack.push(new Point(xLower, yLower));
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
    }

    private static class Node {
        int value;
        boolean visited = false;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }
}
