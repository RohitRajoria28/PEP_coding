import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      Printp(n) ;
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static void Printp(int n){
    if(n<=0){
      return ;
    }
    for(int i=0;i<n;i++){
      System.out.print("*");
    }
    System.out.println();
    Printp(n-1);
    
  }
}