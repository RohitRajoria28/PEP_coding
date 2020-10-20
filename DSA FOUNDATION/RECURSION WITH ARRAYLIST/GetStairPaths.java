import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));

    }

    public static ArrayList < String > getStairPaths(int n) {
        if(n==0){
              ArrayList<String>  base=new ArrayList<String>();
              base.add("");
              return base;
        }

        // number of step is 1
        ArrayList<String> mylist=new ArrayList<String>();
        if(n>=1){
            ArrayList<String>  step1=getStairPaths(n-1);
            for(String s:step1){
                 mylist.add(1+s);
            }
        }
        // number of step is 2
        if(n>=2){
            ArrayList<String>  step2=getStairPaths(n-2);
            for(String s:step2){
                 mylist.add(2+s);
            }
        }
        // number of step is 3
        if(n>=3){
            ArrayList<String>  step3=getStairPaths(n-3);
            for(String s:step3){
                 mylist.add(3+s);
            }
        }
        return mylist;

    }

}