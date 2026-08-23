public class LevelOrderSuccessor {
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }
    public TreeNode successor(TreeNode root,int key){
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level=queue.size();
                TreeNode current=queue.poll();
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
                if(current.val==key){
                    break
                }
        }
        return queue.peek();
    }
}