package classification.dp.medium;

public class OutOfBoundaryPaths576 {

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) {
            return 0;
        }
        long[][][] dp = new long[N][m + 2][n + 2];
        long count = 0;
        dp[0][i + 1][j + 1] = 1;
        if (i == 0) {
            count++;
        }
        if (i == m - 1) {
            count++;
        }
        if (j == 0) {
            count++;
        }
        if (j == n - 1) {
            count++;
        }
        for (int c = 1; c < N; c++) {
            for (int mi = 1; mi <= m; mi++) {
                for (int nj = 1; nj <= n; nj++) {
                    dp[c][mi][nj] = dp[c - 1][mi - 1][nj] + dp[c - 1][mi][nj - 1]
                            + dp[c - 1][mi + 1][nj] + dp[c - 1][mi][nj + 1];
                    dp[c][mi][nj] %= 1000000007;
                    if (mi == 1) {
                        count += dp[c][mi][nj];
                    }
                    if (mi == m) {
                        count += dp[c][mi][nj];
                    }
                    if (nj == 1) {
                        count += dp[c][mi][nj];
                    }
                    if (nj == n) {
                        count += dp[c][mi][nj];
                    }
                }
            }
        }
        return (int) (count % 1000000007);
    }
}
