package classification.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length + 1];
        int[] indexs = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        Arrays.fill(indexs, -1);
        List<Integer> result = new ArrayList<>();
        int max = 0, end = -1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] % nums[j - 1] == 0 && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    indexs[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                end = i;
            }
        }
        for (int i = end; i != -1; i = indexs[i]) {
            result.add(nums[i - 1]);
        }
        Collections.reverse(result);
        return result;
    }
}
