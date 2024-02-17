import java.util.*;

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
}

class Node {
    double key, height;
    Node left, right;

    Node(double d) {
        key = d;
        height = 1;
    }
}

class AVLTree {

    Node root;

    double height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    int max(double a, double b) {
        return (int) ((a > b) ? a : b);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    double getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, double key) {

        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        double balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    List<Double> inOrder(Node node, List<Double> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.key);
            inOrder(node.right, list);
        }
        return list;
    }

    void inOrder2(Node node) {
        if (node != null) {
            inOrder2(node.left);
            System.out.print(node.key + " ");
            inOrder2(node.right);
        }
    }

    List<Double> printGivenLevel(Node root, int level, List<Double> list) {
        if (root == null)
            return list;
        if (level == 1)
            list.add(root.key);
        else if (level > 1) {
            printGivenLevel(root.left, level - 1, list);
            printGivenLevel(root.right, level - 1, list);
        }
        return list;
    }
}

public class RangeTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree avlTree = new AVLTree();

        List<Double> X_List = new ArrayList<>();
        List<Double> Y_List = new ArrayList<>();

        int countOfInput = scanner.nextInt();

        double X;
        double Y;

        for (int i = 0; i < countOfInput; ++i) {
            X = scanner.nextDouble();
            X_List.add(X);
        }

        Node node = null;
        int midDle_NODE_Pos_X = countOfInput / 2;
        double root_X = X_List.get(midDle_NODE_Pos_X);
        node = avlTree.insert(node, root_X);
        for (int j = 0; j < countOfInput; ++j) {
            node = avlTree.insert(node, X_List.get(j));
        }

        for (int i = 0; i < countOfInput; ++i) {
            Y = scanner.nextDouble();
            Y_List.add(Y);
        }

        Node node2 = null;
        int midDle_NODE_Pos_Y = countOfInput / 2;
        double root_Y = Y_List.get(midDle_NODE_Pos_Y);
        node2 = avlTree.insert(node2, root_Y);
        for (int j = 0; j < countOfInput; ++j) {
            node2 = avlTree.insert(node2, Y_List.get(j));
        }

        double input_counter = scanner.nextDouble();

        double size = input_counter * 4.0;
        double[] crd = new double[(int) size];

        double coordinate;
        for (int k = 0; k < size; ++k) {
            coordinate = scanner.nextDouble();
            crd[k] = coordinate;
        }

        List<Double> xarray = new ArrayList<>();
        List<Double> yarray = new ArrayList<>();

        avlTree.inOrder(node, xarray);
        avlTree.inOrder(node2, yarray);

        double y2, x2, y1, x1;
        boolean flag = false;

        HashMap<Double , Double> hm = new HashMap<Double, Double>();

        for (int l = 0; l < size; l += 4) {
            x1 = crd[l];
            y1 = crd[l + 1];
            x2 = crd[l + 2];
            y2 = crd[l + 3];

            for (int i = 0; i < X_List.size(); i++) {
                if (X_List.get(i) > x1 && X_List.get(i) <= x2) {
                    if (Y_List.get(i) > y1 && Y_List.get(i) <= y2) {
                        System.out.print(X_List.get(i) + " ");
                        /*hm.put(X_List.get(i) , Y_List.get(i));
                        avlTree.sortByValue(hm);
                        System.out.print(hm.toString());*/
                    }
                } else
                    flag = true;
            }
            System.out.println();

            for (int i = 0; i < Y_List.size(); i++) {
                if (Y_List.get(i) > y1 && Y_List.get(i) <= y2) {
                    if (X_List.get(i) > x1 && X_List.get(i) <= x2) {
                         System.out.print(Y_List.get(i) + " ");
                        /*hm.put(Y_List.get(i) , X_List.get(i));*/
                    }
                } else
                    flag = true;
            }
            System.out.println();

        }

        if (flag)
            System.out.println("None");
    }
}
