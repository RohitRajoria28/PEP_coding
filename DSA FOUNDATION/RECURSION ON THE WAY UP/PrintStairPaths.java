import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");

    }

    public static void printStairPaths(int n, String path) {

        if (n == 0) {
            // ans found
            System.out.println(path);
            return;
        }
        // if (n < 0) {
        //     // invalid place 
        //     return;
        // }

        // for 1st step 
        if (n >= 1) {

            printStairPaths(n - 1, path + '1');


        }
 
        // for 2nd step
        if (n >= 2) {
            printStairPaths(n - 2, path + '2');

        }

        // for 3rd step
        if (n >= 3) {
            printStairPaths(n - 3, path + '3');
        }

    }

}