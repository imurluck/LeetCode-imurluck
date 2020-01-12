package classification.dp.medium;

import java.util.Arrays;

public class CheapestFlights787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K + 2][n + 1];
        for (int i = 0; i <= K + 1; i++) {
            Arrays.fill(dp[i], 100000);
        }
        dp[0][src] = 0;
        for (int i = 1; i <= K + 1; i++) {
            dp[i][src] = 0;
            for (int[] flight : flights) {
                dp[i][flight[1]] = Math.min(dp[i][flight[1]], dp[i - 1][flight[0]] + flight[2]);
            }
        }
        return dp[K + 1][dst] == 100000 ? -1 : dp[K + 1][dst];
    }

    public static void main(String[] args) {
        CheapestFlights787 cheapestFlights787 = new CheapestFlights787();
        System.out.println(cheapestFlights787.findCheapestPrice(3, new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        }, 0, 2, 0));
    }
}
