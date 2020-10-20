import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        System.out.println(getMazePaths(0, 0, n - 1, m - 1));


    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList < String > base = new ArrayList < String > ();
            base.add("");
            return base;
        }
        if (sr > dr || sc > dc) {
            ArrayList < String > base = new ArrayList < String > ();

            return base;
        }

        ArrayList < String > hpath = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList < String > vpath = getMazePaths(sr + 1, sc, dr, dc);

        ArrayList < String > mypath = new ArrayList < String > ();

        for (String s: hpath) {
            mypath.add('h' + s);
        }
        for (String s: vpath) {
            mypath.add('v' + s);
        }

        return mypath;

    }

}