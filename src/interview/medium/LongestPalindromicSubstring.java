package interview.medium;

public class LongestPalindromicSubstring {

    public String longestPalindromeDp(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = 0; j < i; j++) {
                if (j == i - 1 && s.charAt(j) == s.charAt(i)) {
                    dp[j][i] = 1;
                } else if (s.charAt(j) == s.charAt(i) && dp[j + 1][i - 1] == 1) {
                    dp[j][i] = 1;
                }
                if (dp[j][i] == 1 && maxLength < i - j + 1) {
                    maxLength = i - j + 1;
                    left = j;
                    right = i;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindromeDp("abcdbbfcba"));
    }
}
