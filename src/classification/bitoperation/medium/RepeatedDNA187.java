package classification.bitoperation.medium;

import java.util.*;

public class RepeatedDNA187 {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> all = new HashSet<>();
        Set<String> result = new TreeSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (all.contains(sub)) {
                result.add(sub);
            } else {
                all.add(sub);
            }
        }
        return new ArrayList<>(result);
    }
}
