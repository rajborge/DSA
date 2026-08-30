class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;
        int maxFreq=0;
        int i=0;

        for(int j=0;j<s.length();j++){
            char right=s.charAt(j);
            map.put(right,map.getOrDefault(right,0)+1);
            maxFreq=Math.max(maxFreq,map.get(right));

            while((j-i+1)-maxFreq>k){
                char left=s.charAt(i);
                map.put(left,map.get(left)-1);
                i++;
            }
            maxLength=Math.max(maxLength,j-i+1);
        }
        return maxLength;
    }
}