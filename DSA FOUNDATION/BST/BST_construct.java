
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public static Node construct(int input[], int lo, int hi) {
        if (lo > hi)
            return null;
        int mid = (lo + hi) / 2;
        Node node = new Node();
        node.data = input[mid];
        node.left = construct(input, lo, mid - 1);
        node.right = construct(input, mid + 1, hi);

        return node;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String val = "";

        if (node.left == null) {
            val += ".";
        } else {
            val += node.left.data;
        }

        val += " -> " + node.data + " <- ";

        if (node.right == null) {
            val += ".";
        } else {
            val += node.right.data;
        }

        System.out.println(val);

        display(node.left);
        display(node.right);

    }

    public static void main(String[] args) {
        int input[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

        Node root = construct(input, 0, input.length - 1);
        display(root);
    }
}