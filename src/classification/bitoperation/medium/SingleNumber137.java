package classification.bitoperation.medium;

public class SingleNumber137 {

    public int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, mask;

        for (int i : nums) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x2;
    }

}
