package classification.binarySearch.easy;


public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition35 searchInsertPosition35 = new SearchInsertPosition35();
        System.out.println(searchInsertPosition35.searchInsert(new int[] {1, 3, 5, 6}, 8));
    }
}
