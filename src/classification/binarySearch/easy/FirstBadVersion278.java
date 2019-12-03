package classification.binarySearch.easy;

public class FirstBadVersion278 {

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
