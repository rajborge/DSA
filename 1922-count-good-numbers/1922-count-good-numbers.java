class Solution {
    public int countGoodNumbers(long n) {
        if(n==1) return 5;
        long even=(n+1)/2;
        long odd=n/2;
        long mod=1000000007;
        return (int)((helper(5,even,mod)*helper(4,odd,mod))%mod);
    }
    public long helper(long base,long pow,long mod){
        long ans=1;
        while(pow>0){
            if(pow%2==0){
                base=(base*base)%mod;
                pow=pow/2;
            }
            else{
                ans=(ans*base)%mod;
                pow-=1;
            }
        }
        return ans;
    }
}