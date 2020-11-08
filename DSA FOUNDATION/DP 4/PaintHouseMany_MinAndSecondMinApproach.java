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
        
        int min=Integer.MAX_VALUE;
        int smin=Integer.MAX_VALUE;
        
        for(int c=0;c<cr;c++){
            dp[0][c]=arr[0][c];
            if(dp[0][c]<=min){
                smin=min;
                min=dp[0][c];
            }else if(dp[0][c]<=smin){
                smin=dp[0][c];
            }
        }
        
        for(int i=1;i<hs;i++){
            int least=Integer.MAX_VALUE;
            int sleast=Integer.MAX_VALUE;
            for(int j=0;j<cr;j++){
                if(dp[i-1][j]==min){
                    dp[i][j]=smin+arr[i][j];
                }else{
                    dp[i][j]=min+arr[i][j];
                }
                
                if(dp[i][j]<=least){
                    sleast=least;
                    least=dp[i][j];
                }else if(dp[i][j]<=sleast){
                    sleast=dp[i][j];
                }
                  
            }
            min=least;
            smin=sleast;
        }
        
         
        return  min;
        
    }
}