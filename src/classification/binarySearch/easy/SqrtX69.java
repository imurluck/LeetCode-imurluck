package classification.binarySearch.easy;

public class SqrtX69 {

    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long multi = mid * mid;
            if (multi == x) {
                return (int) mid;
            } else if (multi < x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        SqrtX69 sqrtX69 = new SqrtX69();
        System.out.println(sqrtX69.mySqrt(2147395599));
    }
}
