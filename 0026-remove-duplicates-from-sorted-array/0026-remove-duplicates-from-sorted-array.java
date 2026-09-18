class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int count = 0;

        for(int i = 1 ; i < n; i++){
            int j = i - 1;

            if(nums[j] == nums[i]){
                nums[j] = 101;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] == 101){
                count++;
             }
             else{
                nums[i - count] = nums[i];
             }
        }
      
        return nums.length - count ;
    }
}