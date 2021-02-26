import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println(pq);
        pq.add(1);
        System.out.println(pq);
        pq.add(12);
        System.out.println(pq);
        pq.add(123);
        System.out.println(pq);
        pq.add(1234);
        System.out.println(pq);
        pq.add(12345);
        System.out.println(pq);
        pq.add(123456);
        System.out.println(pq);
        while (pq.size() > 0) {

            System.out.println(pq.peek());
            pq.remove();
        }

    }
}