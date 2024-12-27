import java.util.LinkedList;
import java.util.Queue;

public class btree {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class Binary {
        static int idx = -1;

        public static Node Binarytree(int nodes[]) {

            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newnode = new Node(nodes[idx]);

            newnode.left = Binarytree(nodes);
            newnode.right = Binarytree(nodes);

            return newnode;
        }

    }

    public static void preorder(Node root) {
        if (root == null) {
            // System.out.print("-1" + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            System.out.print("-1" + " ");
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static void postorder(Node root) {
        if (root == null) {
            System.out.print("-1" + " ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelorder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int calcnode(Node root) {

        if (root == null) {
            return 0;
        }
        int left = calcnode(root.left);
        int right = calcnode(root.right);

        return left + right + 1;
    }

    public static int sumNode(Node root) {
        if (root == null) {
            return 0;
        }
        int left = sumNode(root.left);
        int right = sumNode(root.right);
        return left + right + root.data;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int myheight = Math.max(left, right) + 1;
        return myheight;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    /**
     * Innerbtree
     */
    public static class Innerbtree {

        int ht;
        int diam;

        Innerbtree(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static Innerbtree treeinfo(Node root) {
        if (root == null) {
            return new Innerbtree(0, 0);
        }

        Innerbtree left = treeinfo(root.left);
        Innerbtree right = treeinfo(root.right);

        int myheight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        Innerbtree treeinfor = new Innerbtree(myheight, mydiam);
        return treeinfor;

    }
    

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Binary b = new Binary();
        Node root = b.Binarytree(nodes);
        // System.out.println(root.data);
        // levelorder(root);
        // System.out.println(height(root));
        preorder(root);

    }
}