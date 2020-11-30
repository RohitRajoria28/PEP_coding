import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<Integer>();

        System.out.println(st + "---->" + st.size());
        st.push(10);
        System.out.println(st + "---->" + st.size());
        st.push(20);
        System.out.println(st + "---->" + st.size());
        st.push(30);
        System.out.println(st + "---->" + st.size());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.peek());

    }
}