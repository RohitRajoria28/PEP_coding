import java.util.*;

public class Main {
    public static class Node {
        int data;
        ArrayList<Node> children;

        Node() {
            children = new ArrayList<Node>();
        }
    }

    public static class GenericTree {
        Node root;
    }

    public static void display(Node node) {

        // print self
        System.out.print(node.data + " -> ");

        // print your child node data
        for (Node child : node.children) {
            System.out.print(child.data + " ,");
        }

        System.out.println(".");

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int input[]) {
        Stack<Node> st = new Stack<>();
        Node root = null;
        for (int idx = 0; idx < input.length; idx++) {
            int val = input[idx];

            if (val == -1) {
                st.pop();
            } else {
                // valid data

                // 1. create node
                Node node = new Node();

                // 2. assign data
                node.data = val;

                if (st.size() == 0) {
                    // first node --> root
                    root = node;
                } else {
                    Node parent = st.peek();
                    // connect child node with it's parent
                    parent.children.add(node);
                }

                // 3. push node to stack
                st.push(node);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        GenericTree gt = new GenericTree();
        int input[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, 110, -1, 120, -1, 130, -1, -1, -1, 40, 80, -1, 90, -1, -1,
                -1 };
        Node node = construct(input); // node --> root-node
        gt.root = node;
        display(gt.root);
    }
}