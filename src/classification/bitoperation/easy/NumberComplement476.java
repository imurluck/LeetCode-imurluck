package classification.bitoperation.easy;

public class NumberComplement476 {


    public int findComplement(int num) {
        int tmp = num;
        int num2 = 1;
        while (tmp > 0) {
            num2 <<= 1;
            tmp >>= 1;
        }
        num2 -= 1;
        return num ^ num2;
    }
}
