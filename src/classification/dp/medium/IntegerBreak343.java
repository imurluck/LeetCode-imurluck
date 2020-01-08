package classification.dp.medium;

public class IntegerBreak343 {

    public int integerBreak(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        if (n >= 1) {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, j * (i - j)));
            }
        }
        return dp[n];
    }
}
