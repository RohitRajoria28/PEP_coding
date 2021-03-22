import java.io.*;
import java.util.*;

public class mini {
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

   // public static class MSpair implements Comparable<MSpair> {
   // int vtx;
   // int p;
   // int wt;

   // MSpair(int vtx, int p, int wt) {
   // this.vtx = vtx;
   // this.p = p;
   // this.wt = wt;
   // }

   // public int compareto(MSpair o) {
   // return this.wt - o.wt;
   // }
   // }

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

      PriorityQueue<MSpair> pq = new PriorityQueue<MSpair>();
      pq.add(new MSpair(0, -1, 0));
      boolean visited[] = new boolean[graph.length];
      while (pq.size() > 0) {
         MSpair rem = pq.remove();
         if (visited[rem.vtx] == false) {
            visited[rem.vtx] = true;
            if (rem.p != -1) {
               System.out.println("[" + rem.vtx + "-" + rem.p + "@" + rem.wt + "]");
            }

            for (Edge e : graph[rem.vtx]) {
               if (visited[e.nbr] == false) {
                  pq.add(new MSpair(e.nbr, rem.vtx, e.wt));
               }
            }
         }
      }
   }

   public static class MSpair implements Comparable<MSpair> {
      int vtx;
      int p;
      int wt;

      MSpair(int vtx, int p, int wt) {
         this.vtx = vtx;
         this.p = p;
         this.wt = wt;
      }

      public int compareTo(MSpair o) {
         return (this.wt - o.wt);
      }
   }

}