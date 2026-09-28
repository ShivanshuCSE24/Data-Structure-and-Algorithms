class Solution {
    public int[] productExceptSelf(int[] nums) {

        int temp[] = new int[nums.length];

        int l = 1;

        for(int i = 0; i < nums.length; i++){
            temp[i] = l;
            
            l *= nums[i];
        }
        int r = 1;
        
        for(int i = nums.length-1;i >= 0; i--){
            temp[i] *= r;
            r *= nums[i];
        }
        return temp;
    }

}
