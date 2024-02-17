public class RT {
    Node root_x , root_y;
    boolean detector = true;

    class Node{
        double data;
        Node right;
        Node left;
        int height;

        public Node(double data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }

    public RT(){
        root_x = root_y = null;
    }

    public Pair <Node,Node> insert(Node x , double data_x , Node y , double data_y){
        if (detector){
            if (x == null){
                x = new Node(data_x);
            }else if (data_x < x.data){
                x.left = insert(x.left , data_x , y , data_y).first;
                if (height(pointX->left) - height(pointX->right) == 2) {
                    if (x < pointX->left->point)
                        pointX = singleRightRotate(pointX);
                    else
                        pointX = doubleRightRotate(pointX);
                }
            }
        }
    }
}
