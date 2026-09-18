class Solution {
    public long shadowPairs(int[] nums) {

        Stack<int[]> st = new Stack<>();

        long ans = 0;
        long size = 0;

        for (int x : nums) {

            
            while (!st.isEmpty() && st.peek()[0] > x) {
                size -= st.pop()[1];
            }

            ans += size;

            
            if (!st.isEmpty() && st.peek()[0] == x) {
                ans -= st.peek()[1];
                st.peek()[1]++;
            } else {
                st.push(new int[]{x, 1});
            }

            size++;
        }

        return ans;
    }
}