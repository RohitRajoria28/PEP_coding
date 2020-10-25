import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int jump[] = new int[n];

        for (int i = 0; i < jump.length; i++) {
            jump[i] = scn.nextInt();
        }

        System.out.println(climbStairVariable(0, jump,new int[n+1]));


        // write your code here
    }
    public static int climbStairVariable(int pos, int[] jump,int qb[]) {
        if (pos == jump.length) {
            qb[pos]=1;
            // reached Destination
            return 1;
        }
        
        if(qb[pos]!=0){
             
            return  qb[pos];
        }


        // jump steps to be added
        int mjump = jump[pos];
        int tways = 0;

        for (int step = 1; step <= mjump; step++) {
            if (pos + step <= jump.length) {

                tways += climbStairVariable(pos + step, jump,qb);
      
            }

        }
        qb[pos]=tways;
    
        return tways;


    }

}