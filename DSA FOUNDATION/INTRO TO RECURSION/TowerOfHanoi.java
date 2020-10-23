import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int t1id=scn.nextInt();
        int t2id=scn.nextInt();
        int t3id=scn.nextInt();
        toh(n,t1id,t2id,t3id);
         
        // write your code here
    }

    public static void toh(int n, int src, int des, int helper){
        if(n==0) return ;
         
        // moving n-1 disk from src to helper  
        toh(n-1,src,helper,des);
        
        System.out.println(n+"["+src+" -> "+des+"]");
        // moving  n-1 disk from helper to destn 
        toh(n-1,helper,des,src);
        
    }

}