class Solution {
    public long countValidSubstrings(String s) {
        long ans = 0;
        int lastA = -1;
        int lastAb = -1;
        int lastAbc = -1;

        int n = s.length();


        for(int i = 0; i < n; i++){

            if(s.charAt(i) == 'a'){
                lastA = i; 
            }
            else if(s.charAt(i) == 'b'){
                if(lastA != -1){
                    lastAb = Math.max(lastAb, lastA);
                }
            }
            else if(s.charAt(i) == 'c'){
                if(lastAb != -1){
                    lastAbc = Math.max(lastAbc, lastAb);
                }
            }

            ans += (i - lastAbc);
        }
        return ans;
    }
}