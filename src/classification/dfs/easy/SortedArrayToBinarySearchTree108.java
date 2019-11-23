package classification.dfs.easy;

import model.TreeNode;

public class SortedArrayToBinarySearchTree108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return binaryInsert(nums, 0, nums.length - 1);
    }

    private TreeNode binaryInsert(int[] nums, int start, int end) {
        int middle = (end + start) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        if (middle > start) {
            node.left = binaryInsert(nums, start, middle - 1);
        }
        if (middle < end) {
            node.right = binaryInsert(nums, middle + 1, end);
        }
        return node;
    }

    public static void main(String[] args) {
        SortedArrayToBinarySearchTree108 searchTree108 = new SortedArrayToBinarySearchTree108();
        int[] array = new int[] {-10,-3,0,5,9};
        System.out.println(searchTree108.sortedArrayToBST(array));
    }

}
