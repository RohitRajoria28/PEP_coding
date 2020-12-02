import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String st = scn.nextLine();
        System.out.println(isDuplicate(st));

    }
    public static boolean isDuplicate(String eq) {
        Stack < Character > st = new Stack< Character > ();
        for (int i = 0; i < eq.length(); i++) {
            char ch = eq.charAt(i);

            if ( ch == ')' ||  ch=='}' ||  ch==']') {
                int count=0;
                 
                while (st.peek() != '(' &&  st.peek()!='{' &&  st.peek()!='[' ) {
                    st.pop();
                    count++;
                }
                st.pop();
                if(count==0) return true ;
                
            }else{
                 st.push(ch);
            }
           
        }
        return false;
    }

}