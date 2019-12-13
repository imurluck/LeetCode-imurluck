package classification.bitoperation.easy;

public class MajorElement169 {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int element = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
                continue;
            }
            if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}
