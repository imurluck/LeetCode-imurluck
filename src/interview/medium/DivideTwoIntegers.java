package interview.medium;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        boolean positive = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            positive = false;
        }
        long d = dividend > 0 ? dividend : 0 - (long) dividend;
        long s = divisor > 0 ? divisor : 0 - (long) divisor;
        long result = 0;
        while (d >= s) {
            int count = 1;
            long tmpS = s;
            while (d >= tmpS) {
                d -= tmpS;
                result += count;
                if (tmpS < (Integer.MAX_VALUE >> 1)) {
                    tmpS = tmpS << 1;
                    count = count << 1;
                }
            }
        }
        if (result > Integer.MAX_VALUE && positive) {
            return Integer.MAX_VALUE;
        }
        if (positive) {
            return (int) result;
        }
        return -(int) result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        System.out.println(solution.divide(-1010369383, -2147483648));
    }
}
