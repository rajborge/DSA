/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,TreeNode> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                if(node.left!=null){
                    map.put(node.left.val,node);
                    q.offer(node.left);
                }
                if(node.right!=null){
                    map.put(node.right.val,node);
                    q.offer(node.right);
                }
            }
        }

        Set<Integer> visited=new HashSet<>();
        q.offer(target);
        while(k>0 && !q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                visited.add(node.val);

                if(node.left!=null && !visited.contains(node.left.val)){
                    q.offer(node.left);
                }
                if(node.right!=null && !visited.contains(node.right.val)){
                    q.offer(node.right);
                }
                if(map.containsKey(node.val)){
                    TreeNode parentNode=map.get(node.val);

                    if(!visited.contains(parentNode.val)){
                        visited.add(parentNode.val);
                        q.offer(parentNode);
                    }
                }
            }
            k--;
        }
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }
}