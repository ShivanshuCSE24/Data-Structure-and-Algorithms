class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int a = m - 1; // last index of nums1 without the 0s
        int b = n - 1; // last index of nums2
        int c = m + n - 1; // last index of nums1 , nums1 = [1,2,3, 0, 0, 0]

        while(b >= 0){

            nums1[c--] = (a >= 0 && nums1[a] > nums2[b]) ? nums1[a--] : nums2[b--];
        //     if( a >= 0 && nums1[a] > nums2[b]){
        //         nums1[c--] = nums1[a--];
        //     }
        //     else{
        //         nums1[c--] = nums2[b--];
        //     }
        }
    }
}