class Solution {
    public int removeDuplicates(int[] nums) {
        
        int count=0;
         
         for(int i=1;i<nums.length;i++)
         {
            int j=i-1;
            if(nums[j]==nums[i]){
                nums[j]=101;
            } 
         }

         for(int i=0;i<nums.length;i++){
            if(nums[i]==101){
                count++;
            }
            else{
                nums[i-count]=nums[i];
            }
         }
         return nums.length-count;
         
         
    }
}