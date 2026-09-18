class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[j] == nums[i]){
                    nums[j] = 101;
                    
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] == 101){
                count++;
             }
        }
        Arrays.sort(nums);
        return nums.length - count;
    }
}
