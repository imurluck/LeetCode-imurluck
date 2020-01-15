package classification.dp.medium;

public class ArithmeticSlices413 {

    public int numberOfArithmeticSlices(int[] A) {
        boolean[][] dp = new boolean[A.length][A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i][i] = false;
            int j = i - 1;
            if (j >= 0) {
                int dest = A[i] - A[j];
                int last = A[j];
                for (--j; j >= 0; j--) {
                    if (i - j < 2) {
                        dp[j][i] = false;
                    } else if (last - A[j] == dest && (i - j == 2 || dp[j + 1][i])) {
                        dp[j][i] = true;
                        count++;
                        last = A[j];
                    } else {
                        dp[j][i] = false;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArithmeticSlices413 arithmeticSlices413 = new ArithmeticSlices413();
        System.out.println(arithmeticSlices413.numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    }
}
