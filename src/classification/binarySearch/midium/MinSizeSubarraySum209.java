package classification.binarySearch.midium;

public class MinSizeSubarraySum209 {

    public int minSubArrayLen(int s, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLength = Math.min(minLength, i - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinSizeSubarraySum209 minSizeSubarraySum209 = new MinSizeSubarraySum209();
        System.out.println(minSizeSubarraySum209.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
    }

}
