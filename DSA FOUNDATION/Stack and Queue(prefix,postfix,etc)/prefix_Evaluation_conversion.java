import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String eq = scn.nextLine();

        Stack<String> infixExp = new Stack<String>();
        Stack<String> postfixExp = new Stack<String>();
        Stack<Integer> prifixEva = new Stack<Integer>();

        for (int i = eq.length()-1; i >=0; i--) {
            char ch = eq.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                CreateInfixExp(infixExp, ch);
                CreatePostfixExp( postfixExp,ch);
                 CreatePrefixEva( prifixEva, ch);

            } else {
                infixExp.push(ch + "");
                 postfixExp.push(ch + "");
                 prifixEva.push(ch - '0');
            }

        }

        System.out.println( prifixEva.peek());
        System.out.println(infixExp.peek());
        System.out.println( postfixExp.peek());

        // code
    }

    public static void CreateInfixExp(Stack<String> infixExp, char op) {
        String v1 = infixExp.pop();
        String v2 = infixExp.pop();

        infixExp.push("(" + v1 + op + v2 + ")");
    }

    public static void CreatePostfixExp(Stack<String>  postfixExp, char op) {
        String v1 =  postfixExp.pop();
        String v2 =  postfixExp.pop();

        postfixExp.push(v1+v2+op);
    }

    public static void CreatePrefixEva(Stack<Integer>  prifixEva, char op) {
        int v1 =  prifixEva.pop();
        int v2 =  prifixEva.pop();

        if (op == '-') {
             prifixEva.push(v1 - v2);
        } else if (op == '+') {
             prifixEva.push(v1 + v2);
        } else if (op == '*') {
             prifixEva.push(v1 * v2);
        } else if (op == '/') {
             prifixEva.push(v1 / v2);
        }

    }
}