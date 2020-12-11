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

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr) {
        Stack < Integer > helperS = new Stack < Integer > ();
        int ansM[] = new int[arr.length];

        int infinite = 1;
        ansM[0] = 1;
        helperS.push(0);

        for (int i = 1; i < arr.length; i++) {
            int cv=arr[i];
            while(helperS.size()>0 && cv>arr[helperS.peek()]){
                helperS.pop();
            }
            if(helperS.size()==0){
                 ansM[i]=i+1;
            }else{
                 ansM[i]=i-helperS.peek();
            }
            
            helperS.push(i);
             
        }
        
        return ansM;


    }

}