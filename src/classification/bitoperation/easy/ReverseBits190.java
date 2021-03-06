package classification.bitoperation.easy;

public class ReverseBits190 {

    public int reverseBits(int n) {

        int result = 0;
        int count = 32;
        while (count-- > 0) {
            result = (result << 1) + n % 2;
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits190 reverseBits = new ReverseBits190();
        System.out.println(reverseBits.reverseBits(0b00000010100101000001111010011100));
    }
}
