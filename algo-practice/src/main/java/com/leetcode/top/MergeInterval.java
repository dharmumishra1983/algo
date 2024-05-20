package com.leetcode.top;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                Integer.compare(a[0], b[0])
        );

        LinkedList<int[]> merger = new LinkedList<>();
        merger.add(intervals[0]);
        for (int[] interval : intervals) {
            if (merger.getLast()[1] >= interval[0]) {
                merger.getLast()[1] = Math.max(merger.getLast()[1], interval[1]);

            } else {

                merger.add(interval);
            }

        }
        return merger.toArray(new int[merger.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 3}, {1, 5}, {8, 10}, {15, 18}};
        new MergeInterval().merge(arr);

    }
}

