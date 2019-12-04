package classification.binarySearch.easy;

import java.util.*;

public class IntersectionTwoArray349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        Iterator<Integer> iterator = resultSet.iterator();
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }
        return result;
    }
}
