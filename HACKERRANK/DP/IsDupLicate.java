import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      for(int i=0;i<n;i++){
        int v=scn.nextInt();
        int arr[]=new int[v];
        for(int j=0;j<v;j++){
          arr[j]=scn.nextInt();
        }
        System.out.println(hasDup(arr));
      }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static boolean hasDup(int []arr){
    
    for(int i=0;i<arr.length;i++){
      for(int j=i+1;j<arr.length;j++){
        if(arr[i]==arr[j]){
          return true;
        }
      }
    }
    
    return false ;
  }
}