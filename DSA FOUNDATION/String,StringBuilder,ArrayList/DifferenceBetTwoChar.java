import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
         StringBuilder res=new StringBuilder();
         StringBuilder inp=new StringBuilder(str);
         char ch=inp.charAt(0);
         res.append(ch);

         for(int i=1;i<inp.length();i++){
             char curr=inp.charAt(i);
             char prev=inp.charAt(i-1);

             int p=(int)(curr-prev);
             res.append(p);
             res.append(curr);
         }
          

		return  res.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}