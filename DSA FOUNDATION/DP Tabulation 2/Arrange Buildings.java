import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    System.out.println(CountBinaryString(n));
    // write your code here
 }
 public static  long CountBinaryString(int n){
      long dp[][]=new  long[2][n+1];
     
     for(int j=1;j<=n;j++){
         for(int i=0;i<=1;i++){
             if(j==1){
                 dp[i][j]=1;
                 continue;
             }
             
             if(i==0){
                 dp[i][j]=dp[i+1][j-1];
             }else{
                 dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
             }
         }
     }
     
     return (dp[1][n]+dp[0][n])*(dp[1][n]+dp[0][n]);
 }

}