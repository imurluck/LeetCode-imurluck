package classification.dfs.medium;

public class MaxAeraOfIsland695 {

    public int maxAreaOfIsland(int[][] grid) {
        int result =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j) {
        int num = 1;
        grid[i][j] = 0;
        if (j > 0 && grid[i][j - 1] == 1) {
            num += dfs(grid, i, j - 1);
        }
        if (i > 0 && grid[i - 1][j] == 1) {
            num += dfs(grid, i - 1, j);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            num += dfs(grid, i, j + 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            num += dfs(grid, i + 1, j);
        }
        return num;
    }
}
