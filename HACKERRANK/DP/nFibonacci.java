import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      for(int i=0;i<n;i++){
        int num=scn.nextInt();
        
        System.out.println(Fibonacci(num));
      }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static int Fibonacci(int num){
    int dp[]=new int[num+1];
    dp[0]=0;
    dp[1]=1;
    for(int i=2;i<=num;i++){
      int fibN1=dp[i-1];
      int fibN2=dp[i-2];
      dp[i]=fibN1+fibN2;
    }
    
    return dp[num];
    
    
  }
}