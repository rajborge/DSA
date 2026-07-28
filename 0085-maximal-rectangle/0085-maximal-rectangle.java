class Solution {
    public int largestRectangleArea(int[] heights){
        Deque<Integer> stack=new ArrayDeque<>();
        int maxArea=0;

        for(int i=0;i<=heights.length;i++){
            while(!stack.isEmpty() && (i==heights.length || heights[stack.peek()]>heights[i])){
                int height=heights[stack.pop()];
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;

        int m=matrix[0].length;
        int[] height=new int[m];

        int maxArea=0;

        for(char[] row:matrix){
            for(int i=0;i<m;i++){
                if(row[i]=='1') height[i]++;
                else height[i]=0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        return maxArea;
    }
}