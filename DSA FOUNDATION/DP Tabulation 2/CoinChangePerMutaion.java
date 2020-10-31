import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int coin[] = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        System.out.println(CoinChangePermution(coin, tar));

    }
    public static int CoinChangePermution(int[] coin, int finalTar) {
        int dp[] = new int[finalTar + 1];
        dp[0] = 1;
        for (int tar = 1; tar <= finalTar; tar++) {
            for (int val = 0; val < coin.length; val++) {
                int c = coin[val];
                if (tar - c >= 0) {
                    dp[tar] = dp[tar] + dp[tar - c];
                }
            }
        }

        return dp[finalTar];
    }
}