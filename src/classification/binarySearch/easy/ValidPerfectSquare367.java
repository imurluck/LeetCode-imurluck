package classification.binarySearch.easy;

public class ValidPerfectSquare367 {

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num / 2 + 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int divide = num / mid;
            if (divide == mid && num % mid == 0) {
                return true;
            } else if (divide > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare367 validPerfectSquare367 = new ValidPerfectSquare367();
        System.out.println(validPerfectSquare367.isPerfectSquare(5));
    }
}
