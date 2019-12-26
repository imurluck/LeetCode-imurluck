package classification.bitoperation.medium;

public class ANDOfNumbersRange201 {

    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n &= (n - 1);
        }
        return n;
    }
}
