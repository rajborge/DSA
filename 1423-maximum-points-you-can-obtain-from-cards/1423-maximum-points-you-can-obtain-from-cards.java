class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0;
        int rightSum=0;
        int maxSum=0;

        for(int left=0;left<k;left++){
            leftSum+=cardPoints[left];
            maxSum=leftSum;
        }

        int right=cardPoints.length-1;
        for(int left=k-1;left>=0;left--){
            leftSum-=cardPoints[left];
            rightSum+=cardPoints[right];
            right--;
            maxSum=Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }
}