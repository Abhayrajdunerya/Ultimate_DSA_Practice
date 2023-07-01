package dynamic_programming.dp_subsequences;

public class _7_Min_Coins {

    // Recursion - 
    public static int minCoins(int coins[], int n, int amount) {
        if (n == 0 || amount == 0)
            return 0;

        if (coins[n-1] <= amount) {
            int take = minCoins(coins, n-1, amount - coins[n - 1]) + 1;
            int notTake = minCoins(coins, n - 1, amount) + 0;

            return Math.min(take, notTake);
        } else {
            return minCoins(coins, n - 1, amount);
        }
    }
    public static void main(String[] args) {
        
    }
}
