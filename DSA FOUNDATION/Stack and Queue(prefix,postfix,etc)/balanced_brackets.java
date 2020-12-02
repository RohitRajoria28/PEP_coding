import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String st = scn.nextLine();

        System.out.println(isBalanced(st));

    }
    public static boolean isBalanced(String eq) {
        Stack < Character > st = new Stack < Character > ();
        for (int i = 0 ; i < eq.length(); i++) {
            char ch = eq.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {

                // for ],},) check 
                if (st.size() == 0) {
                    return false;
                } else if (ch == ')' && st.peek() != '(') {
                    return false;
                } else if (ch == ']' && st.peek() != '[') {
                    return false;
                } else if (ch == '}' && st.peek() != '{') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        if (st.size() == 0) {
            return true;
        } else {
            return false;
        }


    }


}