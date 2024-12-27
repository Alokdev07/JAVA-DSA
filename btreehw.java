import java.util.LinkedList;
import java.util.Queue;

public class btreehw {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

        static class btree{
            static int idx = -1;
            public static Node binarytree(int nodes[]){
                idx++;
                if (nodes[idx] == -1) {
                    return null;
                }
                 Node newNode = new Node(nodes[idx]);
                 newNode.left = binarytree(nodes);
                 newNode.right = binarytree(nodes);

                 return newNode;
                
            }

            public static void sumAtKthLevel(Node root, int k){

                if (root == null) {
                    System.out.println("tree is empty");
                    return;
                }
                int level = 1;
                int sum = 0;
                Queue<Node> q = new LinkedList<Node>();
                q.add(root);
                q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                
                if (currNode == null) {
                    System.out.println();
                    level++;
                    if (level > k) {
                        break;
                    }
                    if (!q.isEmpty()) {
                        q.add(null);
                    }
                }
                    else{
                        if (level == k) {
                            sum += currNode.data;   
                     }
                        System.out.print(currNode.data + " ");
                        if (currNode.left != null) {
                            q.add(currNode.left);
                        }
                        if (currNode.right != null) {
                            q.add(currNode.right);
                        }
                    }
                    
                }
                System.out.println(sum);
            }
            
        }
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        btree tree = new btree();
        Node root = tree.binarytree(nodes);
        
        tree.sumAtKthLevel(root, 2);
        
    }
}
