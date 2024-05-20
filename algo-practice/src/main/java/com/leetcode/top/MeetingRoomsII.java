package com.leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(
                end,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        Arrays.sort(
                start,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });


        int startPointer = 0, endPointer = 0;

        int usedRooms = 0;

        while (startPointer < intervals.length) {

            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                endPointer += 1;
            }

            usedRooms += 1;
            startPointer += 1;

        }
        return usedRooms;

    }

    public static void main(String[] args) {
        int arr[][]=new int[][]{{0,30},{5,10},{15,20}};
        new MeetingRoomsII().minMeetingRooms(arr);
    }
}
