package classification.dp.easy;

public class TwiceOfOthers747 {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int second = max;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return max >= (2 * second) ? index : -1;
    }
}
