package dynamic_programming.dp_1d;

import java.util.Arrays;

public class _1_ClimbingStairs {

    // Recursion
    public static int countWays_recursion(int n) {
        if (n == 0 || n == 1) return 1;

        int step1 = countWays_recursion(n-1);
        int step2 = countWays_recursion(n-2);

        return step1+step2;
    }

    // Memoization = O(N), O(N)
    public static int countWays_memoization(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        return countWays_memoization_utils(n, dp);
    }

    public static int countWays_memoization_utils(int n, int dp[]) {
        if (n == 0 || n == 1) return 1;

        if (dp[n] != -1) return dp[n];

        return dp[n] = countWays_memoization_utils(n-1, dp) + countWays_memoization_utils(n-2, dp);
    }

    // Tabulation - O(N), O(N)
    public static int countWays_tabulation(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    // Space Optimization - O(N)
    public static int countWays_spaceOptimization(int n) {
        int prev2 = 1;
        int prev = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev+prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        
    }
}
