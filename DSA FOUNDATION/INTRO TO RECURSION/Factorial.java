import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        System.out.println(factorial(n));
        // write your code here
    }

    public static int factorial(int n){
        if(n==0) return 1;
         int res=factorial(n-1);
         int facN=n*res;
         return facN;
    }

}