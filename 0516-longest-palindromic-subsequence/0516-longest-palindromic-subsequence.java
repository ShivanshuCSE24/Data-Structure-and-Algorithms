class Solution {

    int[][] dp;

    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        String t = new StringBuilder(s).reverse().toString();

        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return func(0, 0, s, t);
    }

    public int func(int i, int j, String s, String t){

        int n = s.length();
        int m = t.length();

        if(i >= n || j >= m)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){

            return dp[i][j] =
                    1 + func(i + 1, j + 1, s, t);
        }

        else{

            int c1 = func(i + 1, j, s, t);
            int c2 = func(i, j + 1, s, t);

            return dp[i][j] = Math.max(c1, c2);
        }
    }
}