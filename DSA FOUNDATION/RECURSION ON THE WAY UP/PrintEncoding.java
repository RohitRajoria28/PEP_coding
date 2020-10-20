import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        printEncodings(str, "");

    }
    static char encoding[] = {
        ' ',
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z'
    };

    public static void printEncodings(String qsf, String asf) {
        if (qsf.length() == 0) {
            System.out.println(asf);
            return;
        }


        char ch1 = qsf.charAt(0);
        if (ch1 == '0') {
            return;
        }

        // For single digit number 
        printEncodings(qsf.substring(1), asf + encoding[ch1 - '0']);

        // For double digut number 
        if (qsf.length() > 1) {
            char ch2 = qsf.charAt(1);
            String temp = "" + ch1 + ch2;
            int num = Integer.parseInt(temp);
            if (num > 1 && num <= 26) {
                printEncodings(qsf.substring(2), asf + encoding[num]);
            }
        }

    }

}