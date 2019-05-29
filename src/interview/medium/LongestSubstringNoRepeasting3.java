package interview.medium;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class LongestSubstringNoRepeasting3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> existChars = new HashMap<>();
        int length = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (existChars.containsKey(s.charAt(i))) {
                int index = existChars.get(s.charAt(i));
                left = index + 1;
                Iterator iterator = existChars.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    if ((Integer) entry.getValue() < index) {
                        iterator.remove();
                    }
                }
                existChars.put(s.charAt(i), i);
            } else {
                existChars.put(s.charAt(i), i);
            }
            right = i;
            length = Math.max(right - left + 1, length);
        }
        return length;
    }

    public static void main(String[] args) {
        LongestSubstringNoRepeasting3 solution = new LongestSubstringNoRepeasting3();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
