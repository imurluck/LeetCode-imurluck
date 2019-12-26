package classification.bitoperation.medium;

public class SingleNumberIII260 {

    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int lowBit = tmp & -tmp;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & lowBit) == lowBit) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }

    public static void main(String[] args) {
        SingleNumberIII260 singleNumberIII260 = new SingleNumberIII260();
        System.out.println(singleNumberIII260.singleNumber(new int[] {1, 2, 1, 3, 2, 5}));
    }
}
