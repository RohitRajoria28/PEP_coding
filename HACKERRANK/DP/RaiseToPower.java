import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      
      int n=scn.nextInt();
      for(int i=0;i<n;i++){
        int num=scn.nextInt();
        int pow=scn.nextInt();
        System.out.println(Power(num,pow));
                           
      }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static int Power(int num,int power){
     if(power==0) return 1; 
    int res=Power(num,power/2);
    int pow=res*res;
    if(power%2!=0){
      pow=pow*num;
    }
    return pow;
  }
}