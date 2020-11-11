import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int ndays = scn.nextInt();
        int prices[] = new int[ndays];
        for (int i = 0; i < ndays; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(BuySellStocksOta(prices));
        // write your code here
    }
    public static int BuySellStocksOta(int[] prices) {
        int buyPrice=prices[0];
        int overallProfit=0;
        for(int sellpt=1;sellpt<prices.length;sellpt++){
            int sellprice=prices[sellpt];
            if( sellprice<buyPrice){
                buyPrice= sellprice;
            }
            int transactionProfit= sellprice-buyPrice;
            if(transactionProfit>overallProfit){
                 overallProfit=transactionProfit;
            }
            
        }
        return overallProfit;
        // // make dp of length value
        // int dp[] = new int[prices.length];
        // for (int day = 0; day < prices.length; day++) {
        //     int Min = Integer.MAX_VALUE;
        //     // finding the minimum stock of previous days 
        //     for (int stk = day; stk >= 0; stk--) {
        //         Min = Math.min(Min, prices[stk]);
        //     }
        //     // Maximum profit of that perticular day
        //     dp[day]=prices[day]-Min;
        // }
        // // Maximum profit of the days 
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<prices.length;i++){
        //     max=Math.max(max,dp[i]);
        // }
        // return max;
    }
}