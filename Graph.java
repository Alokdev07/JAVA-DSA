import java.util.ArrayList;
// ---> Adjacency list type representation --!>
public class Graph {
    static class Node {
        int src; 
        int dest;
        int weight;


        public Node(int s , int d , int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Node> graph[]){
        for(int i = 0 ; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Node(0, 2,2));

        graph[1].add(new Node(1, 2,10));
        graph[1].add(new Node(1, 3,0));
        
        graph[2].add(new Node(2, 0,2));
        graph[2].add(new Node(2, 1,10));
        graph[2].add(new Node(2, 3,-1));

        graph[3].add(new Node(3, 1,0));
        graph[3].add(new Node(3, 2,-1));
    }

     public static void neighbours(ArrayList<Node> graph[],int n){
        for(int i=0; i<graph[n].size();i++){
            Node e = graph[n].get(i);
            System.out.println(e.dest + "=>" +e.weight);
        }
     }
    public static void main (String [] args){
        int v = 4;
        ArrayList<Node> graph[] = new ArrayList[v];
        createGraph(graph);
        neighbours(graph,1);
    }
}
