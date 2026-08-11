class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int sum=0;

        for(int i=0;i<n;i++){
            Map<Character,Integer> freq=new HashMap<>();
            for(int j=i;j<n;j++){
                freq.put(s.charAt(j),freq.getOrDefault(s.charAt(j),0)+1);

                int maximum=Integer.MIN_VALUE;
                int minimum=Integer.MAX_VALUE;

                for(int val:freq.values()){
                    minimum=Math.min(minimum,val);
                    maximum=Math.max(maximum,val);
                }
                sum+=(maximum-minimum);
            }
        }
        return sum;
    }
}