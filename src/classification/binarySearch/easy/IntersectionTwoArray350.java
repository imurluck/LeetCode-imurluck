package classification.binarySearch.easy;

import java.util.*;

public class IntersectionTwoArray350 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer count = map1.get(nums1[i]);
            if (count == null) {
                count = 0;
            }
            map1.put(nums1[i], count + 1);
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i])) {
                Integer count = countMap.get(nums2[i]);
                if (count == null) {
                    count = 0;
                }
                Integer map1Count = map1.get(nums2[i]);
                if (map1Count == null) {
                    map1Count = 0;
                }
                if (count < map1Count) {
                    resultList.add(nums2[i]);
                    countMap.put(nums2[i], count + 1);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
