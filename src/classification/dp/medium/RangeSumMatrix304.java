package classification.dp.medium;

public class RangeSumMatrix304 {

    private int[][] dp = new int[0][];

    public RangeSumMatrix304(int[][] matrix) {
        initDp(matrix);
    }

    private void initDp(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - (dp[row1][col2 + 1] + dp[row2 + 1][col1] - dp[row1][col1]);
    }

    public static void main(String[] args) {
        RangeSumMatrix304 rangeSumMatrix304 = new RangeSumMatrix304(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        });
        System.out.println(rangeSumMatrix304.sumRegion(2, 1, 4, 3));
    }
}
