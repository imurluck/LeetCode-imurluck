package classification.binarySearch.midium;

public class SearchInSortedArray81 {

    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInSortedArray81 searchInSortedArray81 = new SearchInSortedArray81();
        System.out.println(searchInSortedArray81.search(new int[] {1, 1, 3, 1}, 3));
    }
}