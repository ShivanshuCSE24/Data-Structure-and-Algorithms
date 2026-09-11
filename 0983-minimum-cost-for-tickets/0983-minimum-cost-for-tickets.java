//import java.util.*;
class Solution {

    int[] dp = new int[400];

    public int solve(int i,int[] days, int[] cost){

        if(i >= days.length) return 0;

        int curr = days[i];

        if(dp[i] != -1) return dp[i];

        int one = cost[0] + solve(i+1, days, cost);

        int id2 = days.length;
        int id3 = days.length;

        for(int j = i + 1; j < days.length; j++){
            if(days[j] >= curr +7){
                id2 = j;
                break;
            }
        }
        for(int j = i + 1; j < days.length; j++){
            if(days[j] >= curr +30){
                id3 = j;
                break;
            }
        }

        int seven = cost[1] + solve(id2, days, cost);
        int thirty = cost[2] + solve(id3, days, cost);

        return dp[i] = Math.min(one, Math.min(seven,thirty));

    }
    public int mincostTickets(int[] days, int[] costs) {

        Arrays.fill(dp, -1);
        return solve(0,days,costs);
    }
}