class Solution {
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 == 1) return false;

        dp = new Boolean[m][n][m + n];

        return solve(0, 0, 0, grid);
    }

    boolean solve(int i, int j, int a, char[][] grid) {

        if (i >= grid.length || j >= grid[0].length)
            return false;

        if (grid[i][j] == '(')
            a++;
        else
            a--;

        if (a < 0)
            return false;

        if (a > grid.length + grid[0].length)
            return false;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return a == 0;

        if (dp[i][j][a] != null)
            return dp[i][j][a];

        boolean down = solve(i + 1, j, a, grid);
        boolean right = solve(i, j + 1, a, grid);

        return dp[i][j][a] = down || right;
    }
}