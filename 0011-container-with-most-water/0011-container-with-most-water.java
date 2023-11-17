class Solution {
    public int maxArea(int[] height) {
        int l1 = 0;
        int l2 = height.length-1;
        int maxWater = 0;
        while(l1<l2){
            int h = Math.min(height[l1], height[l2]);
            int width = l2-l1;
            int area = h*width;
            maxWater = Math.max(maxWater, area);

            if(height[l1]<height[l2]){
                l1++;
            }
            else{
                l2--;
            }
        }
        return maxWater;
    }
}