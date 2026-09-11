import java.util.*;

class Solution {

    int[][] dp;

    public int fun(int i, int previous, int max, int[] arr, int k) {

        if (i == arr.length) {
            return max * (i - previous);
        }

        int len = i - previous + 1;


        if (len > k) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][previous] != -1) {
            return dp[i][previous];
        }

        int newMax = Math.max(max, arr[i]);

        int take = fun(i + 1, previous, newMax, arr, k);

    
        int currentSum = newMax * len;

        int next = 0;

        if (i + 1 < arr.length) {
            next = fun(i + 1, i + 1, arr[i + 1], arr, k);
        }

        int end = currentSum + next;

        return dp[i][previous] = Math.max(take, end);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;

        dp = new int[n][n];

        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }

        return fun(0, 0, arr[0], arr, k);
    }
}