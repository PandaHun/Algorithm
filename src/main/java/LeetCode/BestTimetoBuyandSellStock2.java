package LeetCode;

public class BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {
        int price = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (price < prices[i]) {
                profit += prices[i] - price;
            }
            price = prices[i];
        }
        return profit;
    }
}
