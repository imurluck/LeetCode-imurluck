package classification.dp.medium;

public class UniquePathsII63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 2; i <= obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i - 1] != 1) {
                dp[1][i] = dp[1][i - 1];
            }
        }
        for (int i = 2; i <= obstacleGrid.length; i++) {
            for (int j = 1; j <= obstacleGrid[0].length; j++) {
                if (obstacleGrid[i - 1][j - 1] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }

    public static void main(String[] args) {
        UniquePathsII63 uniquePathsII63 = new UniquePathsII63();
//        System.out.println(uniquePathsII63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsII63.uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }
}
