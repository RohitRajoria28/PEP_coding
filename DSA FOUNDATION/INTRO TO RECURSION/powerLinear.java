import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int x=scn.nextInt();
        int n=scn.nextInt();
        System.out.println(power(x,n));
        // write your code here
    }

    public static int power(int x, int n){
        if(n==0) return 1;
         int res=power(x,n-1);
         int powN=x*res;
         return powN;
    }

}