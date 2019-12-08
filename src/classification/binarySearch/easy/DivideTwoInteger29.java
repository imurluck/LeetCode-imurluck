package classification.binarySearch.easy;

public class DivideTwoInteger29 {

    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);

        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int result = 0;
        while (dividend <= divisor) {
            int tmpResult = -1;
            int tmpDivisor = divisor;
            while (dividend <= (tmpDivisor << 1)) {
                if (tmpDivisor <= Integer.MIN_VALUE >> 1) {
                    break;
                }
                tmpResult <<= 1;
                tmpDivisor <<= 1;
            }
            dividend -= tmpDivisor;
            result += tmpResult;
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        DivideTwoInteger29 divideTwoInteger29 = new DivideTwoInteger29();
        System.out.println(divideTwoInteger29.divide(2147483647, 3));
    }
}
