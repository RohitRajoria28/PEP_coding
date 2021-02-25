import java.io.*;
import java.util.*;

public class Main {
    public static void getCommonElement1() {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }
        // main logic
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            int val = arr1[i];
            if (freqMap.containsKey(val)) {
                // char already exist
                int oldf = freqMap.get(val);
                freqMap.put(val, oldf + 1);
            } else {
                // char does not exist
                freqMap.put(val, 1);
            }
        }

        for (int i = 0; i < arr2.length && freqMap.size() > 0; i++) {
            int val = arr2[i];
            if (freqMap.containsKey(val)) {
                System.out.println(val);
                freqMap.remove(val);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        getCommonElement1();
    }

}