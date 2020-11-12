import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        
        System.out.println(CountABC(str));

    }
    public static  int CountABC(String str ){
        int dp[][]=new int[3][str.length()];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(i==0){
                if(ch=='a') dp[0][0]=1;
            }else{
                // copy all the values of block from  colume-1 block
                dp[0][i]=dp[0][i-1];
                dp[1][i]=dp[1][i-1];
                dp[2][i]=dp[2][i-1];
                // check for  A B C 
                
                // check for a
                if(ch=='a') dp[0][i]=(2*dp[0][i])+1;
                 // check for b
                else if(ch=='b') dp[1][i]=(2*dp[1][i])+dp[0][i];
                 // check for c
                else if(ch=='c') dp[2][i]=(2*dp[2][i])+dp[1][i];
            }
        }
        
        return dp[2][str.length()-1];
    }
}