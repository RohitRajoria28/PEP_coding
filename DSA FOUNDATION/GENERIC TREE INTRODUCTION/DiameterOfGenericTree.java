import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    // STARTING OF ANSWWER
    static int diaOfTree;

    public static int diameterhelper(Node node) {
        int lh = -1, sh = -1;
        for (Node child : node.children) {
            int rht = diameterhelper(child);
            if (rht > lh) {
                sh = lh;
                lh = rht;
            } else if (rht > sh) {
                sh = rht;
            }
        }
        int diaOfNode = lh + sh + 2;
        if (diaOfNode > diaOfTree) {
            diaOfTree = diaOfNode;
        }
        return lh + 1;
    }

    public static int diameter(Node node) {
        diaOfTree = 0;
        diameterhelper(node);
        return diaOfTree;

    }

    // ENDING OF ANSWER
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);

        System.out.println(diameter(root));
        // write your code here
    }

}