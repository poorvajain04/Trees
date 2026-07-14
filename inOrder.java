import java.util.*;

public class inOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(15);
        TreeNode n2 = new TreeNode(74);
        TreeNode n3 = new TreeNode(36);
        TreeNode n4 = new TreeNode(5);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        inOrder obj = new inOrder();
        List<Integer> ans = obj.inorderTraversal(root);
        System.out.println(ans);
    }
}