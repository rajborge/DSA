class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int ans=0;

        for(char ch:s.toCharArray()){
            if(ch=='(') depth++;
            else if(ch==')') depth--;
            ans=Math.max(ans,depth);
        }
        return ans;
    }
}