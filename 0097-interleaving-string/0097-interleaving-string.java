class Solution {

    int[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {

        dp = new int[1001][1001];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, 0, s1, s2, s3) == 1;
    }

    int fun(int i, int j, int k, String s, String t, String str) {

        if (k >= str.length()) {
            return (i >= s.length() && j >= t.length()) ? 1 : 0;
        }

        if (i >= s.length()) {

            while (j < t.length() && k < str.length()) {

                if (t.charAt(j) == str.charAt(k)) {
                    j++;
                    k++;
                } else {
                    return 0;
                }
            }

            return (j >= t.length() && k >= str.length()) ? 1 : 0;
        }

        if (j >= t.length()) {

            while (i < s.length() && k < str.length()) {

                if (s.charAt(i) == str.charAt(k)) {
                    i++;
                    k++;
                } else {
                    return 0;
                }
            }

            return (i >= s.length() && k >= str.length()) ? 1 : 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int m = 0;

        if (s.charAt(i) == str.charAt(k)) {
            int a = fun(i + 1, j, k + 1, s, t, str);
            m = m | a;
        }

        if (t.charAt(j) == str.charAt(k)) {
            int a = fun(i, j + 1, k + 1, s, t, str);
            m = m | a;
        }

        return dp[i][j] = m;
    }
}











// class Solution {
//     Boolean dp[][];
//     public boolean func(int i, int j, String s1, String s2, String s3){
//         if(i==s1.length() && j==s2.length()){
//             return true;
//         }
//         if(dp[i][j]!=null){
//             return dp[i][j];
//         }

//         int k=i+j;
//         if(i<s1.length() && s1.charAt(i)==s3.charAt(k)){
//             if(func(i+1,j,s1,s2,s3)){
//                 return dp[i][j]=true;
//             }
//         }

//         if(j<s2.length() && s2.charAt(j)==s3.charAt(k)){
//             if(func(i,j+1,s1,s2,s3)){
//                 return dp[i][j]= true;
//             }
//         }

//         return dp[i][j]= false;
//     }
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1.length()+s2.length() != s3.length()){
//             return false;
//         }

//         dp= new Boolean[s1.length()+1][s2.length()+1];

//         return func(0,0,s1,s2,s3);
//     }
// }