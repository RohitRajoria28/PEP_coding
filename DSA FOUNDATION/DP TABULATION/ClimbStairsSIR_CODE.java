import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(climbDPMEM(n));

        // write your code here
    }
    public static int climbDP(int n, int[] qb) {

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            qb[n] = 1;
            return 1;
        }
        if (qb[n] != 0) {
            return qb[n];
        }

        // step 1
        int step1 = climbDP(n - 1, qb);
        // step 2
        int step2 = climbDP(n - 2, qb);
        // step 3
        int step3 = climbDP(n - 3, qb);

        int ans = step1 + step2 + step3;
        qb[n] = ans;
        return ans;




    }
    public static int climbDPMEM(int n) {

        int qb[] = new int[n + 1];


        for (int i = 0; i <= n; i++) {
            
            if (i == 0  ) {
                qb[i] = 1;
                continue;
            }
            int tways=0;


           //  step 1
           if(i>=1) tways += qb[i-1];
             
            // step 2
            if(i>=2) tways +=  qb[i-2];
              
            // step 3
             if(i>=3) tways +=  qb[i-3];
             
            qb[i] = tways;
             continue;
        }
        
        return qb[n];

    }


}