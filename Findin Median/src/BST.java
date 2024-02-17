import java.util.ArrayList;
import java.util.Scanner;

public class BST {

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;
    ArrayList<Integer> savingData = new ArrayList<>();
    int index = 0;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    int count(Node root) {
        if (root == null)
            return 0;
        else
            return (1 + count(root.left) + count(root.right));
    }

    ArrayList<Integer> inorder() {
         return inorderRec(root);
    }

    ArrayList<Integer> inorderRec(Node root) {

        if (root != null) {
            inorderRec(root.left);
            // System.out.println(root.key);
            savingData.add(root.key);
            inorderRec(root.right);
        }
        return savingData;
    }

    public double findMedian(ArrayList<Integer> arr, int size) {
        if (size % 2 != 0)
            return arr.get(size / 2);
        return (arr.get((size - 1) / 2) + arr.get(size / 2)) / 2.0;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int data;

        for (int i = 0; i < n; i++) {
            data = scanner.nextInt();
            tree.insert(data);
        }

        // int[] res = tree.inorder();
        // System.out.println(tree.inorder());
        ArrayList<Integer> res = tree.inorder();
        /*for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }*/
       // tree.inorder();
        System.out.println(tree.findMedian(res , res.size()));
    }
}