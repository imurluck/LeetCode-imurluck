package classification.binarySearch.midium;

public class PeekElement162 {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (mid == nums.length - 1 || mid == 0) {
                break;
            }
            if (nums[mid] > nums[mid + 1]) {
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] < nums[right]) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        PeekElement162 peekElement162 = new PeekElement162();
        System.out.println(peekElement162.findPeakElement(new int[] {3, 4, 3, 2, 1}));
    }
}
