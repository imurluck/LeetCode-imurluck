package classification.binarySearch.easy;

public class GussNumber374 {

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                left = mid + 1;
            } else if (guess(mid) == 1) {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return 1;
    }

}
