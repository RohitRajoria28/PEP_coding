import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        printKPC(str, "");

    }
    static String keyword[] = {
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

    public static void printKPC(String qsf, String asf) {
        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = qsf.charAt(0);
        String ros = qsf.substring(1);
        int key = ch - '0';
        String word = keyword[key];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);


            printKPC(ros, asf + c);
        }







    }

}