package classification.binarySearch.easy;

public class MagicIndexLCCI {

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {0, 2, 2, 4, 5};
        System.out.println(new MagicIndexLCCI().findMagicIndex(array));
    }
}
