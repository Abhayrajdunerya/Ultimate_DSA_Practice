package dynamic_programming.dp_strings;

public class _3_Longest_Common_Substring {

    // Tabulation - O(N*M), O(N*M)
    public static int lcs_tabulation(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(dp[i][j], ans);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return ans;
    }
    
    // Space Optimization - O(N*M), O(M)
    public static int lcs_spaceOptimization(String s1, String s2, int n, int m) {
        int prev[] = new int[m+1];
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int curr[] = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = prev[j-1]+1;
                    ans = Math.max(ans, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            
            prev = curr;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
