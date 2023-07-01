package dynamic_programming.dp_1d;

import java.util.Arrays;

public class _2_FrogJump_2_Steps {

    // Recursion
    public static int minEnergy_recursion(int arr[], int n) {
        if (n == 0) return 0;

        int jump2 = Integer.MAX_VALUE;
        int jump1 = Math.abs(arr[n]-arr[n-1]) + minEnergy_recursion(arr, n-1);
        if (n > 1) jump2 = Math.abs(arr[n]-arr[n-2]) + minEnergy_recursion(arr, n-2);

        return Math.min(jump1, jump2);
    }

    // Memoization - O(N), O(N)
    public static int minEnergy_memoization_util(int arr[], int n, int dp[]) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int jump2 = Integer.MAX_VALUE;
        int jump1 = Math.abs(arr[n]-arr[n-1])+minEnergy_memoization_util(arr, n-1, dp);
        if (n > 1) jump2 = Math.abs(arr[n]-arr[n-2])+minEnergy_memoization_util(arr, n-2, dp);

        return dp[n] = Math.min(jump2, jump1);
    }

    public static int minEnergy_memoization(int arr[], int n) {
        int dp[] = new int[n];

        Arrays.fill(dp, -1);

        return minEnergy_memoization_util(arr, n-1, dp);
    }

    // Tbulation - O(N), O(N)
    public static int minEnergy_Tabulation(int arr[], int n) {
        int dp[] = new int[n+1];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int jump2 = Integer.MAX_VALUE;
            int jump1 = Math.abs(arr[i]-arr[i-1])+dp[i-1];
            if (i > 1) jump2 = Math.abs(arr[i]-arr[i-2])+dp[i-2];
            dp[i] = Math.min(jump2, jump1);
        }

        return dp[n-1];
    }

    // Space Optimization - O(N)
    public static int minEnergy_spaceOptimization(int arr[], int n) {
        int prev = 0;
        int prev2 = Integer.MAX_VALUE;
        int curr;

        for (int i = 1; i < n; i++) {
            int jump2 = Integer.MAX_VALUE;
            int jump1 = (Math.abs(arr[i]-arr[i-1]))+prev;
            if (i > 1) jump2 = (Math.abs(arr[i]-arr[i-2]))+prev2;
            curr = Math.min(jump2, jump1);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        
    }
}
