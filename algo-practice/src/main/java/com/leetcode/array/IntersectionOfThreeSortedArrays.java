package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (!l1.contains(arr1[i])) {
                        l1.add(arr1[i]);
                    }
                }
            }
        }
        for (int i = 0; i < arr3.length; i++) {
            if (l1.contains(arr3[i])) {
                resultList.add(arr3[i]);
            }
        }
        return resultList;

    }

    public static void main(String[] args) {
        System.out.println(new IntersectionOfThreeSortedArrays().arraysIntersection(new int[]{4,6,7,8},new int[]{2,4,6},new int[]{4,6}));
    }
}
