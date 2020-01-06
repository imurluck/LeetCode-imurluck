package classification.dp.medium;

public class PerfectSquares279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares279 perfectSquares279 = new PerfectSquares279();
        System.out.println(perfectSquares279.numSquares(12));
    }
}
