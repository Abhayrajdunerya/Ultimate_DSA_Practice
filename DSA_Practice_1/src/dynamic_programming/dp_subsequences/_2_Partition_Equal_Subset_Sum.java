package dynamic_programming.dp_subsequences;

import java.util.Arrays;

public class _2_Partition_Equal_Subset_Sum {

    // Recursion - 
    public static boolean isPartitioned_recursion(int arr[], int n, int target) {
        if (target == 0) return true;
        if (n == 0) return false;

        if (arr[n-1] <= target) {
            boolean take = isPartitioned_recursion(arr, n-1, target-arr[n-1]);
            boolean notTake = isPartitioned_recursion(arr, n-1, target);

            return take || notTake;
        } else {
            return isPartitioned_recursion(arr, n-1, target);
        }
    }

    // Memoization - O(N*M), O(N*M)+O(N)
    public static boolean isPartitioned_memoization(int arr[], int n, int target) {
        int dp[][] = new int[n+1][target+1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return isPartitioned_memoization_util(arr, n, target, dp);
    }

    public static boolean isPartitioned_memoization_util(int arr[], int n, int target, int dp[][]) {
        if (target == 0) return true;
        if (n == 0) return false;

        if (dp[n][target] != -1) return dp[n][target] == 1 ? true : false;

        if (arr[n-1] <= target) {
            boolean take = isPartitioned_memoization_util(arr, n-1, target-arr[n-1], dp);
            boolean notTake = isPartitioned_memoization_util(arr, n-1, target, dp);

            boolean ans = take || notTake;
            dp[n][target] = ans ? 1 : 0;
            return ans;
        } else {
            boolean notTake = isPartitioned_memoization_util(arr, n-1, target, dp);
            dp[n][target] = notTake ? 1 : 0;
            return notTake;
        }
    }

    // Tabulation - O(N*M), O(N*M)
    public static boolean isPartitioned_tabulation(int arr[], int n, int target) {
        boolean dp[][] = new boolean[n+1][target+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        for (int ind = 1; ind <= n; ind++) {
            for (int tg = 1; tg <= target; tg++) {
                if (arr[ind-1] <= tg) {
                    boolean take = dp[ind-1][tg-arr[ind-1]];
                    boolean notTake = dp[ind-1][tg];
                    dp[ind][tg] = take || notTake;
                } else {
                    dp[ind][tg] = dp[ind-1][tg];
                }
            }
        }

        return dp[n][target];
    }


    // Space Optimization - O(N*M), O(M) 
    public static boolean isPartitioned_spaceOptimization(int arr[], int n, int target) {
        boolean prev[] = new boolean[target+1];

        prev[0] = true;
        for (int i = 1; i < target; i++) {
            prev[i] = false;
        }

        for (int ind = 1; ind <= n; ind++) {
            boolean curr[] = new boolean[target+1];
            curr[0] = true;
            for (int tg = 1; tg <= target; tg++) {
                if (arr[ind-1] <= tg) {
                    boolean take = prev[tg-arr[ind-1]];
                    boolean notTake = prev[tg];

                    curr[tg] = take || notTake;
                } else {
                    curr[tg] = prev[tg];
                }
            }

            prev = curr;
        }

        return prev[target];
    }


    public static void main(String[] args) {
        // int arr[] = {1, 5, 11, 5};
        // int N = 4;

        // int sum = 0;
        // for (int i = 0; i < N; i++) {
        //     sum += arr[i];
        // }

        // if (sum % 2 != 0) {
            // return false
        // }

        // int target = sum/2;

        // return isPartitioned_recursion(arr, N);
    }
}
