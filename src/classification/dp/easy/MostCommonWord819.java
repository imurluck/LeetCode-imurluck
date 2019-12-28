package classification.dp.easy;

import java.util.*;

public class MostCommonWord819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        String maxCountStr = "";
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                if (str.length() > 0) {
                    if (bannedSet.contains(str.toString())) {

                    } else if (map.containsKey(str.toString())) {
                        int count = map.get(str.toString());
                        ++count;
                        map.put(str.toString(), count);
                        if (count > maxCount) {
                            maxCount = count;
                            maxCountStr = str.toString();
                        }
                    } else {
                        map.put(str.toString(), 1);
                        if (maxCount < 1) {
                            maxCount = 1;
                            maxCountStr = str.toString();
                        }
                    }
                }
                str = new StringBuilder();
                continue;
            }
            if (c >= 'A' && c <= 'Z') {
                c ^= (1 << 5);
            }
            str.append(c);
        }
        return maxCountStr;
    }

    public static void main(String[] args) {
        MostCommonWord819 mostCommonWord819 = new MostCommonWord819();
        System.out.println(mostCommonWord819.mostCommonWord("Bob", new String[] {}));
    }
}
