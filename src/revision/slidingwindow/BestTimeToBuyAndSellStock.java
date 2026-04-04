package revision.slidingwindow;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {1, 2};
        int result = findMaxProfit(prices);
        System.out.println("Max Profit " + result);
    }

    private static int findMaxProfit(int[] prices) {

        int maxProfit = 0;
        int minSoFar = prices[0];
        for (int price : prices) {
            minSoFar = Math.min(minSoFar, price);
            int profit = price - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}

