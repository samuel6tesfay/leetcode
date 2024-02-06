package leetcode.SlidingWindow;

public class BestTimeBuySellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        BestTimeBuySellStock bestTimeBuySellStock = new BestTimeBuySellStock();
        System.out.println(bestTimeBuySellStock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int left = 0;
        int right = 1;

        int maxPrice = 0;

        while (right<prices.length){
            if (prices[right]>prices[left]){
                maxPrice = Math.max(maxPrice,prices[right]-prices[left]);
            }else {
                left=right;
            }
            right++;
        }

        return maxPrice;
    }
}
