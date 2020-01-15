package classification.dp.medium;

public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[][] dp = new boolean[nums.length][half + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][half];
    }
}
