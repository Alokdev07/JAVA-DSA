import java.util.ArrayList;

public class BST {
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
  static class Bst{
    public static Node constructBst(Node root,int val){
    if (root == null) {
        root = new Node(val);
        return root;
    }
    if (root.data > val) {
        root.left = constructBst(root.left, val);
    }else{
        root.right= constructBst(root.right, val);
    }
    return root;
  }
}
public static void inorder(Node root){
    if (root == null) {
        return;
    }
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
}
public static boolean search(Node root,int key){
    if (root.data == key) {
        return true;
    }
    if (root.data > key) {
        return search(root.left, key);
    }
    else{
        return search(root.right, key);
    }
   
}
public static Node delete(Node root,int element){
    if (root.data > element) {
        root.left = delete(root.left, element);
    }
    else if (root.data < element) {
        root.right = delete(root.right, element);
    }
    else{ //root.element == val

        //case-1
        if (root.left == null && root.right == null) {
            return null;
        }
        //case-2
        if (root.left == null) {    //in update the pointers to update child node where right is null update as child left vise versa0.
            return root.right;
        }
        else if(root.right == null) {
            return root.left;
        }
        //case-3
        Node IS = inorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, IS.data);
    }
    return root;
}
public static Node inorderSuccessor(Node root){
    while (root.left != null) {
        root = root.left;
    }
    return root;
}
public static void PrintInRange(Node root,int x,int y){
    if (root == null) {
        return;
    }
    if (root.data >= x && root.data <= y) {
        PrintInRange(root.left, x, y);
        System.out.print(root.data + " ");
        PrintInRange(root.right, x, y);
    }
    else if (root.data < x) {
        PrintInRange(root.right, x, y);
    }
    else {
        PrintInRange(root.left, x, y);
    }
}

public static void printpath(ArrayList<Integer> path){
    for(int i = 0; i<path.size(); i++ ) {
        System.out.print(path.get(i) + "->");
    }
}
public static void printToLeaf(Node root,ArrayList<Integer> path){
    if (root ==  null) {
        return;
    }
    path.add(root.data);
    //leaf Node
    if (root.left == null && root.right == null) {
        printpath(path);
        System.out.println();
    }
    printToLeaf(root.left, path);
    printToLeaf(root.right, path);
    path.remove(path.size()-1);
}
    public static void main(String[] args) {
        int values[] = {8,5,3,1,6,4,10,11,14};
        Node root = null;
        Bst tree = new Bst();
        for(int i = 0; i<values.length; i++){
           root = tree.constructBst(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // delete(root, 4);
        // PrintInRange(root, 4, 10);
        printToLeaf(root, new ArrayList<>());
        
    }
}
