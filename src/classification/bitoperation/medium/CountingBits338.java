package classification.bitoperation.medium;

public class CountingBits338 {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num) {
            while (i < b && i + b <= num) {
                result[i + b] = result[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits338 countingBits338 = new CountingBits338();
        System.out.println(countingBits338.countBits(4));
    }
}
