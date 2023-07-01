package dynamic_programming.dp_strings;

import java.util.Arrays;

public class _1_Longest_Common_SubSeq {

    // Recursion - 
    public static int lcs_recursion(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) return 0;
        
        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return lcs_recursion(s1, s2, n-1, m-1)+1;
        } else {
            int ans1 = lcs_recursion(s1, s2, n-1, m);
            int ans2 = lcs_recursion(s1, s2, n, m-1);
            
            return Math.max(ans1, ans2);
        }
    }
    
    // Memoization - O(N*M), O(N*M)+O(N)
    public static int lcs_memoization(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];
        
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        return lcs_memoization_util(s1, s2, n, m, dp);
    }
    
    public static int lcs_memoization_util(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        
        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] = lcs_memoization_util(s1, s2, n-1, m-1, dp)+1;
        } else {
            int ans1 = lcs_memoization_util(s1, s2, n-1, m, dp);
            int ans2 = lcs_memoization_util(s1, s2, n, m-1, dp);
            
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }
    
    // Tabulation - O(N*M), O(N*M)
    public static int lcs_tabulation(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        
        return dp[n][m];
    }
    
    // Space Optimization - O(N*M), O(M)
    public static int lcs_spaceOptimization(String s1, String s2, int n, int m) {
        int prev[] = new int[m+1];
        
        for (int i = 1; i <= n; i++) {
            int curr[] = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = prev[j-1]+1;
                } else {
                    int ans1 = prev[j];
                    int ans2 = curr[j-1];
                    curr[j] = Math.max(ans1, ans2);
                }
            }
            
            prev = curr;
        }
        
        return prev[m];
    }
    public static void main(String[] args) {
        
    }
}
