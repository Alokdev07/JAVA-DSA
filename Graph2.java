import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.testng.internal.Graph;

public class Graph2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void  createGraph(ArrayList<Edge> Graph[]){
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(s: 0, d: 1));
        graph[0].add(new Edge(s: 0, d: 2));

        graph[1].add(new Edge(s: 1, d: 0));
        graph[1].add(new Edge(s: 1, d: 3));

        graph[2].add(new Edge(s: 2, d: 0));
        graph[2].add(new Edge(s: 2, d: 4));

        graph[3].add(new Edge(s: 3, d: 1));
        graph[3].add(new Edge(s: 3, d: 4));
        graph[3].add(new Edge(s: 3, d: 5));

        graph[4].add(new Edge(s: 4, d: 2));
        graph[4].add(new Edge(s: 4, d: 3));
        graph[4].add(new Edge(s: 4, d: 5));

        graph[5].add(new Edge(s: 5, d: 3));
        graph[5].add(new Edge(s: 5, d: 4));
        graph[5].add(new Edge(s: 5, d: 6));

        graph[6].add(new Edge(s: 6, d: 5));


    }
    
    public static void bfs(ArrayList<Edge> graph,int V){
        Queue<Integer> que = new LinkedList<>();
        boolean visited[] = new boolean[];
        que.add(0)
        while (!que.isEmpty()) {
           int curr = que.remove();
           if (visited[curr] == false) {
            System.out.println(curr + ",");
            visited[curr] = true;
            for (int i = 0; i < graph.size(); i++) {
                Edge e = graph.get(i);
                que.add(e.dest);
            }
           } 
        }
    }
    public static void main(String[] args) {
        int v = 7;
      ArrayList<Edge> graph[] = new ArrayList[];
      createGraph(graph);
      bfs(graph, v);
    }
}
