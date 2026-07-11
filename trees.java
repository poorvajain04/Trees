import java.util.Scanner;

public class trees {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int value) {
            this.val = value;
        }
    }

    Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter a value:");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to add value to left of: " + node.val);
        boolean l = scanner.nextBoolean();

        if (l) {
            System.out.println("Enter the value:");
            int v = scanner.nextInt();
            node.left = new Node(v);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to add value to right of: " + node.val);
        boolean r = scanner.nextBoolean();

        if (r) {
            System.out.println("Enter the value:");
            int k = scanner.nextInt();
            node.right = new Node(k);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        trees tree = new trees();
        tree.populate(scanner);

        System.out.println("\nTree:");
        tree.display();

        scanner.close();
    }
}