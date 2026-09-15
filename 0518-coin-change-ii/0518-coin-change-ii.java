// class Solution {

//     public int solve(int i, int[] coins,int s, int k){
//         if (s == k) return 1;
//         if(s>k || i >= coins.length) return 0;

//         int a=solve(i,coins,s+coins[i],k);
//         int b=solve(i+1,coins,s,k);

//         return a + b;
//     }
//     public int change(int amount, int[] coins) {
         
//         return solve(0,coins,0,amount);
//     }
// }



class Solution {
    int[][] dp;

    int fun(int i, int[] nums, int s, int k) {
        if (s == k) return 1;
        if (s > k || i >= nums.length) return 0;

        if (dp[i][s] != -1) return dp[i][s];

        int a = fun(i, nums, s + nums[i], k);
        int b = fun(i + 1, nums, s, k);

        return dp[i][s] = a + b;
    }

    public int change(int k, int[] nums) {
        dp = new int[302][5002];

       
        for (int i = 0; i < dp.length; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return fun(0, nums, 0, k);
    }
}