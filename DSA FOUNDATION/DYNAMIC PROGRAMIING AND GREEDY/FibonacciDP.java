import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long start = System.currentTimeMillis();
        System.out.println(fibN(n, new int[n + 1]));
        long end = System.currentTimeMillis();
          System.out.println("time : "+(end-start));


        // write your code here
    }
    public static int fibN(int n, int ab[]) {

        if (n == 0 || n == 1) {
            ab[n]=n;
            return n;
        }

        // check if element exists
        if (ab[n] != 0) return ab[n];
        
        int fibNm1 = fibN(n - 1, ab);
        
        int fibNm2 = fibN(n - 2, ab);
        
        int fib = fibNm1 + fibNm2;
        // store returned values in ab[] array
        ab[n] = fib;
        return fib;

    }

}