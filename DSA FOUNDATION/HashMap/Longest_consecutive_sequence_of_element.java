import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // main logic
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], true);
        }
        for (int key : hm.keySet()) {
            if (hm.containsKey(key - 1)) {
                hm.put(key, false);
            }
        }
        int rstartingPoint = -1, rCount = -1;
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            if (hm.get(val)) {
                // stsrting point found
                int lstartingP = val, lcount = 1;
                while (hm.containsKey(lstartingP + lcount)) {
                    lcount++;
                }
                if (lcount > rCount) {
                    rCount = lcount;
                    rstartingPoint = lstartingP;
                }
            }
        }

        for (int i = 0; i < rCount; i++) {
            System.out.println(rstartingPoint + i);
        }
    }

}