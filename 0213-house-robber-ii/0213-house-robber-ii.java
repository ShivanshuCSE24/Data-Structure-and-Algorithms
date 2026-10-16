import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = solve(nums, n - 2, 0, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(nums, n - 1, 1, dp2);

        return Math.max(case1, case2);
    }

    public int solve(int[] nums, int index, int start, int[] dp) {
        if (index < start) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

      
        int take = nums[index] + solve(nums, index - 2, start, dp);


        int notTake = solve(nums, index - 1, start, dp);

        return dp[index] = Math.max(take, notTake);
    }
}