class Solution {
    boolean solve(int i, int j, int op, char[][] grid) {

        if (i >= grid.length || j >= grid[0].length)
            return false;

        if (grid[i][j] == '(')
            op++;
        else
            op--;

        if (op < 0)
            return false;

        if (op > grid.length + grid[0].length)
            return false;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return op == 0;

        if (dp[i][j][op] != null)
            return dp[i][j][op];

        boolean down = solve(i + 1, j, op, grid);
        boolean right = solve(i, j + 1, op, grid);

        return dp[i][j][op] = down || right;
    }

    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 == 1) return false;

        dp = new Boolean[m][n][m + n];

        return solve(0, 0, 0, grid);
    }  
}