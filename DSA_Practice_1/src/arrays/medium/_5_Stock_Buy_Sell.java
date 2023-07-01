package arrays.medium;

public class _5_Stock_Buy_Sell {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrice < prices[i]) { // profit
                int todayProfit = prices[i]-buyPrice;
                maxProfit = Math.max(maxProfit, todayProfit);
            } else {    // loss
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        
    }
}
