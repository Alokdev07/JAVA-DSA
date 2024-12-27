import java.util.LinkedList;
import java.util.Queue;

public class btreepractice {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class Binarytree {
        static int idx = -1;

        public static Node binarytree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node RootNode = new Node(nodes[idx]);
            RootNode.left = binarytree(nodes);
            RootNode.right = binarytree(nodes);

            return RootNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                System.out.print("-1" + " ");
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

        public static void Levelorder(Node root) {
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
                }

                else {
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
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);

        return left + right + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);

        return left + right + root.data;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static int diameter(Node root) {
        if (root == null) {
            return -1; // simply break out height function do things
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myheight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myinfo = new TreeInfo(myheight, mydiam);
        return myinfo;

    }

    public boolean isidentical(Node root, Node subroot) {
        if (root == null && subroot == null   ) {
            return true;
        }
        if (root == null || subroot == null) {
            return false;
        }
        if (root.data == subroot.data) {
            return isidentical(root.left, subroot.left) && isidentical(root.right, subroot.right);
        }
        return false;
    }

    public boolean isSubtree(Node root, Node subroot){
        if (root == null) {
            return false;
        }
        if (subroot == null) {
            return true;
        }
        
        if (root.data == subroot.data) {
            return isidentical(root, subroot);
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Binarytree tree = new Binarytree();
        Node root = tree.binarytree(nodes);
        tree.Levelorder(root);
        // System.out.println(countOfNodes(root));
        // System.out.println(sumOfNodes(root));
        // System.out.println(height(root));
        System.out.println(diameter2(root).diam);
    }
}
