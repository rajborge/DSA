class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result=new StringBuilder();
        Arrays.sort(strs);

        String first=strs[0];
        String last=strs[strs.length-1];
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                return result.toString();
            }
            result.append(first.charAt(i));
        }
        return result.toString();
    }
}