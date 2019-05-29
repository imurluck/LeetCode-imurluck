package interview.medium;

public class Atoi {

    public int atio(String str) {
        char startC = '#';
        String realStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c == '-' || c == '+') && i < str.length() - 1) {
                if (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9' && startC == '#') {
                    startC = c;
                    continue;
                } else {
                    break;
                }
            } else if (c >= '0' && c <= '9') {
                if (startC == '#') {
                    startC = c;
                }
                realStr += c;
            } else if (c == ' ') {
                if (startC != '#') {
                    break;
                } else {
                    continue;
                }
            } else {
                break;
            }
        }
        if (realStr.isEmpty()) {
            return 0;
        }
        int result = 0;
        if (startC == '-') {
            result = realAtoi(realStr, false);
        } else if (startC == '+' || (startC >= '0' && startC <= '9')) {
            result = realAtoi(realStr, true);
        }
        return result;
    }

    private int realAtoi(String str, boolean positive) {
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = result * 10 + str.charAt(i) - '0';
            if (result > Integer.MAX_VALUE) {
                if (positive) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        if (positive) {
            return (int) result;
        } else {
            return (0 - (int) result);
        }
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atio("   +0 123"));
    }
}
