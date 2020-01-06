package classification.dp.medium;

public class LongestIncreasingSub300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = 1;
        int maxValue = 1;
        for (int i = 1; i <= nums.length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        LongestIncreasingSub300 longestIncreasingSub300 = new LongestIncreasingSub300();
        System.out.println(longestIncreasingSub300.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }
}
