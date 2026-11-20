class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int len = s.length;

        if(len == 0)  return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int maxNum = 0;
        int cookieIndex = len - 1;
        int childIndex = g.length - 1;

        while(cookieIndex >= 0 && childIndex >=0){
            if(s[cookieIndex] >= g[childIndex]){
                maxNum++;
                cookieIndex--;
                childIndex--;
            }
            else{
                childIndex--;
            }
        }

        return maxNum;
    }
}