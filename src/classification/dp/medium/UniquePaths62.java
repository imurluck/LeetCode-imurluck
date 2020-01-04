package classification.dp.medium;

public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }
}
