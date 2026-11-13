class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer  n = null;

        for (int num : nums) {
            if (count == 0) {
                n = num;
            }
            if (num == n) {
                count++;
            } else {
                count--;
            }
        }
        return n;
    }
}
