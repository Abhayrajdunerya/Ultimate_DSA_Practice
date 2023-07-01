package dynamic_programming.stocks;

public class _1_Buy_Sell_Stock_1 {

    // O(N)
    public static int maxProfit(int days[], int n) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (buyPrice < days[i]) {   // profit
                int todayProfit = days[i]-buyPrice;
                maxProfit = Math.max(todayProfit, maxProfit);
            } else {
                buyPrice = days[i];
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        
    }
}
