package classification.dp.medium;

public class HouseRobberII213 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dpNoLast = new int[nums.length][2];
        int[][] dpNoFirst = new int[nums.length][2];
        for (int i = 1; i < nums.length; i++) {
            dpNoLast[i][0] = Math.max(dpNoLast[i - 1][0], dpNoLast[i - 1][1]);
            dpNoLast[i][1] = Math.max(dpNoLast[i - 1][0] + nums[i - 1], dpNoLast[i - 1][1]);
        }
        for (int i = 1; i < nums.length; i++) {
            dpNoFirst[i][0] = Math.max(dpNoFirst[i - 1][0], dpNoFirst[i - 1][1]);
            dpNoFirst[i][1] = Math.max(dpNoFirst[i - 1][0] + nums[i], dpNoFirst[i - 1][1]);
        }
        int maxNoLast = Math.max(dpNoLast[nums.length - 1][0], dpNoLast[nums.length - 1][1]);
        int maxNoFirst = Math.max(dpNoFirst[nums.length - 1][0], dpNoFirst[nums.length - 1][1]);
        return Math.max(maxNoFirst, maxNoLast);

    }

    public static void main(String[] args) {
        HouseRobberII213 houseRobberII213 = new HouseRobberII213();
        System.out.println(houseRobberII213.rob(new int[] {1, 2}));
    }
}
