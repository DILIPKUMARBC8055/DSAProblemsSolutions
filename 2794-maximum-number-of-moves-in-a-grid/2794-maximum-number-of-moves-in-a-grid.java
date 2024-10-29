class Solution {
    int max = 0;

    public int maxMoves(int[][] grid) {
        max = 0;
        int[][] visits = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            helper(grid, visits, row, 0, Integer.MIN_VALUE);
        }

        return max - 1;
    }

    private int helper(int[][] grid, int[][] visits, int row, int col, int prevElement) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] <= prevElement) {
            return 0;
        }
        if (visits[row][col] != 0) {
            return visits[row][col];
        }

        int dir1 = helper(grid, visits, row - 1, col + 1, grid[row][col]);
        int dir2 = helper(grid, visits, row, col + 1, grid[row][col]);
        int dir3 = helper(grid, visits, row + 1, col + 1, grid[row][col]);
        visits[row][col] = 1 + Math.max(dir1, Math.max(dir2, dir3));
        max = Math.max(max, visits[row][col]);
        return visits[row][col];
    }
}
