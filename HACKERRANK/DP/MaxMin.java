import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      for(int i=0;i<n;i++){
        int val=scn.nextInt();
        int arr[]=new int[val];
        for(int j=0;j<val;j++){
          arr[j]=scn.nextInt();
        }
        MinValue(arr);
      }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static  void MinValue(int []arr){
    int min=Integer.MAX_VALUE;
    for(int i=0;i<arr.length;i++){
      min=Math.min(min,arr[i]);
    }
    int max=Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
      max=Math.max(max,arr[i]);
    }
     System.out.println(max+", "+min);
    
  }
}