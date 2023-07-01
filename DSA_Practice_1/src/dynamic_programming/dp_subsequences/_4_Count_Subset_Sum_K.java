package dynamic_programming.dp_subsequences;

import java.util.Arrays;

public class _4_Count_Subset_Sum_K {

    // Recursion - 
    public static int countSubset_recursion(int arr[], int n, int target) {
        if (target == 0) return 1;
        if (n == 0) return 0;

        if (arr[n-1] <= target) {
            int take = countSubset_recursion(arr, n-1, target-arr[n-1]);
            int notTake = countSubset_recursion(arr, n-1, target);
            return (take+notTake);
        } else {
            return countSubset_recursion(arr, n-1, target);
        }
        
    }

    // Memoization - O(N*M), O(N*M)+O(N)
    public static int countSubset_memoization(int arr[], int n, int target) {
        int dp[][] = new int[n+1][target+1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return countSubset_memoization_util(arr, n, target, dp);
    }

    public static int countSubset_memoization_util(int arr[], int n, int target, int dp[][]) {
        if (target == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][target] != -1) return dp[n][target];

        if (arr[n-1] <= target) {
            int take = countSubset_memoization_util(arr, n-1, target-arr[n-1], dp);
            int notTake = countSubset_memoization_util(arr, n-1, target, dp);
            return dp[n][target] = take+notTake;
        } else {
            return dp[n][target] = countSubset_memoization_util(arr, n-1, target, dp);
        }
    }


    // Tabulation - O(N*M), O(N*M)
    public static int countSubset_tabulation(int arr[], int n, int target) {
        int dp[][] = new int[n+1][target+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= target; j++) {
            dp[0][j] = 0;
        }

        for (int ind = 1; ind <= n; ind++) {
            for (int tg = 1; tg <= target; tg++) {
                if (arr[ind-1] <= tg) {
                    int take = dp[ind-1][tg-arr[ind-1]];
                    int notTake = dp[ind-1][tg];
                    dp[ind][tg] = take + notTake;
                } else {
                    dp[ind][tg] = dp[ind-1][tg];
                }
            }
        }

        return dp[n][target];
    }


    // Space Optimization - O(N*M), O(N)
    public static int countSubset_spaceOptimized(int arr[], int n, int target) {
        int prev[] = new int[target+1];

        prev[0] = 1;
        for (int i = 1; i < target; i++) {
            prev[i] = 0;
        }

        for (int ind = 1; ind <= n; ind++) {
            int curr[] = new int[target+1];
            curr[0] = 1;
            for (int tg = 1; tg <= target; tg++) {
                if (arr[ind-1] <= tg) {
                    int take = prev[tg-arr[ind-1]];
                    int notTake = prev[tg];

                    curr[tg] = take + notTake;
                } else {
                    curr[tg] = prev[tg];
                }
            }

            prev = curr;
        }

        return prev[target];
    }


    public static void main(String[] args) {
        
        int arr1[] = {1, 0, 1};
        int arr2[] = {1, 1, 0, 0, 0, 0, 1, 1, 1, 1};

        System.out.println(countSubset_spaceOptimized(arr1, arr1.length, 1));
        System.out.println(countSubset_spaceOptimized(arr2, arr2.length, 1));
    }
}
