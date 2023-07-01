package dynamic_programming.dp_subsequences;

import java.util.Arrays;

public class _10_Unbounded_Knapsack {

    // Recursion -
    public static int maxProfit_recursion(int wt[], int val[], int n, int W) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] <= W) {
            int take = val[n - 1] + maxProfit_recursion(wt, val, n, W - wt[n - 1]);
            int notTake = 0 + maxProfit_recursion(wt, val, n - 1, W);

            return Math.max(take, notTake);
        } else {
            return maxProfit_recursion(wt, val, n - 1, W);
        }

    }

    // Memoization - O(N*W), O(N*W) + O(N)
    public static int maxProfit_memoization(int wt[], int val[], int n, int W) {
        int dp[][] = new int[n + 1][W + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return maxProfit_memoization_util(wt, val, n, W, dp);
    }

    public static int maxProfit_memoization_util(int wt[], int val[], int n, int W, int dp[][]) {
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] <= W) {
            int take = val[n - 1] + maxProfit_memoization_util(wt, val, n, W - wt[n - 1], dp);
            int notTake = 0 + maxProfit_memoization_util(wt, val, n - 1, W, dp);

            return dp[n][W] = Math.max(take, notTake);
        } else {
            return dp[n][W] = maxProfit_memoization_util(wt, val, n - 1, W, dp);
        }

    }

    // Tabulation - O(N*W), O(N*W)
    public static int maxProfit_tabulation(int wt[], int val[], int n, int W) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    int take = val[i - 1] + dp[i][j - wt[i - 1]];
                    int notTake = 0 + dp[i - 1][j];
                    dp[i][j] = Math.max(take, notTake);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    // Space Optimization - O(N*W), O(2*W)
    public static int maxProfit_spaceOptimization(int wt[], int val[], int n, int W) {
        int prev[] = new int[W + 1];

        for (int i = 1; i <= n; i++) {
            int curr[] = new int[W+1];
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    int take = val[i-1] + curr[j - wt[i - 1]];
                    int notTake = 0 + prev[j];
                    curr[j] = Math.max(take, notTake);
                } else {
                    curr[j] = prev[j];
                }
            }

            prev = curr;
        }

        return prev[W];
    }
    public static void main(String[] args) {
        
    }
}
