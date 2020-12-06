import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

        Stack < String > prefix = new Stack < String > ();
        Stack < String > postfix = new Stack < String > ();
        Stack < Character > operator = new Stack < Character > ();

        for (int idx = 0; idx < exp.length(); idx++) {
            char ch = exp.charAt(idx);

            if (ch == '(') {
                operator.push(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operator.size() != 0 && operator.peek() != '(' &&
                    precedence(ch) <= precedence(operator.peek())) {

                    String preV2 = prefix.pop();
                    String preV1 = prefix.pop();
                    char op = operator.pop();
                    prefix.push(op + preV1 + preV2);

                    String postV2 = postfix.pop();
                    String postV1 = postfix.pop();
                    postfix.push(postV1 + postV2 + op);
                }
                operator.push(ch);
            } else if (ch == ')') {
                while (operator.peek() != '(') {
                    String preV2 = prefix.pop();
                    String preV1 = prefix.pop();
                    char op = operator.pop();
                    prefix.push(op + preV1 + preV2);

                    String postV2 = postfix.pop();
                    String postV1 = postfix.pop();
                    postfix.push(postV1 + postV2 + op);
                }
                operator.pop();
            } else {
                prefix.push(ch + "");
                postfix.push(ch + "");
            }
        }
        while (operator.size() != 0) {
            String preV2 = prefix.pop();
            String preV1 = prefix.pop();
            char op = operator.pop();
            prefix.push(op + preV1 + preV2);

            String postV2 = postfix.pop();
            String postV1 = postfix.pop();
            postfix.push(postV1 + postV2 + op);
        }
        System.out.println(postfix.peek());
        System.out.println(prefix.peek());
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else {
            return 2;
        }
    }
}