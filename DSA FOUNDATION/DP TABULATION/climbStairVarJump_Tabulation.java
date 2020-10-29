import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int jump[] = new int[n];
        for (int i = 0; i < n; i++) {
            jump[i] = scn.nextInt();
        }
        System.out.println(climbVarMem( jump, jump.length));

        // write your code here
    }
    public static int ClimbVarJumP(int pos, int[] jump, int[] qb) {
        if (pos == jump.length) {
            qb[pos] = 1;
            return qb[pos];
        }
        if (qb[pos] != 0) {
            return qb[pos];
        }
        int maxjump = jump[pos];
        int tways = 0;
        for (int s = 1; s <= maxjump; s++) {

            if (s + pos <= jump.length) {

                tways += ClimbVarJumP(pos + s, jump, qb);

            }

        }

        qb[pos] = tways;

        return tways;



    }
    public static int climbVarMem( int[] jump, int n) {
        int qb[] = new int[n];
        int tways = 0;
 
             
             
         
        for (int i = n; i >= 0; i--) {
            if(i==n){
                qb[n]=1;
                continue;
            }

            for (int j = 1; j >= jump[i]; j++) {
                tways += qb[i + j];
            }
            qb[i] = tways;
            continue;
        }


        return qb[0];





    }

}