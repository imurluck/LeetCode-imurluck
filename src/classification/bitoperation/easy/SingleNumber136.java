package classification.bitoperation.easy;

public class SingleNumber136 {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            number ^= nums[i];
        }
        return number;
    }
}
