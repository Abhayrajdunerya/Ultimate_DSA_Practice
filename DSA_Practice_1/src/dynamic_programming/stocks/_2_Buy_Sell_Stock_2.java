package dynamic_programming.stocks;

import java.util.Arrays;

public class _2_Buy_Sell_Stock_2 {

    // Recursion - 
    public static long maxProfit_recursion(long prices[], int n, int day, int canBuy) {
        if (day > n) return 0;
        
        if (canBuy == 1) {
            long notBuy = 0 + maxProfit_recursion(prices, n, day+1, 1);
            long buy = -prices[day-1] + maxProfit_recursion(prices, n, day+1, 0);
            return Math.max(buy, notBuy);
        } else {
            long notSell = 0 + maxProfit_recursion(prices, n, day+1, 0);
            long sell = prices[day-1] + maxProfit_recursion(prices, n, day+1, 1);
            return Math.max(sell, notSell);
        }
    }
    
    // Memoization - O(N*2), O(N*2) + O(N)
    public static long maxProfit_memoization(long prices[], int n) {
        long dp[][] = new long[n+1][2];
        
        for (long row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        return maxProfit_memoization_util(prices, n, 1, 1, dp);
    }
    
    public static long maxProfit_memoization_util(long prices[], int n, int day, int canBuy, long dp[][]) {
        if (day > n) return 0;
        if (dp[day][canBuy] != -1) return dp[day][canBuy];
        
        if (canBuy == 1) {
            long notBuy = 0 + maxProfit_memoization_util(prices, n, day+1, 1, dp);
            long buy = -prices[day-1] + maxProfit_memoization_util(prices, n, day+1, 0, dp);
            return dp[day][canBuy] = Math.max(buy, notBuy);
        } else {
            long notSell = 0 + maxProfit_memoization_util(prices, n, day+1, 0, dp);
            long sell = prices[day-1] + maxProfit_memoization_util(prices, n, day+1, 1, dp);
            return dp[day][canBuy] = Math.max(sell, notSell);
        }
    }
    
    // Tabulation - O(N*2), O(N*2)
    public static long maxProfit_tabulation(long prices[], int n) {
        long dp[][] = new long[n+1][2];
        
        
        dp[n][0] = dp[n][1] = 0;
        
        for (int day = n-1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    long notBuy = 0 + dp[day+1][1];
                    long buy = -prices[day] + dp[day+1][0];
                    dp[day][canBuy] = Math.max(buy, notBuy);
                } else {
                    long notSell = 0 + dp[day+1][0];
                    long sell = prices[day] + dp[day+1][1];
                    dp[day][canBuy] = Math.max(sell, notSell);
                }
            }
        }
        
        return dp[0][1];
    }
    
    // Space Optimization - O(N*2), O(1)
    public static long maxProfit_spaceOptimization(long prices[], int n) {
        long ahead[] = new long[2];
        
        
        ahead[0] = ahead[1] = 0;
        
        for (int day = n-1; day >= 0; day--) {
            long curr[] = new long[2];
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                if (canBuy == 1) {
                    long notBuy = 0 + ahead[1];
                    long buy = -prices[day] + ahead[0];
                    curr[canBuy] = Math.max(buy, notBuy);
                } else {
                    long notSell = 0 + ahead[0];
                    long sell = prices[day] + ahead[1];
                    curr[canBuy] = Math.max(sell, notSell);
                }
            }
            
            ahead = curr;
        }
        
        return ahead[1];
    }
    
    public long maximumProfit(long prices[], int N){
        //Code here
        
        // return maxProfit_recursion(prices, N, 1, 1);
        // return maxProfit_memoization(prices, N);
        // return maxProfit_tabulation(prices, N);
        return maxProfit_spaceOptimization(prices, N);
    }
    public static void main(String[] args) {
        
    }
}
