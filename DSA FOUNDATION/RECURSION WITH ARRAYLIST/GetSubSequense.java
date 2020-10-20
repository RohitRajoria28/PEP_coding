import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        System.out.println(gss(str));

    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0){
            ArrayList<String> base=new ArrayList<String>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0);
        String roq=str.substring(1);
        ArrayList<String> ress=gss(roq);
        
        ArrayList<String> mylist=new ArrayList<String>();
        
        for(String s:ress){
            mylist.add(s);
        }
        for(String s:ress){
            mylist.add(ch+s);
        }
        return mylist;
        
        
    }

}