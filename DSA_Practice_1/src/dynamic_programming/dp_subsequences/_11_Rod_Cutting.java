package dynamic_programming.dp_subsequences;

import java.util.Arrays;

public class _11_Rod_Cutting {

    // Recursion - 
    public static int rodCutting_recursion(int prices[], int length[], int n, int target) {
        if (n == 0) return 0;
        if (target == 0) return 0;
        
        if (length[n-1] <= target) {
            int take = rodCutting_recursion(prices, length, n, target-length[n-1])+prices[n-1];
            int notTake = rodCutting_recursion(prices, length, n-1, target);
            
            return Math.max(take, notTake);
        } else {
            return rodCutting_recursion(prices, length, n-1, target);
        }
    }
    
    // Memoization - O(N^2), O(N^2)+O(N)
    public static int rodCutting_memoization(int prices[], int length[], int n, int target) {
        int dp[][] = new int[n+1][target+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        return rodCutting_memoization_util(prices, length, n, target, dp);
    }
    
    public static int rodCutting_memoization_util(int prices[], int length[], int n, int target, int dp[][]) {
        if (n == 0) return 0;
        if (target == 0) return 0;
        
        if (dp[n][target] != -1) return dp[n][target];
        
        if (length[n-1] <= target) {
            int take = rodCutting_memoization_util(prices, length, n, target-length[n-1], dp)+prices[n-1];
            int notTake = rodCutting_memoization_util(prices, length, n-1, target, dp);
            
            return dp[n][target] = Math.max(take, notTake);
        } else {
            return dp[n][target] = rodCutting_memoization_util(prices, length, n-1, target, dp);
        }
    }
    
    // Tabulation - O(N^2), O(N^2)
    public static int rodCutting_tabulation(int prices[], int length[], int n, int target) {
        int dp[][] = new int[n+1][target+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (length[i-1] <= j) {
                    int take = dp[i][j-length[i-1]]+prices[i-1];
                    int notTake = dp[i-1][j];
                    
                    dp[i][j] = Math.max(take, notTake);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][target];
    }
    
    // Space Optimization - O(N^2), O(2N)
    public static int rodCutting_spaceOptimization(int prices[], int length[], int n, int target) {
        int prev[] = new int[target+1];
        
        for (int i = 1; i <= n; i++) {
            int curr[] = new int[target+1];
            for (int j = 1; j <= target; j++) {
                if (length[i-1] <= j) {
                    int take = curr[j-length[i-1]]+prices[i-1];
                    int notTake = prev[j];
                    
                    curr[j] = Math.max(take, notTake);
                } else {
                    curr[j] = prev[j];
                }
            }
            
            prev = curr;
        }
        
        return prev[target];
    }
    
    public int cutRod(int price[], int n) {
        //code here
        int length[] = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i+1;
        }
        
        return rodCutting_recursion(price, length, n, n);
        // return rodCutting_memoization(price, length, n, n);
        // return rodCutting_tabulation(price, length, n, n);
        // return rodCutting_spaceOptimization(price, length, n, n);
        
    }
    public static void main(String[] args) {
        
    }
}
