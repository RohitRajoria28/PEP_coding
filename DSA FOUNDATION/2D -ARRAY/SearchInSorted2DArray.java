import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);

        int n=scn.nextInt();

        int mat[][]=new int[n][n];

        for(int  i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=scn.nextInt();
            }
        }

        int val=scn.nextInt();
        int r=0,c=mat[0].length;

        while(r<mat.length && c>=0){
            if(val==mat[r][c]){
                System.out.println(r);
                System.out.println(c);
                return ;

            }
            else if (val>mat[r][c]){
                r++;
            }else if(val<mat[r][c]){
                c--;
            }
        }

        System.out.println("Not Found");
        // write your code here
    }

}