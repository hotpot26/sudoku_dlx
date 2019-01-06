package com.example.sudoku_dlx;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * unit test for the DancingLinksAlgorithm with various puzzles
 *
 */

public class DancingLinksAlgorithmTest {
    private final static HashSet<Integer> UNIQUE_NUMBERS = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    @Test
    public void qlikPuzzleTest() {
        int[][] board = {
                {8, 5, 6, 0, 1, 4, 7, 3, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0},
                {2, 4, 0, 0, 0, 0, 1, 6, 0},
                {0, 6, 2, 0, 5, 9, 3, 0, 0},
                {0, 3, 1, 8, 0, 2, 4, 5, 0},
                {0, 0, 5, 3, 4, 0, 9, 2, 0},
                {0, 2, 4, 0, 0, 0, 0, 7, 3},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 8, 6, 3, 0, 2, 9, 4}
        };

        DancingLinksAlgorithm solver = new DancingLinksAlgorithm();
        int [][] result = solver.solve(board);
        printResult(result);
    }

    @Test
    public void originalDlxPuzzleTest() {
        int[][] board = {
                      {8, 0, 0, 0, 0, 0, 0, 0, 0},
                      {0, 0, 3, 6, 0, 0, 0, 0, 0},
                      {0, 7, 0, 0, 9, 0, 2, 0, 0},
                      {0, 5, 0, 0, 0, 7, 0, 0, 0},
                      {0, 0, 0, 0, 4, 5, 7, 0, 0},
                      {0, 0, 0, 1, 0, 0, 0, 3, 0},
                      {0, 0, 1, 0, 0, 0, 0, 6, 8},
                      {0, 0, 8, 5, 0, 0, 0, 1, 0},
                      {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        DancingLinksAlgorithm solver = new DancingLinksAlgorithm();
        int [][] result = solver.solve(board);
        printResult(result);
    }

    @Test
    public void superhard1Test() {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 0, 0, 2, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 6, 2, 4, 0},
                {0, 3, 8, 0, 0, 7, 1, 0, 0},
                {2, 0, 4, 0, 0, 0, 3, 0, 9},
                {0, 0, 7, 4, 0, 0, 5, 2, 0},
                {0, 7, 2, 5, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 8, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        DancingLinksAlgorithm solver = new DancingLinksAlgorithm();
        int [][] result = solver.solve(board);
        printResult(result);
    }

    private void printResult(int[][] result) {
        int size = result.length;
        for (int[] aResult : result) {
            StringBuilder ret = new StringBuilder();
            for (int j = 0; j < size; j++) {
                ret.append(aResult[j]).append(" ");
            }
            System.out.println(ret);
        }
        System.out.println();
    }

}
