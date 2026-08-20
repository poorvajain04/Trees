/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> res=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        pre_order(root);
        return res;
    }
    public void pre_order(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        pre_order(root.left);
        pre_order(root.right);
    }
}