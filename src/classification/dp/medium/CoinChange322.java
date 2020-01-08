package classification.dp.medium;

public class CoinChange322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] > 0 && dp[i - coins[j]] > 0) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                } else if (i - coins[j] == 0) {
                    min = 1;
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? 0 : min;
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange322 coinChange322 = new CoinChange322();
        System.out.println(coinChange322.coinChange(new int[] {1, 2, 5}, 11));
    }
}
