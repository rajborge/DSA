class Solution {
    public void getSubsets(int index,int[] nums,List<List<Integer>> result,List<Integer> list){
        result.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            getSubsets(i+1,nums,result,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        getSubsets(0,nums,result,list);
        return result;
    }
}