class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int end=s.length();
        for(int i=end-1;i>=0;i--){
            if(s.charAt(i)==' '){
                return end-1-i;
            }
        }
        return end;
    }
}