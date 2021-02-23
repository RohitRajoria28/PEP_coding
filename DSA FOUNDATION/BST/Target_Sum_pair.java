import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // METHOD 1
    // STARTING OF ANSWER
    public static void targetSumPairhelper(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        targetSumPairhelper(node.left, list);
        list.add(node.data);
        targetSumPairhelper(node.right, list);
    }

    public static void targetSumPair(Node node, int target) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        targetSumPairhelper(node, list);
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int lv = list.get(lo), hv = list.get(hi);
            if (lv + hv < target) {
                lo++;
            } else if (lv + hv > target) {
                hi--;
            } else {
                // lv+hv==target
                System.out.println(lv + " " + hv);
                lo++;
                hi--;
            }
        }

    }

    // ENDING OF ANSWER
    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;

        }
        if (node.data == data) {
            return true;
        } else if (node.data < data) {
            // move to larger nodes
            return find(node.right, data);
        } else {
            // move to smaller nodes
            return find(node.left, data);
        }
    }

    // METHOD 1
    // STARTING OF ANSWER
    public static void targetSumPair2(Node root, Node node, int target) {
        if (node == null) {
            return;
        }
        targetSumPair2(root, node.left, target);
        int val = node.data;
        int cval = target - val;
        if (cval > val) {
            if (find(root, cval)) {
                System.out.println(val + " " + cval);
            }
        } else {
            return;
        }
        targetSumPair2(root, node.right, target);

    }

    // ENDING OF ANSWER
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        // targetSumPair(root,data);
        targetSumPair2(root, root, data);
    }

}