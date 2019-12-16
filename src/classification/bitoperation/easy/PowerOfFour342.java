package classification.bitoperation.easy;

public class PowerOfFour342 {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        while (num > 1) {
            if (num % 4 != 0) {
                return false;
            }
            num >>= 1;
            num >>= 1;
        }
        return true;
    }
}
