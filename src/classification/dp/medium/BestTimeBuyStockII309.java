package classification.dp.medium;

public class BestTimeBuyStockII309 {

    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < prices.length; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        BestTimeBuyStockII309 bestTimeBuyStockII309 = new BestTimeBuyStockII309();
        System.out.println(bestTimeBuyStockII309.maxProfit(new int[] {
                1, 2, 3, 0, 2
        }));
    }
}
