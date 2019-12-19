package classification.bitoperation.easy;

public class DecimalToHex405 {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String template = "0123456789abcdef";
        String res = "";
        while (num != 0) {
            res = template.charAt(num & 0xF) + res;
            num >>>= 4;
        }
        return res;
    }

    public static void main(String[] args) {
        DecimalToHex405 decimalToHex405 = new DecimalToHex405();
        System.out.println(decimalToHex405.toHex(-1));
    }
}
