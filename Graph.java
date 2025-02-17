import java.util.ArrayList;

public class Graph {
    static class Node {
        int src; 
        int dest;

        public Node(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Node> graph[]){
        for(int i = 0 ; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Node(0, 2));

        graph[1].add(new Node(1, 2));
        graph[1].add(new Node(1, 3));
        
        graph[2].add(new Node(2, 0));
        graph[2].add(new Node(2, 1));
        graph[2].add(new Node(2, 3));

        graph[3].add(new Node(3, 1));
        graph[3].add(new Node(3, 2));
    }
    public static void main (String [] args){
        int v = 4;
        ArrayList<Node> graph[] = new ArrayList[v];
    }
}
