class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int hashLen=256;

        int[] hash=new int[hashLen];
        Arrays.fill(hash,-1);

        int left=0;
        int right=0;
        int maxLength=0;
        while(right<n){
            if(hash[s.charAt(right)]>=left){
                left=Math.max(hash[s.charAt(right)]+1,left);
            }
            maxLength=Math.max(maxLength,right-left+1);
            hash[s.charAt(right)]=right;
            right++;
        }
        return maxLength;
    }
}