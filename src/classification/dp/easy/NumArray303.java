package classification.dp.easy;

public class NumArray303 {

    private int[] dp;
    private int[] nums;

    public NumArray303(int[] nums) {
        int sum = 0;
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        return dp[j] - dp[i] + nums[i];
    }
}
