package classification.bfs.medium;

import model.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions130 {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                        bfs(i, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(int i, int j, char[][] board) {
        Queue<Point> pointQueue = new LinkedList<>();
        pointQueue.add(new Point(i, j));
        board[i][j] = '#';
        Point point;
        while ((point = pointQueue.poll()) != null) {
            if (point.j > 0 && board[point.i][point.j - 1] == 'O') {
                board[point.i][point.j - 1] = '#';
                pointQueue.add(new Point(point.i, point.j - 1));
            }
            if (point.i > 0 && board[point.i - 1][point.j] == 'O') {
                board[point.i - 1][point.j] = '#';
                pointQueue.offer(new Point(point.i - 1, point.j));
            }

            if (point.j < board[0].length - 1 && board[point.i][point.j + 1] == 'O') {
                board[point.i][point.j + 1] = '#';
                pointQueue.offer(new Point(point.i, point.j + 1));
            }
            if (point.i < board.length - 1 && board[point.i + 1][point.j] == 'O') {
                board[point.i + 1][point.j] = '#';
                pointQueue.offer(new Point(point.i + 1, point.j));
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = new char[][] {{'O','X','O','O','X','X'},
                {'O','X','X','X','O','X'},
                {'X','O','O','X','O','O'},
                {'X','O','X','X','X','X'},
                {'O','O','X','O','X','X'},
                {'X','X','O','O','O','O'}};
        SurroundedRegions130 s = new SurroundedRegions130();
        s.solve(chars);
        System.out.println(chars);
    }
}
