package classification.dp.medium;

import java.util.HashSet;
import java.util.Set;

public class LargestPlusSign764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        int[][] dp = new int[N][N];
        for (int[] mine : mines) {
            set.add(mine[0] * N + mine[1]);
        }
        for (int r = 0; r < N; r++) {
            int count = 0;
            for (int c = 0; c < N; c++) {
                count = set.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            count = 0;
            for (int c = N - 1; c >= 0; c--) {
                count = set.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        int max = 0;
        for (int c = 0; c < N; c++) {
            int count = 0;
            for (int r = 0; r < N; r++) {
                count = set.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            count = 0;
            for (int r = N - 1; r >= 0; r--) {
                count = set.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                max = Math.max(dp[r][c], max);
            }
        }
        return max;
    }
}
