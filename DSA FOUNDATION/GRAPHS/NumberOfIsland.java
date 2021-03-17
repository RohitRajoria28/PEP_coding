import java.io.*;
import java.util.*;

public class Main {
    public static int CountIsland(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] == 0 && visited[r][c] == false) {
                    CountIslandhelper(arr, r, c, visited);
                    count++;
                }
            }
        }
        return count;

    }

    public static void CountIslandhelper(int[][] board, int r, int c, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || board[r][c] == 1) {
            // not valid path,found water,already visited
            return;
        }
        visited[r][c] = true;
        CountIslandhelper(board, r - 1, c, visited); // NORTH
        CountIslandhelper(board, r, c + 1, visited); // EAST
        CountIslandhelper(board, r, c - 1, visited); // WEST
        CountIslandhelper(board, r + 1, c, visited);// SOUTH
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        System.out.println(CountIsland(arr));
    }

}