package interview.easy;

public class RemoveDuplicatesFromSortArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int lastNum = nums[0];
        int lastIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                nums[lastIndex] = nums[i];
                lastIndex++;
                lastNum = nums[i];
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortArray  solution = new RemoveDuplicatesFromSortArray();
        System.out.println(solution.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2,
                2, 3, 3, 4}));
    }
}
