package classification.bfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadder127 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int currentDepth = 1;
        int min = Integer.MAX_VALUE;
        min = doTraversal(beginWord, endWord, wordList, min, currentDepth);
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }

    private static int doTraversal(String beginWord, String endWord, List<String> wordList, int min, int currentDepth) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        for (String str : wordList) {
            if (isMatch(beginWord, str)) {
                if (str.equals(endWord)) {
                    System.out.println("equals " + (currentDepth + 1));
                    return Math.min(min, currentDepth + 1);
                }
                List<String> nextWordList = new ArrayList<>(wordList.size());
                nextWordList.addAll(wordList);
                nextWordList.remove(str);
                min = doTraversal(str, endWord, nextWordList, min, currentDepth + 1);
            }
        }
        return min;
    }

    private static boolean isMatch(String source, String regex) {
        if (source.length() != regex.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(source);
        int matchLetterCount = 0;
        for (int i = 0; i < regex.length(); i++) {
            int index = sb.indexOf(String.valueOf(regex.charAt(i)));
            if (index != -1) {
                sb.deleteCharAt(index);
                matchLetterCount++;

            }
        }
        return matchLetterCount >= regex.length() - 1;
    }

    public static void main(String[] args) {
        String[] strArray = new String[] {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        System.out.println(WordLadder127.ladderLength("qa", "sq", Arrays.asList(strArray)));
    }
}
