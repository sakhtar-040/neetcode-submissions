class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int i=0;
        int j=heights.length-1;

        while(i < j) {
            if(heights[i]<heights[j]) {
                area = Math.max(area, heights[i]*(j-i));
                i++;
            } else {
                area = Math.max(area, heights[j]*(j-i));
                j--;
            }
        }
        return area;
    }
}
