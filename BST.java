public class BST {

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

        BST tree = new BST();

        int[] nums = {5, 8, 2, 6, 1, 9, 3, 0, 4, 7};

        for (int x : nums)
            tree.insert(x);

        tree.display();

        System.out.println("Balanced: " + tree.balance());
    }
}