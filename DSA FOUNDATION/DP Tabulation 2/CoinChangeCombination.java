import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int coin[]=new int[n];
        for(int i=0;i<n;i++){
            coin[i]=scn.nextInt();
        }
        int tar=scn.nextInt();
        System.out.println(CoinChangeCombination(coin,tar));

    }
    public static int CoinChangeCombination(int []coin,int finalTar){
        int dp[]=new int[finalTar+1];
        dp[0]=1;
        for(int i=0;i<coin.length;i++){
            int val=coin[i];
            for(int tar=val;tar<=finalTar;tar++){
                dp[tar]=dp[tar]+dp[tar-val];
            }
        }
        
        return dp[finalTar];
    }
}