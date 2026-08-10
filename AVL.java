public class AVL {

    class node {
        int val;
        node left;
        node right;
        int height;

        node(int value) {
            val = value;
        }
    }

    private node root;

    public int height(node n) {
        if (n == null)
            return -1;
        return n.height;
    }

    public boolean isEmpty() {
        return root == null;
    }
    public node rightRotate(node p){
        node c=p.left;
        node t=p.right;
        c.right=t;
        p.left=c;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return c;
    }
    public node leftRotate(node c){
        node p=c.right;
        node t=p.left;
        c.right=t;
        p.left=c;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return p;
    }
    public void insert(int value) {
        root = insert(value, root);
    }

    private node insert(int value, node n) {

        if (n == null)
            return new node(value);

        if (value < n.val)
            n.left = insert(value, n.left);

        else if (value > n.val)
            n.right = insert(value, n.right);

        n.height = Math.max(height(n.left), height(n.right)) + 1;

        return rotate(n);
    }
    private node rotate (node n){
        if(height(n.left)-height(n.right)>1){
            // left heavy
            if(height(n.left.left) - height(n.left.right)>0){
                //left left
                return rightRotate(n);
            }
            if(height(n.left.left) - height(n.left.right)<0){
                //left right
                n.left=leftRotate(n.left);
                return rightRotate(n);
            }
        }
        else if(height(n.right)-height(n.left)>1){
            // right heavy
            if(height(n.right.right) - height(n.right.left)>0){
                //right right
                return leftRotate(n);
            }
            if(height(n.right.right) - height(n.right.left)<0){
                //right left
                n.right=rightRotate(n.right);
                return leftRotate(n);
            }
        }
        return n;
    }
    public boolean balance() {
        return balance(root);
    }

    private boolean balance(node n) {

        if (n == null)
            return true;

        return Math.abs(height(n.left) - height(n.right)) <= 1
                && balance(n.left)
                && balance(n.right);
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(node n, String details) {

        if (n == null)
            return;

        System.out.println(details + n.val);

        display(n.left, "Left child of " + n.val + ": ");
        display(n.right, "Right child of " + n.val + ": ");
    }

    public static void main(String[] args) {

        AVL tree = new AVL();

        int[] nums = {5, 8, 2, 6, 1, 9, 3, 0, 4, 7};

        for (int x : nums)
            tree.insert(x);

        tree.display();

        System.out.println("Balanced: " + tree.balance());
    }
}