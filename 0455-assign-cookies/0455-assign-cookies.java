class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex=g.length-1;
        int cookieIndex=s.length-1;

        int count=0;

        while(childIndex>=0 && cookieIndex>=0 ){
            if(s[cookieIndex]>=g[childIndex]){
                count++;
                cookieIndex--;
                childIndex--;
            }
            else{
                childIndex--;
            }
        }
        return count;
    }
}