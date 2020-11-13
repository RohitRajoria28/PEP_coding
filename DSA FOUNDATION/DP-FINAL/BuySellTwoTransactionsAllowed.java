  
 import java.io.*;
 import java.util.*;
 
 public class Main {
 
     public static void main(String[] args) throws Exception {
         Scanner scn=new Scanner(System.in);
         int n=scn.nextInt();
         int prices[]=new int[n];
         
         for(int i=0;i<n;i++){
              prices[i]=scn.nextInt();
         }
         
         
         // profit for selling the stock at a partiular day
         int sp[]=new int[n];
         int buyprice=prices[0];
         int maxProfit=0;
         for(int sellpt=1;sellpt<n;sellpt++){
             int sellprice=prices[sellpt];
             
             if(sellprice<buyprice){
                 // loss
                buyprice= sellprice ;
             }
             int profitDay=sellprice-buyprice;
             if(maxProfit<profitDay){
                 maxProfit=profitDay;
             }
             sp[sellpt]=maxProfit;
         }
         
         
         // profit if buying a stock at a particular day
         int bp[]=new int[n];
         int sellPrice=prices[n-1];
         int maxProf=0;
         for(int buypt=n-2;buypt>=0;buypt--){
             buyprice=prices[buypt];
             if(buyprice>sellPrice){
                 // loss 
                 sellPrice= buyprice;
                 
             }
              int profitDay=sellPrice-buyprice;
             
             if( maxProf<profitDay){
                  maxProf=profitDay;
             }
             bp[buypt]= maxProf;
         }
         
         int max=Integer.MIN_VALUE;
         for(int i=0;i<n;i++){
             if(max<(sp[i]+bp[i])){
                 max=sp[i]+bp[i];
             }
         }
         System.out.println(max);
         // write your code here
     }
 
 }