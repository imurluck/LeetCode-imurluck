package classification.dp.medium;

public class MaxSquare221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        MaxSquare221 maxSquare221 = new MaxSquare221();
        System.out.println(maxSquare221.maximalSquare(new char[][] {{'0', '1'}}));
    }
}
