import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int val[]=new int[n];
        for(int i=0;i<n;i++){
            val[i]=scn.nextInt();
        }
        int wts[]=new int[n];
        for(int i=0;i<n;i++){
            wts[i]=scn.nextInt();
        }
        int cap=scn.nextInt();
        System.out.println(ZeroOneKnapSack(val,wts,cap));
        

    }
    public static int ZeroOneKnapSack(int []val,int []wts,int cap){
        int n=val.length;
        int dp[][]=new int[n+1][cap+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=cap;j++){
                int itemV=val[i-1];
                int itemW=wts[i-1];
                if(itemW>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(itemV+dp[i-1][j-itemW],dp[i-1][j]);
                }
            }
        }
        return dp[n][cap];
    }
}