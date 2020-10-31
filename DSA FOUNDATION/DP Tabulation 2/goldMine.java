import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int nr=scn.nextInt();
        int nc=scn.nextInt();
        
        int gold[][]=new int[nr][nc];
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                gold[i][j]=scn.nextInt();
            }
        }
        System.out.println(goldMine(gold));
        // write your code here
    }
    public static int goldMine(int [][]gold){
        int nr=gold.length, nc=gold[0].length;
        
        int dp[][]=new int[nr][nc];
        
        for(int col=nc-1;col>=0;col--){
            for(int row=0;row<nr;row++){
                if(col==nc-1){
                    dp[row][col]=gold[row][col];
                    continue;
                }
                
                int max=Integer.MIN_VALUE;
                
                if(row-1>=0) max=Math.max(max,dp[row-1][col+1]);
                max=Math.max(max,dp[row][col+1]);
                if(row+1<nr) max=Math.max(max,dp[row+1][col+1]);
                
                dp[row][col]=max+gold[row][col];
                
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int r=0;r<nr;r++){
            ans=Math.max(ans,dp[r][0]);
        }
        return ans;
        
        
        
    }

}