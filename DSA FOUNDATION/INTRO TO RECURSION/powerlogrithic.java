import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();

        System.out.println(power(x, n));
        // write your code here
    }

    public static int power(int x, int pow) {
        if (pow == 0) return 1;
        int res = power(x, pow / 2);
        int facN = res * res;
        if (pow % 2 != 0) facN=facN * x;
        return facN;

    }

}