class Solution {
    public String largestOddNumber(String num) {
        int end=-1;
        int i;
        for(i=num.length()-1;i>=0;i--){
            if((num.charAt(i)-'0')%2==1){
                end=i;
                break;
            }
        }
        if(end==-1) return "";
        i=0;
        while(i<=end && num.charAt(i)==0){
            i++;
        }
        return num.substring(i,end+1);
    }
}