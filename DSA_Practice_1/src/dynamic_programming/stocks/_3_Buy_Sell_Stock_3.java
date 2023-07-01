package dynamic_programming.stocks;

import java.util.Arrays;

public class _3_Buy_Sell_Stock_3 {

    // Recursion - 
    public static int maxProfit_recursion(int prices[], int n, int day, int canBuy, int cap) {
        if (day > n || cap == 0) return 0;
        
        if (canBuy == 1) {
            int notBuy = 0 + maxProfit_recursion(prices, n, day+1, 1, cap);
            int buy = -prices[day-1] + maxProfit_recursion(prices, n, day+1, 0, cap);
            return Math.max(buy, notBuy);
        } else {
            int notSell = 0 + maxProfit_recursion(prices, n, day+1, 0, cap);
            int sell = prices[day-1] + maxProfit_recursion(prices, n, day+1, 1, cap-1);
            return Math.max(sell, notSell);
        }
    }
    
    // Memoization - O(N*2), O(N*2) + O(N)
    public static int maxProfit_memoization(int prices[], int n) {
        int dp[][][] = new int[n+1][2][3];
        
        for (int mat[][] : dp) {
            for (int row[] : mat) {
                Arrays.fill(row, -1);
            }
        }
        
        int cap = 2;
        
        return maxProfit_memoization_util(prices, n, 1, 1, dp, cap);
    }
    
    public static int maxProfit_memoization_util(int prices[], int n, int day, int canBuy, int dp[][][], int cap) {
        if (day > n || cap == 0) return 0;
        if (dp[day][canBuy][cap] != -1) return dp[day][canBuy][cap];
        
        if (canBuy == 1) {
            int notBuy = 0 + maxProfit_memoization_util(prices, n, day+1, 1, dp, cap);
            int buy = -prices[day-1] + maxProfit_memoization_util(prices, n, day+1, 0, dp, cap);
            return dp[day][canBuy][cap] = Math.max(buy, notBuy);
        } else {
            int notSell = 0 + maxProfit_memoization_util(prices, n, day+1, 0, dp, cap);
            int sell = prices[day-1] + maxProfit_memoization_util(prices, n, day+1, 1, dp, cap-1);
            return dp[day][canBuy][cap] = Math.max(sell, notSell);
        }
    }
    
    // Tabulation - O(N*2), O(N*2)
    public static int maxProfit_tabulation(int prices[], int n) {
        int dp[][][] = new int[n+1][2][3];
        
        
        for (int day = n-1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (canBuy == 1) {
                        int notBuy = 0 + dp[day+1][1][cap];
                        int buy = -prices[day] + dp[day+1][0][cap];
                        dp[day][canBuy][cap] = Math.max(buy, notBuy);
                    } else {
                        int notSell = 0 + dp[day+1][0][cap];
                        int sell = prices[day] + dp[day+1][1][cap-1];
                        dp[day][canBuy][cap] = Math.max(sell, notSell);
                    }
                }
                
            }
        }
        
        return dp[0][1][2];
    }
    
    // Space Optimization - O(N*2), O(1)
    public static int maxProfit_spaceOptimization(int prices[], int n) {
        int ahead[][] = new int[2][3];
        
        
        for (int day = n-1; day >= 0; day--) {
            int curr[][] = new int[2][3];
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (canBuy == 1) {
                        int notBuy = 0 + ahead[1][cap];
                        int buy = -prices[day] + ahead[0][cap];
                        curr[canBuy][cap] = Math.max(buy, notBuy);
                    } else {
                        int notSell = 0 + ahead[0][cap];
                        int sell = prices[day] + ahead[1][cap-1];
                        curr[canBuy][cap] = Math.max(sell, notSell);
                    }
                }
            }
            
            ahead = curr;
        }
        
        return ahead[1][2];
    }
    
    
    public static int maxProfit(int n, int[] price) {
        // code here
        // return maxProfit_recursion(price, n, 1, 1, 2);
        // return maxProfit_memoization(price, n);
        // return maxProfit_tabulation(price, n);
        return maxProfit_spaceOptimization(price, n);
    }
    public static void main(String[] args) {
        
    }
}
