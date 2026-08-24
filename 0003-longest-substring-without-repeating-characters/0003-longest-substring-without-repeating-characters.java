class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxLength=0;

        Map<Character,Integer> map=new HashMap<>();

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(map.containsKey(c) && map.get(c)>=left){
                left=map.get(c)+1;
            }
            maxLength=Math.max(maxLength,right-left+1);
            map.put(c,right);
        }
        return maxLength;
    }
}