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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        q.offer(new Pair<>(root,0));
        int ans=0;

        while(!q.isEmpty()){
            int levelLength=q.size();
            int min=q.peek().getValue();
            int first=0,last=0;

            for(int i=0;i<levelLength;i++){
                int cur_id=q.peek().getValue()-min;
                TreeNode node=q.peek().getKey();
                q.poll();

                if(i==0) first=cur_id;
                if(i==levelLength-1) last=cur_id;
                if(node.left!=null) q.offer(new Pair<>(node.left,cur_id*2+1));
                if(node.right!=null) q.offer(new Pair<>(node.right,cur_id*2+2));
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}