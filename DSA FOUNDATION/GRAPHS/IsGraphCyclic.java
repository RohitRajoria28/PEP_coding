import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    // ANSWER STARTS
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
                if (isCyclic(graph, vtx, visited) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int vtx, boolean visited[]) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(vtx);
        while (queue.size() > 0) {
            int fvtx = queue.remove();

            if (visited[fvtx] == true) {
                return true; // comp is cyclic
            }
            // mark the vtx;
            visited[fvtx] = true;
            for (Edge e : graph[fvtx]) {
                if (visited[e.nbr] == false) {
                    queue.add(e.nbr);
                }
            }
        }
        return false;
    }

    // ENDS
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        System.out.println(isCyclic(graph));
    }
}