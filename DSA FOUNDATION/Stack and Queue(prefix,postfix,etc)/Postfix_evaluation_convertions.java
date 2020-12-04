import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String eq = scn.nextLine();

        Stack<String> infixExp = new Stack<String>();
        Stack<String> prefixExp = new Stack<String>();
        Stack<Integer> infixEva = new Stack<Integer>();

        for (int i = 0; i < eq.length(); i++) {
            char ch = eq.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                CreateInfixExp(infixExp, ch);
                CreatePrefixExp(prefixExp, ch);
                CreateInfixEva(infixEva, ch);

            } else {
                infixExp.push(ch + "");
                prefixExp.push(ch + "");
                infixEva.push(ch - '0');
            }

        }

        System.out.println(infixEva.peek());
        System.out.println(infixExp.peek());
        System.out.println(prefixExp.peek());

        // code
    }

    public static void CreateInfixExp(Stack<String> infixExp, char op) {
        String v2 = infixExp.pop();
        String v1 = infixExp.pop();

        infixExp.push("(" + v1 + op + v2 + ")");
    }

    public static void CreatePrefixExp(Stack<String> prefixExp, char op) {
        String v2 = prefixExp.pop();
        String v1 = prefixExp.pop();

        prefixExp.push(op + v1 + v2);
    }

    public static void CreateInfixEva(Stack<Integer> InfixEva, char op) {
        int v2 = InfixEva.pop();
        int v1 = InfixEva.pop();

        if (op == '-') {
            InfixEva.push(v1 - v2);
        } else if (op == '+') {
            InfixEva.push(v1 + v2);
        } else if (op == '*') {
            InfixEva.push(v1 * v2);
        } else if (op == '/') {
            InfixEva.push(v1 / v2);
        }

    }
}