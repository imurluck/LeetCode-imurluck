package classification.bitoperation.medium;

public class WordLengths318 {

    private int maxLength = 0;

    public int maxProduct(String[] words) {
        dfs(words, 0);
        return maxLength;
    }

    private void dfs(String[] words, int index) {
        if (index == words.length) {
            return;
        }
        String word = words[index];
        for (int i = index + 1; i < words.length; i++) {
            maxLength = Math.max(maxLength, getLength(word, words[i]));
        }
        dfs(words, index + 1);
    }

    private int getLength(String word1, String word2) {
        int tmp1 = 0;
        for (int i = 0; i < word1.length(); i++) {
            tmp1 |= (1 << (word1.charAt(i) - 'a'));
        }
        int tmp2 = 0;
        for (int i = 0; i < word2.length(); i++) {
            tmp2 |= (1 << (word2.charAt(i) - 'a'));
        }
        return (tmp1 & tmp2) != 0 ? 0 : word1.length() * word2.length();
    }

    public static void main(String[] args) {
        WordLengths318 wordLengths318 = new WordLengths318();
        System.out.println(wordLengths318.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
