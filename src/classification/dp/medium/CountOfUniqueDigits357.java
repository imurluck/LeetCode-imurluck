package classification.dp.medium;

public class CountOfUniqueDigits357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 2;
        }
        if (n > 10) {
            return 0;
        }
        if (n == 1) {
            return 10;
        }
        int[] dp = new int[n + 1];
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            int count = 9;
            for (int j = 1; j <= i && 10 - j > 0; j++) {
                count *= (10 - j);
            }
            dp[i] = count + dp[i - 1];
        }
        return dp[n];
    }
}
