import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return fun(nums, n - 1, dp);
    }

    public int fun(int[] nums, int n, int[] dp) {
        if (n < 0) return 0;

        if (dp[n] != -1) return dp[n];

        int take = nums[n] + fun(nums, n - 2, dp);

        int notTake = fun(nums, n - 1, dp);

        return dp[n] = Math.max(take, notTake);
    }
}
