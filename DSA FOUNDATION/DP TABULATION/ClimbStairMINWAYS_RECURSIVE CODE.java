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
        System.out.println(climbMIN(0, jump));
        // write your code here
    }

    public static int climbMIN(int pos, int[] jump) {
        if (pos == jump.length) {
            // Reached destination 
            return 0;
        }



        int maxjump = jump[pos];
        int Minway = Integer.MAX_VALUE;
        for (int step = 1; step <= maxjump; step++) {
            if (step + pos <= jump.length) {
                int val = climbMIN(pos + step, jump);
                if (Minway > val) {
                    Minway = val;
                }
            }


        }

        

         // check garbage value(  infinite +1=garbage value)
        if (Minway != Integer.MAX_VALUE) {
            
            Minway += 1;
        }
        return Minway;

    }

}