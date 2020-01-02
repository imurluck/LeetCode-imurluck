package classification.dp.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                String subString = s.substring(j - 1, i);
                if (dp[j - 1] && set.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak139 wordBreak139 = new WordBreak139();
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(wordBreak139.wordBreak("leetcode", list));
    }
}
