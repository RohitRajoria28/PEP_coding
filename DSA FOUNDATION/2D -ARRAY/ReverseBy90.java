import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int n = scn.nextInt();

        int arr[][] = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for(int j=0;j<arr[0].length;j++){
                
                arr[i][j]=scn.nextInt();
                
                
            }

        }
        // Transpose of a matrix;

         for (int i = 0; i < arr.length; i++) {
            for(int j=i;j<arr[0].length;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
                 
                
                
            }

        }
        // REverse if a matrix

        for(int r=0;r<n;r++){
            int lo=0,hi=arr[0].length-1;
            while(lo<hi){
                int temp=arr[r][lo];
                arr[r][lo]=arr[r][hi];
                arr[r][hi]=temp;
                lo++;
                hi--;
            }
        }
        
        
        
        display(arr);
        // write your code here
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}