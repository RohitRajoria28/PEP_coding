import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int hs=scn.nextInt();
        int cr=scn.nextInt();
        int arr[][]=new int[hs][cr];
        for(int i=0;i<hs;i++){
            for(int j=0;j<cr;j++){
                arr[i][j]=scn.nextInt();
            }
        }
        
        System.out.println(PaintHM(arr));

    }
    public static int PaintHM( int [][]arr){
        int hs=arr.length;
        int cr=arr[0].length;
        int dp[][]=new int[hs][cr];
        
        for(int i=0;i<hs;i++){
            for(int j=0;j<cr;j++){
                if(i==0){
                    dp[i][j]=arr[i][j];
                    
                }else{
                    int ans=Integer.MAX_VALUE;
                    
                    for(int k=0;k<cr;k++){
                         if(k!=j){
                            //  check for house-1 Color not includint
                             ans=Math.min(ans,dp[i-1][k]);
                         }
                    }
                    dp[i][j]=arr[i][j]+ans;
                   
                }
            }
        }
        // Minimum cost from last house of Dp
        int as=Integer.MAX_VALUE;
        for(int v=0;v<cr;v++){
            as=Math.min(as,dp[hs-1][v]);
        }
        return as;
        
    }
}