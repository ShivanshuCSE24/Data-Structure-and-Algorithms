class Solution {
    public int peakValleyDifference(int[] nums) {
        int dif = 0;
        

        for(int i = 1; i < nums.length-1; i++){
            if(nums[i] > nums[i - 1] && nums[i] > nums[i+1]){
                dif += nums[i];
            } else if(nums[i] < nums[i- 1] && nums[i] < nums[i+1]){
                dif -=  nums[i];
            }
            
        }
        return dif;
    }
}