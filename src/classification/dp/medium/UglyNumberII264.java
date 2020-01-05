package classification.dp.medium;

public class UglyNumberII264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[index2] * 2, dp[index3] * 3), dp[index5] * 5);
            while (dp[index2] * 2 <= dp[i]) index2++;
            while (dp[index3] * 3 <= dp[i]) index3++;
            while (dp[index5] * 5 <= dp[i]) index5++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UglyNumberII264 uglyNumberII264 = new UglyNumberII264();
        System.out.println(uglyNumberII264.nthUglyNumber(10));
    }
}
