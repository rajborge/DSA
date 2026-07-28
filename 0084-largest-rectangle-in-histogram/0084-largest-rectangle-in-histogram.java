class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] pse=new int[n];
        int[] nse=new int[n];
        Deque<Integer> st=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int el=st.pop();
                nse[el]=i;
                pse[el]=!st.isEmpty()?st.peek():-1;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
                int el=st.pop();
                nse[el]=n;
                pse[el]=!st.isEmpty()?st.peek():-1;
            }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
        int width = nse[i] - pse[i] - 1;
        int area = width * heights[i];
        maxArea = Math.max(maxArea, area);
    }

    return maxArea;

    }
    
}