class Solution {
    int dp[];

    public int solve(int i, int[] nums){

        if(i == nums.length - 1) return 1;

        if(i >= nums.length) return 0;

        if(dp[i] != -1 ) return dp[i];


        int m = 0;
        

        for(int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++){


            if (solve(j, nums) == 1) {
                m = 1;
            }

            if( m == 1){
                return dp[i] = 1;
            }
            
        }
        return dp[i] = m;

    }
    public boolean canJump(int[] nums) {
        
        dp = new int[nums.length + 1];

        Arrays.fill(dp, -1);

        return solve(0, nums) == 1;
    }
}