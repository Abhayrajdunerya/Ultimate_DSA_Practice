package dynamic_programming.dp_lis;

import java.util.Arrays;

public class _1_Longest_Increasing_Subseq {

    // Recursion - 
    public static int lis_recursion(int arr[], int n, int i, int prev) {
        if (i == n) return 0;
        
        int notPick = lis_recursion(arr, n, i+1, prev);
        int pick = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            pick = lis_recursion(arr, n, i+1, i) + 1;
        }
        
        return Math.max(pick, notPick);
        
    }
    
    // Memoization - O(N*N), O(N*N)+O(N)
    public static int lis_memoization(int arr[], int n) {
        int dp[][] = new int[n][n+1];
        
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        return lis_memoization_util(arr, n, 0, -1, dp);
    }
    
    public static int lis_memoization_util(int arr[], int n, int i, int prev, int dp[][]) {
        if (i == n) return 0;
        
        if (dp[i][prev+1] != -1) return dp[i][prev+1];
        
        int notPick = lis_memoization_util(arr, n, i+1, prev, dp);
        int pick = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            pick = lis_memoization_util(arr, n, i+1, i, dp) + 1;
        }
        
        return dp[i][prev+1] = Math.max(pick, notPick);
        
    }
    
    // Tabulation - O(N*N), O(N*N)
    public static int lis_tabulation(int arr[], int n) {
        int dp[][] = new int[n+1][n+1];
        
        for (int ind = n-1; ind >= 0; ind--) {
            for (int prev = ind-1; prev >= -1; prev--) {
                int notPick = dp[ind+1][prev+1];
                int pick = 0;
                if (prev == -1 || arr[ind] > arr[prev]) {
                    pick = dp[ind+1][ind+1] + 1;
                }
                
                dp[ind][prev+1] = Math.max(pick, notPick);
            }
        }
        
        return dp[0][0];
    }
    
    // Space Optimization - O(N*N), O(N)
    public static int lis_spaceOptimization(int arr[], int n) {
        int next[] = new int[n+1];
        
        for (int ind = n-1; ind >= 0; ind--) {
            int curr[] = new int[n+1];
            for (int prev = ind-1; prev >= -1; prev--) {
                int notPick = next[prev+1];
                int pick = 0;
                if (prev == -1 || arr[ind] > arr[prev]) {
                    pick = next[ind+1] + 1;
                }
                
                curr[prev+1] = Math.max(pick, notPick);
            }
            
            next = curr;
        }
        
        return next[0];
    }
    
    // Tabulation Optimized - O(N*N), O(N)
    public static int lis_tabulation_optimized(int arr[], int n) {
        int dp[] = new int[n];
        
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev <= i-1; prev++) {
                if (dp[prev] < dp[i]) {
                    dp[i] = Math.max(dp[i], dp[prev]+1);
                }
            }
        }
        
        int ans = -1;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }

    static int longestSubsequence(int size, int a[])
    {
        // code here
        // return lis_recursion(a, size, 0, -1);
        // return lis_memoization(a, size);
        // return lis_tabulation(a, size);
        return lis_spaceOptimization(a, size);
        
    }

    public static void main(String[] args) {
        
    }
}
