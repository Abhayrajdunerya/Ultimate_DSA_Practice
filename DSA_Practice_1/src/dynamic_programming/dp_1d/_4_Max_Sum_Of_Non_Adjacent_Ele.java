package dynamic_programming.dp_1d;

import java.util.Arrays;

public class _4_Max_Sum_Of_Non_Adjacent_Ele {

    // Recursion
    public static int maxSum_recursion(int arr[], int idx) {
        if(idx == 0) return arr[idx];
        if (idx < 0) return 0;

        int pick = maxSum_recursion(arr, idx-2)+arr[idx];
        int notPick = maxSum_recursion(arr, idx-1);

        return Math.max(pick, notPick);
    }

    // Memoization - O(N), O(N)
    public static int maxSum_memoization(int arr[], int n) {
        int dp[] = new int[n];

        Arrays.fill(dp, -1);

        return maxSum_memoization_util(arr, dp, n-1);
    }

    public static int maxSum_memoization_util(int arr[], int dp[], int idx) {
        if (idx == 0) return arr[idx];
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = maxSum_memoization_util(arr, dp, idx-2)+arr[idx];
        int notPick = maxSum_memoization_util(arr, dp, idx-1);

        return dp[idx] = Math.max(pick, notPick);
    }

    // Tabulation - O(N), O(N)
    public static int maxSum_tabulation(int arr[], int n) {
        int dp[] = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick = dp[i-2]+arr[i];
            }
            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    // Space Optimization - O(N)
    public static int maxSum_spaceOptimization(int arr[], int n) {
        int prev2 = 0;
        int prev = arr[0];

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick = arr[i]+prev2;
            }
            int notPick = prev;

            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        
    }
}
