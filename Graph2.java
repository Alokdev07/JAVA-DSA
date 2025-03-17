import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class Graph2 {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void  createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge( 0,  1));
        graph[0].add(new Edge( 0,  2));

        graph[1].add(new Edge( 1,  0));
        graph[1].add(new Edge( 1,  3));

        graph[2].add(new Edge( 2,  0));
        graph[2].add(new Edge( 2,  4));

        graph[3].add(new Edge( 3,  1));
        graph[3].add(new Edge( 3,  4));
        graph[3].add(new Edge( 3,  5));

        graph[4].add(new Edge( 4,  2));
        graph[4].add(new Edge( 4,  3));
        graph[4].add(new Edge( 4,  5));

        graph[5].add(new Edge( 5,  3));
        graph[5].add(new Edge( 5,  4));
        graph[5].add(new Edge( 5,  6));

        graph[6].add(new Edge( 6,  5));


    }
    
    public static void bfs(ArrayList<Edge> graph[],int v,boolean visited[],int start){
        Queue<Integer> que = new LinkedList<>();
        
        que.add(start);
        visited[0] = true;
        while (!que.isEmpty()) {
            int curr = que.remove();
            System.out.print(curr + ",");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!visited[e.dest]) {
                    que.add(e.dest);
                    visited[e.dest] = true;
                }
            }
        }
        
    }


    public static void dfs(ArrayList<Edge> graph[],int curr,boolean visited[]){
            System.out.print(curr +" ");
            visited[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (visited[e.dest] == false) {
                    dfs(graph, e.dest, visited);
                }
            }
    }

    public static void printAllPath(ArrayList<Edge> graph[],boolean visited[],int target , String path,int curr){
        if (curr == target) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                visited[curr] = true;
                printAllPath(graph, visited, target, path+e.dest, e.dest);
                visited[curr] = false;
            }
        }
    }

    
    public static void main(String[] args) {
        int v = 7;
        boolean visited[] = new boolean[v];
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        // for(int i = 0; i<v;i++){
        //     if (!visited[i]) {
        //         bfs(graph, v,visited,i);
        //     }
        // }
      
    //   dfs(graph, 0, visited);
     printAllPath(graph, visited, 5, "0", 0);
    }
}
