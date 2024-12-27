import java.util.*;

public class btree1 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Binary {
        static int idx = -1;

        public static Node Binarytree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node currNode = new Node(nodes[idx]);
            currNode.left = Binarytree(nodes);
            currNode.right = Binarytree(nodes);

            return currNode;
        }
    }

    public static void levelorder(Node root,int k) {
        if (root == null) {
            return;
        }
        int count = 1;
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);    
        while (!q.isEmpty()) {
            Node firstNode = q.remove();
            if (firstNode == null) {
                count++;
            }
            if (firstNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            }
            else {
                System.out.print(firstNode.data+" ");
                if (firstNode.left != null) {
                    q.add(firstNode.left);
                }
                if (firstNode.right != null) {
                    q.add(firstNode.right);
                }
            }
           
        }   
        
        if (count == k) {
           Node  firstNode = q.remove();
            while (firstNode != null) {
                sum = sum+firstNode.data;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Binary b = new Binary();
        Node root = b.Binarytree(nodes);
        // System.out.println(root.data);
        levelorder(root , k);

    }
}
