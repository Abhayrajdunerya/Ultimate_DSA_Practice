package dynamic_programming.dp_strings;

import java.util.Arrays;

public class _8_Distinct_SubSeq {

    // Recursion - 
    public static int distinctSubseq_recursion(String s1, String s2, int n, int m) {
        if (m == 0) return 1;
        if (n == 0) return 0;

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            int leaveOne = distinctSubseq_recursion(s1, s2, n-1, m-1);
            int stay = distinctSubseq_recursion(s1, s2, n-1, m);
            return leaveOne + stay;
        } else {
            return distinctSubseq_recursion(s1, s2, n-1, m);
        }
    }

    // Memoization - O(N*M), O(N*M)+O(N)
    public static int distinctSubseq_memoization(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return distinctSubseq_memoization_util(s1, s2, n, m, dp);
    }

    public static int distinctSubseq_memoization_util(String s1, String s2, int n, int m, int dp[][]) {
        if (m == 0) return 1;
        if (n == 0) return 0;

        if (dp[n][m] != -1) return dp[n][m];

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            int leaveOne = distinctSubseq_memoization_util(s1, s2, n-1, m-1, dp);
            int stay = distinctSubseq_memoization_util(s1, s2, n-1, m, dp);
            return dp[n][m] = leaveOne + stay;
        } else {
            return dp[n][m] = distinctSubseq_memoization_util(s1, s2, n-1, m, dp);
        }
    }

    // Tabulation - O(N*M), O(N*M)
    public static int distinctSubseq_tabulation(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    int leaveOne = dp[i-1][j-1];
                    int stay = dp[i-1][j];
                    dp[i][j] = leaveOne + stay;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }

    // Space Optimization - O(N*M), O(M)
    public static int distinctSubseq_spaceOptimization(String s1, String s2, int n, int m) {
        int prev[] = new int[m+1];

        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int curr[] = new int[m+1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    int leaveOne = prev[j-1];
                    int stay = prev[j];
                    curr[j] = leaveOne + stay;
                } else {
                    curr[j] = prev[j];
                }
            }

            prev = curr;
        }

        return prev[m];
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        // return distinctSubseq_recursion(s, t, n, m);
        // return distinctSubseq_memoization(s, t, n, m);
        // return distinctSubseq_tabulation(s, t, n, m);
        return distinctSubseq_spaceOptimization(s, t, n, m);
    }
    public static void main(String[] args) {
        
    }
}
