package dynamic_programming.dp_subsequences;

import java.util.Arrays;

public class _1_Subset_Sum_Equal_To_Target {

    // Recursion
    public static boolean subsetSum_recursion(int arr[], int n, int target) {
        if (target == 0)
            return true;
        if (n == 0)
            return false;

        if (arr[n - 1] <= target) {
            boolean take = subsetSum_recursion(arr, n - 1, target - arr[n - 1]);
            boolean notTake = subsetSum_recursion(arr, n - 1, target);

            return take || notTake;
        } else {
            return subsetSum_recursion(arr, n - 1, target);
        }
    }

    // Memoization - O(N*M), O(N)
    public static boolean subsetSum_memoization(int arr[], int n, int target) {
        int dp[][] = new int[n + 1][target + 1];
        
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return subsetSum_memoization_util(arr, n, target, dp);
    }

    public static boolean subsetSum_memoization_util(int arr[], int n, int target, int dp[][]) {
        if (target == 0)
            return true;
        if (n == 0)
            return false;

        if (dp[n][target] != -1)
            return dp[n][target] == 1 ? true : false;

        if (arr[n - 1] <= target) {
            boolean take = subsetSum_recursion(arr, n - 1, target - arr[n - 1]);
            boolean notTake = subsetSum_recursion(arr, n - 1, target);

            boolean ans = take || notTake;
            dp[n][target] = ans ? 1 : 0;
            return ans;
        } else {
            boolean ans = subsetSum_recursion(arr, n - 1, target);
            dp[n][target] = ans ? 1 : 0;
            return ans;
        }
    }

    // Tabulation - O(N*M), O(N*M)
    public static boolean subsetSum_tabulation(int arr[], int n, int target) {
        // boolean dp[][] = new boolean[target + 1][n + 1];
        boolean dp[][] = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int tg = 1; tg <= target; tg++) {
                if (arr[i - 1] <= tg) {
                    boolean take = dp[i-1][tg - arr[i-1]];
                    boolean notTake = dp[i-1][tg];
                    dp[i][tg] = take || notTake;
                } else {
                    dp[i][tg] = dp[i-1][tg];
                }
            }
        }

        return dp[n][target];
    }

    // Space Optimization - O(N*M), O(N)
    public static boolean subsetSum_spaceOptimization(int arr[], int n, int target) {
        boolean prev[] = new boolean[target+1];

        prev[0] = true;
        for (int i = 1; i <= target; i++) {
            prev[i] = false;
        }

        for (int ind = 1; ind <= n; ind++) {
            boolean curr[] = new boolean[target+1];
            curr[0] = true;
            for (int tg = 1; tg <= target; tg++) {
                if (arr[ind - 1] <= tg) {
                    boolean take = prev[tg - arr[ind-1]];
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

    }
}
