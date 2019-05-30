package interview.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            int lastLeft = Integer.MAX_VALUE;
            while (left < right) {
                //去重
                if (nums[left] == lastLeft) {
                    left++;
                    continue;
                }
                if (nums[left] + nums[right] == (0 - nums[i])) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    result.add(tmpList);
                    lastLeft = nums[left];
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < (0 - nums[i])) {
                    lastLeft = nums[left];
                    left++;
                } else {
                    right--;
                }
            }
            set.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[] {3, 0, -2, -1, 1, 2}));
    }
}
