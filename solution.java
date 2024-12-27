public class solution {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    static class Tree {
        
        // static int jdx = -1;

        public static TreeNode Binarytree(int nodes[],int[] idx) {
            idx[0]++;
            if (nodes[idx[0]] == -1) {
                return null;
            }
            TreeNode currnode = new TreeNode(nodes[idx[0]]);
            currnode.left = Binarytree(nodes,idx);
            currnode.right = Binarytree(nodes,idx);
            return currnode;
        }
    

    
        
        // static int jdx = -1;

        public static TreeNode BinarySubtree(int secondnodes[]) {
            int[] idx = {-1};
            return Binarytree(secondnodes, idx);
        }
    }

    public static class Solution {
        public static boolean isidentical(TreeNode root, TreeNode subroot) {
            if (root == null && subroot == null) {
                return true;
            }
            if (root == null || subroot == null) {
                return false;
            }

            if (root.data == subroot.data) {
              return  isidentical(root.left, subroot.left) && isidentical(root.right, subroot.right);
            } 
            return false;
        }

        public static boolean issubtree(TreeNode root, TreeNode subroot) {
            if (subroot == null) {
                return true;
            }
            if (root == null) {
                return false;
            }

            if (root.data == subroot.data) {
                if (isidentical(root, subroot)) {
                    return true;
                }
            }
            return issubtree(root.left, subroot) || issubtree(root.right, subroot);
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int secondnodes[] = { 2,3,4, -1, -1, 5, -1, -1 };
        Tree b = new Tree();
        int []idx = {-1};
        TreeNode root = b.Binarytree(nodes,idx);
        
        TreeNode subroot = b.BinarySubtree(secondnodes);
        // System.out.println(root.data);
        Solution n = new Solution();
        boolean result = n.issubtree(root, subroot);
        System.out.println(result);
    }
}
