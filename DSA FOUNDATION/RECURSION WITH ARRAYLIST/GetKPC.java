import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(getKPC(str));

    }
    static String keypad[] = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };


    public static ArrayList < String > getKPC(String ques) {
        if (ques.length() == 0) {
            ArrayList < String > base = new ArrayList < String > ();
            base.add("");
            return base;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        ArrayList < String > ress = getKPC(roq);
        int idx = ch - '0';
        String word = keypad[idx];

        ArrayList < String > mylist = new ArrayList < String > ();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (String s: ress) {
                mylist.add(c + s);
            }
        }
        return mylist;
    }

}