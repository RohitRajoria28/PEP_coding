import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("india", 200);
        System.out.println(hm);
        hm.put("US", 300);
        System.out.println(hm);
        hm.put("China", 100);
        System.out.println(hm);
        hm.put("india", 900);
        System.out.println(hm);
        for (String Key : hm.keySet()) {
            System.out.println(Key);
        }
        System.out.println(hm.get("india"));

        System.out.println(hm.get("China"));

    }
}