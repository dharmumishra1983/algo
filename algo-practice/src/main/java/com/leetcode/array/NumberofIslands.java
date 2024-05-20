package com.leetcode.array;

/**
 * AN:200
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int res = 0;

        if (grid == null || grid.length == 0)
            return res;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return;

        if (grid[r][c] == '0')
            return;

        grid[r][c] = '0'; // mark as visited

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : directions) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            dfs(grid, nextR, nextC);
        }

    }
}
