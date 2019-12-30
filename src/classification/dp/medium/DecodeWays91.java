package classification.dp.medium;

public class DecodeWays91 {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
                    return 0;
                }
                dp[i] = dp[i - 2];
                dp[i - 1] = dp[i - 2];
            } else {
                dp[i] = canCombine(s.charAt(i - 2), s.charAt(i - 1)) ? dp[i - 2] + dp[i - 1] : dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    private boolean canCombine(char c, char c2) {
        return (c == '2' && c2 >= '1' && c2 <= '6') || c == '1';
    }

    public static void main(String[] args) {
        DecodeWays91 decodeWays91 = new DecodeWays91();
        System.out.println(decodeWays91.numDecodings("110"));
    }
}
