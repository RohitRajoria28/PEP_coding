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
        
        int buypt=0;
        int sellpt=0;
        int profit=0;
        
        for(int i=1;i<n;i++){
            if(arr[i]<arr[i-1]){
                // loss
                // count profit 
                profit+=(arr[sellpt]-arr[buypt]);
                // set sellpt and buypoint to i 
                buypt=sellpt=i;
            }else{
                sellpt++;
                // profit
            }
        }
        // find last transaction profit 
         profit+=(arr[sellpt]-arr[buypt]);
         
         
         System.out.println(profit);
        // write your code here
    }

}