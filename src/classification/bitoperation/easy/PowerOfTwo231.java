package classification.bitoperation.easy;

public class PowerOfTwo231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
