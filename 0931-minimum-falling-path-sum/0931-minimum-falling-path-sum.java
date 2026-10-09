
class Solution {
    int[][] dp;

    int fun(int x, int y, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return (int) 1e9;
        }

        if (x == n - 1) {
            return grid[x][y];
        }

        if (dp[x][y] != -1000000000) {
            return dp[x][y];
        }
        int d = grid[x][y] + fun(x + 1, y, grid);

        int r = grid[x][y] + fun(x + 1, y + 1, grid);

        int l = grid[x][y] + fun(x + 1, y - 1, grid);

        return dp[x][y] = Math.min(d, Math.min(r, l));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1000000000);
        }

        int ans = (int) 1e9;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, fun(0, j, matrix));
        }

        return ans;
    }
}
