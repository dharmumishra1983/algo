package com.leetcode.extra;

import java.util.Arrays;

/*
Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {

        int row = A.length;
        int col = A[0].length;
        int[][] arr = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[j][i] = A[i][j];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        new TransposeMatrix().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
