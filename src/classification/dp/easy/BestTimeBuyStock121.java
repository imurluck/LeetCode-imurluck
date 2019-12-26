package classification.dp.easy;

public class BestTimeBuyStock121 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        BestTimeBuyStock121 bestTimeBuyStock121 = new BestTimeBuyStock121();
        System.out.println(bestTimeBuyStock121.maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
