package classification.binarySearch.midium;

public class SearchRange34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                left = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return new int[] {-1, -1};
        }
        int leftIndex = left;
        int rightIndex = left;
        while (leftIndex > 0 && nums[leftIndex - 1] == target) {
            leftIndex--;
        }
        while (rightIndex < nums.length - 1 && nums[rightIndex + 1] == target) {
            rightIndex++;
        }
        return new int[] {leftIndex, rightIndex};
    }

    public static void main(String[] args) {
        SearchRange34 searchRange34 = new SearchRange34();
        System.out.println(searchRange34.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
    }
}
