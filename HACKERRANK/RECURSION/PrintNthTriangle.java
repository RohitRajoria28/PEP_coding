import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      System.out.println(Printp(n));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static int Printp(int n){
    if(n==0) return 0;
    
    int val=Printp(n-1);
    int ans=n+val;
    return ans;
  }
}