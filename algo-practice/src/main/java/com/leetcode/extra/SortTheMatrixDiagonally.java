package com.leetcode.extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.*/
public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int counter = 0;
        List<Integer> l1 = null;
        int j = 0;
        while (counter < row) {
            j=0;
            l1 = new ArrayList<>();
            for (int i = counter; i < row; i++) {
                l1.add(mat[i][j]);
                j++;
            }
            Collections.sort(l1);
            j = 0;
            for (int i = counter; i < row; i++) {
                mat[i][j] = l1.get(j);
                j++;
            }

            counter++;
        }

        counter = 0;
        int k = 1;
        j = 0;
        while (counter < col - 1) {
            k = counter + 1;
            l1 = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                j = i + k;
                l1.add(mat[i][j]);
            }

            Collections.sort(l1);
            for (int i = 0; i < row; i++) {
                j = i + k;
                mat[i][j] = l1.get(i);
            }
            row = row - 1;
            counter++;
        }
        return mat;
    }

    public void print(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SortTheMatrixDiagonally ob = new SortTheMatrixDiagonally();
        int[][] arr = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        ob.diagonalSort(arr);
        ob.print(arr);


    }
}
