package classification.dp.easy;

public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int start = 0;
        int tmpSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tmpSum += nums[i];
            sum = Math.max(sum, tmpSum);
            if (tmpSum < 0) {
                start = i;
                tmpSum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumSubarray53 maximumSubarray53 = new MaximumSubarray53();
        System.out.println(maximumSubarray53.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
