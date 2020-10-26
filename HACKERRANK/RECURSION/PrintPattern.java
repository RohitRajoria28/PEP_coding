import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      printP(n);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static void printP(int n){
    if(n<=0) return ;
    
    printP(n-1);
    
    for(int i=1;i<=n;i++){
      System.out.print("*");
    }
    System.out.println();
    
  }
}