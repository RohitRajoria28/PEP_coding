import java.io.*;
import java.util.*;

public class Main {

    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        // STATING of effient method
        public void add(int val) {
            data.add(val);
            // efficient approach by downheapify--O(n)
            for (int idx = data.size() - 1; idx >= 0; idx--) {
                downHeapify(idx);
            }
        }

        // ending
        public void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        public void upheapify(int idx) {
            if (idx == 0) {
                return;
            }
            int parentIdx = (idx - 1) / 2;
            if (data.get(parentIdx) > data.get(idx)) {
                swap(parentIdx, idx);
                upheapify(parentIdx);
            }
        }

        public int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downHeapify(0);
            return val;
        }

        private void downHeapify(int pidx) {
            int lidx = (2 * pidx) + 1;
            int ridx = (2 * pidx) + 2;

            if (lidx < data.size() && ridx < data.size()) {
                int min = Math.min(Math.min(data.get(pidx), data.get(lidx)), data.get(ridx));

                if (min == data.get(lidx)) {
                    swap(lidx, pidx);
                    downHeapify(lidx);
                }
                if (min == data.get(ridx)) {
                    swap(ridx, pidx);
                    downHeapify(ridx);
                }
            } else if (lidx < data.size()) {
                int min = Math.min(data.get(pidx), data.get(lidx));
                if (min == data.get(lidx)) {
                    swap(lidx, pidx);
                    downHeapify(lidx);
                }
            }
        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}