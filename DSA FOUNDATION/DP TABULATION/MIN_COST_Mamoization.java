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

        System.out.println(MinCost(0, 0, n - 1, m - 1,mat, new int[n][m]));
        // write your code here
    }
    public static int MinCost(int sr, int sc, int dr, int dc,int mat[][], int qb[][]) {
        if(sr>dr || sc>dc){
            return Integer.MAX_VALUE;
        }
        if(sr==dr && sc==dc){
            return mat[sr][sc];
        }
        // check 
        if(qb[sr][sc]!=0){
            return qb[sr][sc];
        }
        
        
        int steph=MinCost(sr,sc+1,dr,dc,mat,qb);
        int stepV=MinCost(sr+1,sc,dr,dc,mat,qb);
        
        int ans=Math.min(steph,stepV)+mat[sr][sc];
        // save
        qb[sr][sc]=ans;
        return ans;
    }

}