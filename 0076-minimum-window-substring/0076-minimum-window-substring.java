class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];
        for(char c:t.toCharArray()){
            freq[c]++;
        }
        int left=0;
        int right=0;
        int minStart=0;
        int minLength=Integer.MAX_VALUE;
        int counter=t.length();

        while(right<s.length()){
            char c1=s.charAt(right);
            if(freq[c1]>0) counter--;
            freq[c1]--;
            right++;

            while(counter==0){
                if(minLength>right-left){
                    minLength=right-left;
                    minStart=left;
                }
                char c2=s.charAt(left);
                freq[c2]++;
                if(freq[c2]>0) counter++;
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLength);
    }
}