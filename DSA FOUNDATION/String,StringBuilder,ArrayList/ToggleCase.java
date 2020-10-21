import java.io.*;
import java.util.*;

public class  ToggleCase {

	public static String toggleCase(String str){
        StringBuilder inp=new StringBuilder(str);
        StringBuilder res=new StringBuilder();


        
        for(int i=0;i<str.length();i++){
            char ch1=str.charAt(i);

            if(ch1<='a' && ch1<='z'){
                // char is Lowercase
                char Capt=(char)('A'+(ch1-'a'));
                res.append(Capt);

            }else if(ch1>='A' && ch1<= 'Z'){
                //  Capital letter

                char LowC=(char)('a'+(ch1-'A'));
                res.append(LowC);
            }
        }
		//write your code here

		return res.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}