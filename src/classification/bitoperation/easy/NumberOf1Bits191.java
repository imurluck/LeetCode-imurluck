package classification.bitoperation.easy;

public class NumberOf1Bits191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
