package classification.binarySearch.easy;

public class TwoSumInSortedArray167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                --right;
            } else {
                ++left;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSumInSortedArray167 sum = new TwoSumInSortedArray167();
        System.out.println(sum.twoSum(new int[] {-1, 0}, -1));
    }
}
