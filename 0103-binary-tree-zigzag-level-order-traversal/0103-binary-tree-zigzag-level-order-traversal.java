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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();

        if(root==null) return result;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        boolean leftToRight=true;

        while(!q.isEmpty()){
            int size=q.size();
            Integer[] level=new Integer[size];

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                int index=leftToRight?i:size-1-i;
                level[index]=node.val;

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            leftToRight=!leftToRight;

            result.add(Arrays.asList(level));
        }
        return result;
    }
}