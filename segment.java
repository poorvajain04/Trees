public class segment {

    private static class Node {
        int startInterval;
        int endInterval;
        int value;

        Node left;
        Node right;

        Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    // Constructor
    public segment(int[] arr) {
        root = constructTree(arr, 0, arr.length - 1);
    }

    // Build Segment Tree
    private Node constructTree(int[] arr, int start, int end) {

        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.value = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.value = node.left.value + node.right.value;

        return node;
    }

    // Query range sum [qStart, qEnd]
    public int query(int qStart, int qEnd) {
        return query(root, qStart, qEnd);
    }

    private int query(Node node, int qStart, int qEnd) {

        // Completely outside
        if (node.endInterval < qStart || node.startInterval > qEnd) {
            return 0;
        }

        // Completely inside
        if (node.startInterval >= qStart &&
                node.endInterval <= qEnd) {
            return node.value;
        }

        // Partial overlap
        int left = query(node.left, qStart, qEnd);
        int right = query(node.right, qStart, qEnd);

        return left + right;
    }

    // Update arr[index] = value
    public void update(int index, int value) {
        update(root, index, value);
    }

    private void update(Node node, int index, int value) {

        // Leaf node
        if (node.startInterval == node.endInterval) {
            node.value = value;
            return;
        }

        int mid = (node.startInterval + node.endInterval) / 2;

        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }

        // Recalculate current node
        node.value = node.left.value + node.right.value;
    }

    // Display tree
    public void display() {
        display(root);
    }

    private void display(Node node) {

        if (node == null) {
            return;
        }

        String str = "";

        if (node.left != null) {
            str += "Interval [" +
                    node.left.startInterval + ", " +
                    node.left.endInterval + "] = " +
                    node.left.value;
        }

        str += " <- [" +
                node.startInterval + ", " +
                node.endInterval + "] = " +
                node.value + " -> ";

        if (node.right != null) {
            str += "Interval [" +
                    node.right.startInterval + ", " +
                    node.right.endInterval + "] = " +
                    node.right.value;
        }

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        segment tree = new segment(arr);

        System.out.println(tree.query(1, 3));
        // 2 + 3 + 4 = 9

        tree.update(2, 10);

        System.out.println(tree.query(1, 3));
        // 2 + 10 + 4 = 16

        tree.display();
    }
}