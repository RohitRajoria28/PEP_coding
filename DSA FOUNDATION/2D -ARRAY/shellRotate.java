import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);

        int row=scn.nextInt();
        int col=scn.nextInt();
        int mat[][]=new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mat[i][j]=scn.nextInt();

            }
        }

        int shell=scn.nextInt();
        int rotation=scn.nextInt();

        ShellRotate(mat,shell,rotation);
        display(mat);

        // write your code here
    }

    public static void  ShellRotate(int mat[][],int shell,int rotate){
        // fill in 1D array
        int arr[]=Fill1D(mat,shell);

        // Reverse 1D array by rotate 
        Rotate(arr,rotate);
        // convert and fill arry in shell
        Fill2DArray(mat,shell,arr);

    }
    public static int[] Fill1D(int mat[][],int s){
        int rmin=s-1,cmin=s-1,rmax=mat.length-s,cmax=mat[0].length-s;
        int n=2*((rmax-rmin)+(cmax-cmin));

        int arr[]=new int[n];
        int idx=0;
        // left wall
        for(int i=rmin;i<=rmax;i++){
            arr[idx]=mat[i][cmin];
            idx++;
        }
        cmin++;
        // bottom wall
        
        for(int i=cmin;i<=cmax;i++){
            arr[idx]=mat[rmax][i];
            idx++;
        }
        rmax--;
        // right wall
        for(int i=rmax;i>=rmin;i--){
            arr[idx]=mat[i][cmax];
            idx++;
        }
        cmax--;

        // top wall
        for(int i=cmax;i>=cmin;i--){
            arr[idx]=mat[rmin][i];
            idx++;
        }
        // rmin++;

        return arr;
    }

    public static void Fill2DArray(int mat[][],int s,int arr[]){
        int rmin=s-1,cmin=s-1,rmax=mat.length-s,cmax=mat[0].length-s;
        int n=2*((rmax-rmin)+(cmax-cmin));

        // int arr[]=new int[n];
        int idx=0;
        // left wall
        for(int i=rmin;i<=rmax;i++){
            mat[i][cmin]=arr[idx];
            idx++;
        }
        cmin++;
        // bottom wall
        
        for(int i=cmin;i<=cmax;i++){
             mat[rmax][i]=arr[idx];
            idx++;
        }
        rmax--;
        // right wall
        for(int i=rmax;i>=rmin;i--){
             mat[i][cmax]=arr[idx];
            idx++;
        }
        cmax--;

        // top wall
        for(int i=cmax;i>=cmin;i--){
              mat[rmin][i]=arr[idx];
              idx++;
        }
         
    }

    public static void Rotate(int  arr[],int r){
        r=r%arr.length;

        if(r<0){
            r=r+arr.length;

        }
        int n =arr.length;
        Reverse( arr,n-r,n-1);
        Reverse( arr,0,n-r-1);
        Reverse( arr,0,n-1);

    }
    public static void Reverse(int  arr[],int si,int ei){
        while(si<ei){
            int temp= arr[si];
            arr[si]= arr[ei];
            arr[ei]=temp;
            si++;
            ei--;
        }
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