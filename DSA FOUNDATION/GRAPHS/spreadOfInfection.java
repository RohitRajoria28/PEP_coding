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

    public static class Ipair {
        int vtx;
        int toi;

        Ipair(int vtx, int toi) {
            this.vtx = vtx;
            this.toi = toi;
        }
    }

    public static int infectionSpread(ArrayList<Edge>[] graph, int src, int time) {
        Queue<Ipair> queue = new ArrayDeque<Ipair>();
        boolean visited[] = new boolean[graph.length];
        int ctime = 0;
        queue.add(new Ipair(src, 1));
        while (queue.size() > 0) {
            // remove current
            Ipair fpair = queue.remove();
            if (fpair.toi <= time) {
                if (visited[fpair.vtx] == false) {
                    visited[fpair.vtx] = true;
                    ctime++;
                    for (Edge e : graph[fpair.vtx]) {
                        if (visited[e.nbr] == false) {
                            queue.add(new Ipair(e.nbr, fpair.toi + 1));
                        }
                    }
                }

            }

        }
        return ctime;
    }

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
        int t = Integer.parseInt(br.readLine());

        System.out.println(infectionSpread(graph, src, t));
    }

}