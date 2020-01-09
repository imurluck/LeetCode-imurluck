package classification.dp.medium;

public class MinPathSum64 {

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                int min;
                if (i == 1) {
                    min = dp[i][j - 1];
                } else if (j == 1) {
                    min = dp[i - 1][j];
                } else {
                    min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
                dp[i][j] = min + grid[i - 1][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
