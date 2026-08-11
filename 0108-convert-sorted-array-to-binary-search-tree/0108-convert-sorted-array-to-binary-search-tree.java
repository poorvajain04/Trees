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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return sortedArrayToBST(nums, 0,nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int beg,int fin){
        if(beg>fin)return null;
        int start=beg;
        int end=fin;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
root.left=sortedArrayToBST(nums,start,mid-1);
root.right=sortedArrayToBST(nums,mid+1,end);
        return root;
    }
}