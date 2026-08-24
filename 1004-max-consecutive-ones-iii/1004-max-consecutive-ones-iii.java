class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int maxLength=0;
        int countZeroes=0;

        while(right<nums.length){
            if(nums[right]==0) countZeroes++;
            if(countZeroes>k){
                if(nums[left]==0) countZeroes--;
                left++;
            }
            if(countZeroes<=k){
                maxLength=Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }
}