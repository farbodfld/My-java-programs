import java.util.Random;

import java.util.Scanner;


class BSTNodes {
    BSTNodes left, right;
    int data;
    int height;
    boolean detector = true;

    public BSTNodes() {
        left = null;
        right = null;
        data = 0;
    }

    public BSTNodes(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }

    public void setLeft(BSTNodes n) {
        left = n;
    }

    public void setRight(BSTNodes n) {
        right = n;
    }

    public BSTNodes getLeft() {
        return left;
    }

    public BSTNodes getRight() {
        return right;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}

class BST {
    private BSTNodes root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private BSTNodes insert(BSTNodes node, int data) {
            if (node == null)
                node = new BSTNodes(data);
            else {
                if (data <= node.getData())
                    node.left = insert(node.left, data);
                else
                    node.right = insert(node.right, data);
            }
        return node;
    }

    public void delete(int k) {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    private BSTNodes delete(BSTNodes root, int k) {
        BSTNodes p, p2, n;
        if (root.getData() == k) {
            BSTNodes lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;

            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BSTNodes r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(BSTNodes r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(BSTNodes r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(BSTNodes r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public void postorder() {
        postorder(root);
    }


    private void postorder(BSTNodes r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }
}


public class Range_Tree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BST bst = new BST();

        System.out

                .println("Range Tree in One Dimensional points(Binary Search Tree)\n");

        Random random = new Random();

        int N = 10;

        for (int i = 0; i < N; i++)

            bst.insert(Math.abs(random.nextInt(100)));


        char ch;

        do {

            System.out.print("Operations\n");

            System.out.println("1. Print Tree ");

            System.out.println("2. Delete");

            System.out.println("3. Search");

            System.out.println("4. Count Nodes");

            System.out.println("5. Check Empty");


            int choice = scan.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("\nPost order : ");

                    bst.postorder();

                    System.out.print("\nPre order  : ");

                    bst.preorder();

                    System.out.print("\nIn order   : ");

                    bst.inorder();

                    break;

                case 2:

                    System.out.println("Enter integer element to delete");

                    bst.delete(scan.nextInt());

                    break;

                case 3:

                    System.out.println("Enter integer element to search");

                    System.out.println("Search result : "

                            + bst.search(scan.nextInt()));

                    break;

                case 4:

                    System.out.println("Nodes = " + bst.countNodes());

                    break;

                case 5:

                    System.out.println("Empty status = " + bst.isEmpty());

                    break;

                default:

                    System.out.println("Wrong Entry \n ");

                    break;

            }


            System.out.println("\nDo you want to continue (Type y or n) \n");

            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

        scan.close();

    }

}