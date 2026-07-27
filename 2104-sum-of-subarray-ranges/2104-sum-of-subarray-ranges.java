class Solution {
    public int[] findNGE(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            ans[i]=!st.isEmpty()?st.peek():n;
            st.push(i);
        }
        return ans;
    }
    public int[] findNSE(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            ans[i]=!st.isEmpty()?st.peek():n;
            st.push(i);
        }
        return ans;
    }
    public int[] findPGEE(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            ans[i]=!st.isEmpty()?st.peek():-1;
            st.push(i);
        }
        return ans;
    }
    public int[] findPSEE(int[] nums){
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            ans[i]=!st.isEmpty()?st.peek():-1;
            st.push(i);
        }
        return ans;
    }
    public long findMin(int[] nums){
        int n=nums.length;
        int[] nse=findNSE(nums);
        int[] psee=findPSEE(nums);
        long sum=0;

        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            long freq=left*right*1L;
            sum+=freq*nums[i];
        }
        return sum;
    }
    public long findMax(int[] nums){
        int n=nums.length;
        int[] nge=findNGE(nums);
        int[] pgee=findPGEE(nums);
        long sum=0;

        for(int i=0;i<n;i++){
            int left=i-pgee[i];
            int right=nge[i]-i;
            long freq=left*right*1L;
            sum+=freq*nums[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return findMax(nums)-findMin(nums);
    }
}