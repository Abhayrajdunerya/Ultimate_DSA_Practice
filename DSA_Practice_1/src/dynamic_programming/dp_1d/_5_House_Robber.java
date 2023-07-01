package dynamic_programming.dp_1d;

import java.util.Arrays;

public class _5_House_Robber {

    // Recursion - 
    public static int maxProfit_recursion(int arr[], int n) {
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];

        for (int i = 0; i < n-1; i++) {
            arr1[i] = arr[i];   
            arr2[i] = arr[i+1];
        }

        int ans1 = maxProfit_recursion_util(arr1, arr1.length-1);
        int ans2 = maxProfit_recursion_util(arr2, arr2.length-1);

        return Math.max(ans1, ans2);
    }

    public static int maxProfit_recursion_util(int arr[], int idx) {
        if (idx == 0) return arr[idx];
        if (idx < 0) return 0;

        int pick = maxProfit_recursion_util(arr, idx-2)+arr[idx];
        int notPick = maxProfit_recursion_util(arr, idx-1);

        return Math.max(pick, notPick);
    }

    // Memoization - O(N), O(N)
    public static int maxProfit_memoization(int arr[], int n) {
        int dp[] = new int[n-1];
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];

        for (int i = 0; i < n-1; i++) {
            arr1[i] = arr[i];
            arr2[i] = arr[i+1];
        }

        Arrays.fill(dp, -1);
        int ans1 = maxProfit_memoization_util(arr1, dp, arr1.length-1);

        Arrays.fill(dp, -1);
        int ans2 = maxProfit_memoization_util(arr2, dp, arr2.length-1);

        return Math.max(ans1, ans2);
    }

    public static int maxProfit_memoization_util(int arr[], int dp[], int idx) {
        if (idx == 0) return arr[0];
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = maxProfit_memoization_util(arr, dp, idx-2) + arr[idx];
        int notPick = maxProfit_memoization_util(arr, dp, idx-1);

        return Math.max(pick, notPick);
    }

    // Tabulation - O(N), O(N)
    public static int maxProfit_tabulation(int arr[], int n) {
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];

        for (int i = 0; i < n-1; i++) {
            arr1[i] = arr[i];
            arr2[i] = arr[i+1];
        }

        int ans1 = maxSum_tabulation_util(arr1, arr1.length);
        int ans2 = maxSum_tabulation_util(arr2, arr2.length);

        return Math.max(ans1, ans2);
    }

    public static int maxSum_tabulation_util(int arr[], int n) {
        int dp[] = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick = arr[i]+dp[i-2];
            }
            int notPick = dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }

    // Space Optimization - O(N)
    public static int maxProfit_spaceOptimization(int arr[], int n) {
        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];

        for (int i = 0; i < n-1; i++) {
            arr1[i] = arr[i];
            arr2[i] = arr[i+1];
        }

        int ans1 = maxSum_spaceOptimization_util(arr1, arr1.length);
        int ans2 = maxSum_spaceOptimization_util(arr2, arr2.length);

        return Math.max(ans1, ans2);
    }

    public static int maxSum_spaceOptimization_util(int arr[], int n) {
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
