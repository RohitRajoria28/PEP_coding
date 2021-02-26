
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        // Main logic

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (pq.size() < k) {
                pq.add(val);
            } else {
                if (val > pq.peek()) {
                    pq.remove();
                    pq.add(val);
                }
            }
        }
        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }

    }

}