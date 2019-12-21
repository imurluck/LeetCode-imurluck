package classification.bitoperation.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(result, stack, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, Stack<Integer> stack, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            int value = nums[i];
            stack.push(value);
            result.add(new ArrayList<>(stack));
            dfs(result, stack, nums, i + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        subsets78.subsets(new int[]{1, 2, 3});
    }
}
