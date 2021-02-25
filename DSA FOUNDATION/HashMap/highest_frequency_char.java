import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String inp = scn.nextLine();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < inp.length(); i++) {
            char ch = inp.charAt(i);
            if (freqMap.containsKey(ch)) {
                // char already exist
                int oldf = freqMap.get(ch);
                freqMap.put(ch, oldf + 1);
            } else {
                // char does not exist
                freqMap.put(ch, 1);
            }
        }
        char hfch = inp.charAt(0);
        for (char ch : freqMap.keySet()) {
            if (freqMap.get(ch) > freqMap.get(hfch)) {
                hfch = ch;
            }
        }
        System.out.println(hfch);
    }

}