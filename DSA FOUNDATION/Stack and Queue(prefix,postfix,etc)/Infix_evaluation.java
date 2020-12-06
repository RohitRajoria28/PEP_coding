import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

        Stack < Integer > operands = new Stack < Integer > ();
        Stack < Character > operators = new Stack < Character > ();

        for (int idx = 0; idx < exp.length(); idx++) {
            char ch = exp.charAt(idx);
            if (ch == '(') {
                operators.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                operands.push(ch - '0');
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.size() != 0 && operators.peek() != '(' &&
                    precedence(ch) <= precedence(operators.peek())) {
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    char op = operators.pop();

                    int val = evaluate(v1, v2, op);
                    operands.push(val);
                }
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    char op = operators.pop();

                    int val = evaluate(v1, v2, op);
                    operands.push(val);
                }
                operators.pop();
            }
        }

        while (operators.size() != 0) {
            int v2 = operands.pop();
            int v1 = operands.pop();
            char op = operators.pop();

            int val = evaluate(v1, v2, op);
            operands.push(val);
        }
        
        System.out.println(operands.peek());
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else {
            //  * , /
            return 2;
        }
    }

    public static int evaluate(int v1, int v2, char op) {
        int val = 0;
        if (op == '+') {
            val = v1 + v2;
        } else if (op == '-') {
            val = v1 - v2;
        } else if (op == '*') {
            val = v1 * v2;
        } else if (op == '/') {
            val = v1 / v2;
        }

        return val;
    }
}




// import java.io.*;
// import java.util.*;

// public class Main {


//     public static void main(String[] args) throws Exception {
//         Scanner scn = new Scanner(System.in);
//         String eq = scn.nextLine();
//         Stack < Character > operators = new Stack <  Character > ();
//         Stack < Integer > operands = new Stack < Integer > ();

//         for (int i = 0; i < eq.length(); i++) {
//             char ch = eq.charAt(i);
//             if (ch == '(') {
//                 operators.push(ch);
//             } else if (ch >= '0' && ch <= '9') {
//                 operands.push(ch-'0');
//             } else if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
//                 while (operators.size() != 0 && operators.peek() != ')' && precedence(ch) <= precedence(operators.peek())) {
//                     int v2 = operands.pop();
//                     int v1 = operands.pop();
//                     char op = operators.pop();
//                     int val = evaluation(v1, v2, op);
//                     operands.push(val);
//                 }
//                 operators.push(ch);

//             } else if (ch == ')') {
//                 while (operators.size() != 0 || operators.peek() != '(') {
//                     int v2 = operands.pop();
//                     int v1 = operands.pop();
//                     char op = operators.pop();
//                     int val = evaluation(v1, v2, op);
//                     operands.push(val);
//                 }
//                 operators.pop();
//             }

//         }
//         while(operators.size()!=0){
//              int v2 = operands.pop();
//                     int v1 = operands.pop();
//                     char op = operators.pop();
//                     int val = evaluation(v1, v2, op);
//                     operands.push(val);
//         }
        
//         System.out.println(operands.peek());
//         // code
//     }
//     public static int precedence(char op) {
//         if (op == '+' || op == '-') {
//             return 1;
//         } else {
//             //  for * and / operators 
//             return 2;
//         }
//     }
//     public static int evaluation(int v1, int v2, char op) {
//         int val=0;

//         if (op == '+') {
//              val= v1 + v2;
//         } else if (op == '-') {
//              val= v1 - v2;
//         } else if (op == '*') {
//              val= v1 * v2;
//         } else if (op == '/') {
//              val= v1 / v2;
//         }
//         return val;
//     }
// }