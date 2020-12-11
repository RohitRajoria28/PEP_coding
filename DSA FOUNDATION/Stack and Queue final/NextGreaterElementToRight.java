import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val: a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr) {
        Stack < Integer > helperS = new Stack < Integer > ();
        int ansM[] = new int[arr.length];
        helperS.push(arr[arr.length - 1]);
        ansM[arr.length - 1] = -1;
        int ans=0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int ce = arr[i];
            //   pop function 
            while (helperS.size() > 0 && ce > helperS.peek()) {
                // pop until greater element is found or stack is empty
                helperS.pop();
            }
            if (helperS.size() == 0) {
                // no Right greater element exist 
                ans = -1;
            } else {
                // greater elements exist 
                ans = helperS.peek();
            }
            // store ans value to array 
            ansM[i] = ans;
            helperS.push(arr[i]);


        }
        return ansM;
    }

}