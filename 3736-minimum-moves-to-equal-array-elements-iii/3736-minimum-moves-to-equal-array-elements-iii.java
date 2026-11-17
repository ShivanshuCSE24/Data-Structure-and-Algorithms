class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int i;

        for (i = 0; i < nums.length; i++){
            if(nums[i] >= max){
                max = nums[i];
            }
        }
        for(i = 0;  i < nums.length; i++){
            count = count + (max - nums[i]); 
        }
        return count;
    }
}