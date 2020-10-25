import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(climbDP(n, new int[100]));

        // write your code here
    }
    public static int climbDP(int n, int[] qb) {
        
         

        if (n == 0) {
            qb[n] = 1;
            return 1;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int tways=0;

        // step 1
        if(n>=1)  tways+ = climbDP(n - 1, qb);
        
        // step 2
        if(n>=2)  tways+ = climbDP(n - 2, qb);
        
        // step 3
        if(n>=3)  tways+ = climbDP(n - 3, qb);
       

        
        qb[n] =  tways;
        return  tways;




    }

} 