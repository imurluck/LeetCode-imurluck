package classification.dp.medium;

import classification.dp.easy.MaximumSubarray53;

public class MaxProduceSubarray152 {

    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(iMax * nums[i - 1], nums[i - 1]);
            iMin = Math.min(iMin * nums[i - 1], nums[i - 1]);
            dp[i] = Math.max(dp[i - 1], iMax);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        MaxProduceSubarray152 maxProduceSubarray152 = new MaxProduceSubarray152();
        System.out.println(maxProduceSubarray152.maxProduct(new int[] {2, 3, -2, 4}));
    }
}
