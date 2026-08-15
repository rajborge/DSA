class Solution {
    public void findCombinations(int index,int target,int[] arr,List<List<Integer>> ans,List<Integer> list){
        if(index==arr.length){
            if (target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[index]<=target){
            list.add(arr[index]);
            findCombinations(index,target-arr[index],arr,ans,list);
            list.remove(list.size()-1);
        }
        findCombinations(index+1,target,arr,ans,list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        findCombinations(0,target,candidates,ans,list);
        return ans;
    }
}