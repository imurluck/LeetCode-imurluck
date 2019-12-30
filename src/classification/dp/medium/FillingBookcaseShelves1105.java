package classification.dp.medium;

public class FillingBookcaseShelves1105 {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];

        for (int i = 1; i <= books.length; i++) {
            int currentHeight = 0;
            int width = 0;
            dp[i] = dp[i - 1] + books[i - 1][1];
            for (int j = i; j > 0; j--) {
                currentHeight = Math.max(currentHeight, books[j - 1][1]);
                width += books[j - 1][0];
                if (width > shelf_width) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j - 1] + currentHeight);
            }
        }
        return dp[books.length];
    }

    public static void main(String[] args) {
        FillingBookcaseShelves1105 fillingBookcaseShelves1105 = new FillingBookcaseShelves1105();
        System.out.println(fillingBookcaseShelves1105.minHeightShelves(new int[][]{
                {1, 1},
                {2, 3},
                {2, 3},
                {1, 1},
                {1, 1},
                {1, 1},
                {1, 2}
        }, 4));
    }
}
