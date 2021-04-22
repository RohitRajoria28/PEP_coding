import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class  Main {
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
    
        int visited[]=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int i=0;i<graph.length;i++){
            if(visited[i]==-1){
                boolean isbipatite=checkbipatite(graph,i,visited);
                if(isbipatite==false){
                    System.out.println(false);
                    return;
                }
            } 
        }
        System.out.println(true);
     }
     public static class bpair{
        int vtx;
        int level;
        bpair(int vtx,int level){
            this.vtx=vtx;
            this.level=level;
        }
    }
     public static boolean checkbipatite(ArrayList<Edge>[] graph,int src,int []visited){
             ArrayDeque<bpair> pq=new  ArrayDeque<bpair>();
            pq.add(new bpair(src,0));
            while(pq.size()>0){
                bpair fpair=pq.removeFirst();
                if(visited[fpair.vtx]!=-1){
                //    some work to do 
                 if(visited[fpair.vtx]!=fpair.level){
                     return false;
                 }
                }else{
                    visited[fpair.vtx]=fpair.level;  
                }
                for(Edge e:graph[fpair.vtx]){
                    if(visited[e.nbr]==-1){
                        pq.add(new bpair(e.nbr,fpair.level+1));
                    }
                }
            }
            return true;
     }
}