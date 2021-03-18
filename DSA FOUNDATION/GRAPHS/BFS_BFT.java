import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    // STARTING OF ANAWER
    public static class BFSpair {
        int vtx;
        String psf;

        BFSpair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public static void BFStraversal(ArrayList<Edge>[] graph, int scr) {
        Queue<BFSpair> queue = new ArrayDeque<BFSpair>();
        queue.add(new BFSpair(scr, "" + scr));
        boolean visited[] = new boolean[graph.length];
        while (queue.size() > 0) {
            BFSpair fpair = queue.remove();
            if (visited[fpair.vtx] == false) {
                visited[fpair.vtx] = true;
                System.out.println(fpair.vtx + "@" + fpair.psf);
            }
            // adding neighbors
            for (Edge e : graph[fpair.vtx]) {
                if (visited[e.nbr] == false) {
                    queue.add(new BFSpair(e.nbr, fpair.psf + e.nbr));
                }
            }
        }
    }

    // ANSWER ENDING
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        BFStraversal(graph, src);
        // write your code here
    }
}