import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class pair {
        Node node;
        int state;

        pair(Node n, int s) {
            node = n;
            state = s;
        }
    }

    public static Node construct(Integer input[]) {
        int idx = 1;
        Stack<pair> st = new Stack<pair>();
        Node root = new Node(input[0]);
        st.push(new pair(root, 1));

        while (st.size() > 0) {
            pair top = st.peek();
            if (top.state == 1) {
                // make left child
                Integer data = input[idx];
                if (data != null) {
                    top.node.left = new Node(data);
                    st.push(new pair(top.node.left, 1));
                } else {
                    top.node.left = null;
                }
                top.state++;
                idx++;
            } else if (top.state == 2) {
                // make right child
                Integer data = input[idx];
                if (data != null) {
                    top.node.right = new Node(data);
                    st.push(new pair(top.node.right, 1));
                } else {
                    top.node.right = null;
                }
                top.state++;
                idx++;
            } else if (top.state == 3) {
                // ALl left and right childs are builded just pop the top state
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String val = "";
        if (node.left != null) {
            val += node.left.data;
        } else {
            val += ".";
        }

        val += " -> " + node.data + " <- ";

        if (node.right != null) {
            val += node.right.data;
        } else {
            val += ".";
        }

        System.out.println(val);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        Integer input[] = { 10, 20, 40, null, null, 50, 60, null, null, null, 30, null, 70, 80, 90, null, null, 100,
                null, null, null };

        Node root = construct(input);
        display(root);
    }
}