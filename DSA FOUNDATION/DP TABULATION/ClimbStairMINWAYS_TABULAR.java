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
        System.out.println(climbMIN(0, jump,new int[n+1]));
        // write your code here
    }

    public static int climbMIN(int pos, int[] jump,int []qb) {
        if (pos == jump.length) {
            qb[pos]=0;
            // Reached destination 
            return 0;
        }
        if(qb[pos]!=0){
            return qb[pos];
        }



        int maxjump = jump[pos];
        int Minway = Integer.MAX_VALUE;
        for (int step = 1; step <= maxjump; step++) {
            if (step + pos <= jump.length) {
                int val = climbMIN(pos + step, jump,qb);
                if (Minway > val) {
                    Minway = val;
                }
            }


        }

        

         // check garbage value(  infinite +1=garbage value)
        if (Minway != Integer.MAX_VALUE) {
            
            Minway += 1;
        }
        qb[pos]=Minway;
        return Minway;

    }

}