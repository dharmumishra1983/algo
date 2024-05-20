package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]*
[
  [1, 2, 3, 4,5],
  [5, 6, 7, 8],
  [9,10,11,12]
]

/
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l1 = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int startIndex = 0;
        int colStartIndex = 0;
        List<String> statusList = new ArrayList<>();
        while (row > 0 && col > 0) {
            printMatrix(matrix, row, col, l1, startIndex++, colStartIndex++, statusList);
            row = row - 2;
            col = col - 2;
        }
        return l1;
    }

    private void printMatrix(int[][] matrix, int row, int col, List<Integer> resList, int rowIndex, int colIndex, List<String> statusList) {
        int temp = col;
        if (colIndex > 0) {
            temp = temp + 1;
        }
        // copy first top horizontal row
        for (int i = colIndex; i < temp; i++) {
            check(rowIndex, i, resList, matrix[rowIndex][i], statusList);
        }
        //copy right side vertical row
        for (int i = 1; i < row; i++) {
            check(i, col - 1, resList, matrix[i][col - 1], statusList);
        }
        //copy horizontal bottom row
        for (int i = col - 2; i > colIndex; i--) {
            check(row - 1, i, resList, matrix[row - 1][i], statusList);
        }
        //copy left vertical row
        for (int i = row - 1; i >= 1; i--) {
            //resList.add(matrix[i][0]);
            check(i, 0, resList, matrix[i][0], statusList);
        }
    }

    private void check(int rowIndex, int colIndex, List<Integer> resList, int value, List<String> statusList) {
        if (!statusList.contains("" + rowIndex + "" + colIndex)) {
            resList.add(value);
            statusList.add("" + rowIndex + "" + colIndex);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> res = new SpiralMatrix().spiralOrder(matrix);
        System.out.println(res);
    }
}
