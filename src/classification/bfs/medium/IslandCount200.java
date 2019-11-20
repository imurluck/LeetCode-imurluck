package classification.bfs.medium;

import model.Point;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class IslandCount200 {

    private char currentChar = 'a';

    public int numIslands(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid, currentChar++);
                }
            }
        }
        Set<Character> charSet = new TreeSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
                if (grid[i][j] != '0') {
                    charSet.add(grid[i][j]);
                }
            }
            System.out.println();
        }
        return charSet.size();
    }

    private void bfs(int i, int j, char[][] grid, char c) {
        Queue<Point> pointQueue = new LinkedList<>();
        grid[i][j] = c;
        pointQueue.offer(new Point(i, j));
        Point point;
        while ((point = pointQueue.poll()) != null) {
            if (point.j > 0 && grid[point.i][point.j - 1] == '1') {
                grid[point.i][point.j - 1] = c;
                pointQueue.add(new Point(point.i, point.j - 1));
            }
            if (point.i > 0 && grid[point.i - 1][point.j] == '1') {
                grid[point.i - 1][point.j] = c;
                pointQueue.offer(new Point(point.i - 1, point.j));
            }

            if (point.j < grid[0].length - 1 && grid[point.i][point.j + 1] == '1') {
                grid[point.i][point.j + 1] = c;
                pointQueue.offer(new Point(point.i, point.j + 1));
            }
            if (point.i < grid.length - 1 && grid[point.i + 1][point.j] == '1') {
                grid[point.i + 1][point.j] = c;
                pointQueue.offer(new Point(point.i + 1, point.j));
            }
        }
    }

    public static void main(String[] args) {
        IslandCount200 islandCount = new IslandCount200();
        char[][] grid = new char[][] {
                {'0','1','0'}, {'1','0','1'}, {'0','1','0'}
        };
        System.out.println(islandCount.numIslands(grid));
    }

}
