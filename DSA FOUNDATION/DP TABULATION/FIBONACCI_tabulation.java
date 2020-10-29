import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    System.out.println(fibMEM(n));
    // write your code here
 }
 public static int fibTab(int n){
     int mem[]=new int[n+1];
     
     mem[0]=0;
     mem[1]=1;
     for(int i=2;i<=n;i++){
         int fibN1=mem[i-1];
         int fibN2=mem[i-2];
         mem[i]=fibN1+fibN2;
     }
     
     return mem[n];
 }
 
 public static int fibMEM(int n){
     int qb[]=new int[n+1];
     
     for(int i=0;i<=n;i++){
        
        if(i==0 || i==1){
            qb[i]=i;
            continue;
        } 
        
        int fibN1=qb[i-1];
        int fibN2=qb[i-2];
        
        qb[i]=fibN1+fibN2;
        continue; 
     }
     
     return qb[n];
 }

}