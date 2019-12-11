package classification.binarySearch.midium;

public class SearchMinInSortedArray153 {

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (mid == nums.length - 1) {
                return nums[0];
            }
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        SearchMinInSortedArray153 searchMinInSortedArray153 = new SearchMinInSortedArray153();
        System.out.println(searchMinInSortedArray153.findMin(new int[] {2, 1}));
    }
}
