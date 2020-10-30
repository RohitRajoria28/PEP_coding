import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int m = scn.nextInt();

        int mat[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                mat[i][j] = scn.nextInt();

            }
        }

        System.out.println(MinCost(0, 0, n - 1, m - 1, mat, new int[n][m]));
        // write your code here
    }
    public static int MinCost(int sr, int sc, int dr, int dc, int mat[][], int qb[][]) {

        for (int row = dr; row >= 0; row--) {
            for (int col = dc; col >= 0; col--) {
                
                if(col==dc && row==dr){
                    qb[row][col]=mat[row][col];
                    continue;
                }
                int steph = Integer.MAX_VALUE;
                int stepv = Integer.MAX_VALUE;
                if (col + 1 <= dc) {
                    steph = qb[row][col + 1];
                }
                if (row + 1 <= dr) {
                    stepv = qb[row + 1][col];
                }





                int ans = Math.min(steph, stepv)+mat[row][col]; 
                qb[row][col] = ans;
            }
        }
        
        
        return qb[sr][sc];

    }

}