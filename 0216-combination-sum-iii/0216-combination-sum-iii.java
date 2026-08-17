class Solution {
    public void calculateSum(int sum,int last,int k,List<List<Integer>> ans,List<Integer> list){
        if(sum==0 && list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum<0 && list.size()>k) return;
        for(int i=last;i<=9;i++){
            if(i<=sum){
                list.add(i);
                calculateSum(sum-i,i+1,k,ans,list);
                list.remove(list.size()-1);
            }
            else{
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        calculateSum(n,1,k,ans,list);
        return ans;
    }
}