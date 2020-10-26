import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      printOE(n);
      
      
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static void printOE(int n){
     
    if(n<=0) return ;
    if(isODD(n)){
      System.out.println(n);
    }
    printOE(n-1);
    
    if(n%2==0) System.out.println(n);
    
    
  }
  public static boolean isODD(int n){
    for(int i=2;i<n;i++){
       
        if(n%i==0){
        return false;
          }
       
    }
    if(n==2) return false;
    return  true ;
  }
}