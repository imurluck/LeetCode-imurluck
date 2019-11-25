package classification.dfs.easy;

public class FloodFill733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int originColor, int newColor) {
        if (originColor == newColor) {
            return;
        }
        image[i][j] = newColor;
        if (j > 0 && image[i][j - 1] == originColor) {
            dfs(image, i, j - 1, originColor, newColor);
        }
        if (i > 0 && image[i - 1][j] == originColor) {
            dfs(image, i - 1, j, originColor, newColor);
        }
        if (j < image[0].length - 1 && image[i][j + 1] == originColor) {
            dfs(image, i, j + 1, originColor, newColor);
        }
        if (i < image.length - 1 && image[i + 1][j] == originColor) {
            dfs(image, i + 1, j, originColor, newColor);
        }
    }

    public static void main(String[] args) {
        FloodFill733 floodFill733 = new FloodFill733();
        int[][] array = new int[][] {
                {0,0,0},{0,1,1}
        };
        System.out.println(floodFill733.floodFill(array, 1, 1, 1));
    }
}
