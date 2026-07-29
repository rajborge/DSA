class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();

        int n=nums.length;
        int[] result=new int[n-k+1];
        int index=0;

        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i>=k-1){
                result[index++]=nums[dq.peek()];
            }
        }
        return result;
    }
}