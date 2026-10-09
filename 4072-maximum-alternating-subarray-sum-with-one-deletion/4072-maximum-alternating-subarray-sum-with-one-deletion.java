import java.util.Arrays;

class Solution {
    long[][][][] dp;
    static final long NEG_INF = -100000000000000000L;

    long fun(int i, int[] nums, int s, int sg, int p) {
        if (i >= nums.length) {
            if (s == 0) return NEG_INF;
            return 0;
        }

        long curr = 1L * nums[i] * sg;

        if (dp[i][s][sg + 1][p] != NEG_INF) {
            return dp[i][s][sg + 1][p];
        }

        long m = NEG_INF;

        if (s == 0) {
            long c1 = fun(i + 1, nums, s, sg, p);
            long c2 = curr + fun(i + 1, nums, 1, -sg, p);

            m = Math.max(m, c1);
            m = Math.max(m, c2);
        } else {
            long c1 = curr + fun(i + 1, nums, 1, -sg, p);

            m = Math.max(m, 0L);

            if (p == 1) {
                long c2 = fun(i + 1, nums, s, sg, 0);
                m = Math.max(m, c2);
            }

            m = Math.max(m, c1);
        }

        return dp[i][s][sg + 1][p] = m;
    }

    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length][2][3][2];

        for (long[][][] a : dp) {
            for (long[][] b : a) {
                for (long[] c : b) {
                    Arrays.fill(c, NEG_INF);
                }
            }
        }

        return fun(0, nums, 0, 1, 1);
    }
}