package classification.dp.easy;

public class MinCostClimbingStairs746 {

    public int minCostClimbingStairs(int[] cost) {
        int[][] dp = new int[cost.length + 1][2];
        dp[1][1] = cost[0];
        for (int i = 2; i <= cost.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.min(dp[i - 2][1], Math.min(dp[i - 1][0], dp[i - 1][1])) + cost[i - 1];
        }
        return Math.min(dp[cost.length][0], dp[cost.length][1]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs746 minCostClimbingStairs746 = new MinCostClimbingStairs746();
        System.out.println(minCostClimbingStairs746.minCostClimbingStairs(new int[] {10, 15, 20}));
    }
}
