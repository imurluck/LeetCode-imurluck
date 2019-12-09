package classification.binarySearch.midium;

public class SearchSortedArray33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchSortedArray33 searchSortedArray33 = new SearchSortedArray33();
        System.out.println(searchSortedArray33.search(new int[] {4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }
}
