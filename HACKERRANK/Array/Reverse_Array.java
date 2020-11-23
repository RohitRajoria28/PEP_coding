import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      
      int n=scn.nextInt();
      int arr[]=new int[n];
      
      for(int i=0;i<n;i++){
        arr[i]=scn.nextInt();
      }
      
      Reverse(arr);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
  public static void Reverse(int arr[]){
    int i=0;
    int j=arr.length-1;
    while(i<=j){
      int temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
      i++;
      j--;
    }
    
    for(int k=0;k<arr.length;k++){
      System.out.print(arr[k]+" ");
    }
  }
}