import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       int arr[]=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=scn.nextInt();
       }
       
       System.out.println(MaximumAdjSum(arr));
       
    }
    public static int  MaximumAdjSum(int []arr){
        int dp[][]=new int[2][arr.length];
        dp[0][0]=arr[0];
        dp[1][0]=0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    dp[j][i]=arr[i]+dp[j+1][i-1];
                }else{
                    dp[j][i]=Math.max(dp[j-1][i-1],dp[j][i-1]);
                }
            }
        }
        return Math.max(dp[1][arr.length-1],dp[0][arr.length-1]);
    }
}