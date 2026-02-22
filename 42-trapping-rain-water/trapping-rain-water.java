class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int maxL[] = new int[height.length]; 
        maxL[0] = height[0];
        for(int i=1;i<height.length;i++){
            maxL[i] = Math.max(height[i], maxL[i-1]);
        }

        int maxR[] = new int[height.length];
        maxR[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            maxR[i] = Math.max(height[i], maxR[i+1]);
        }
        for(int i=0;i<height.length;i++){
            int water = (Math.min(maxL[i],maxR[i])-height[i]);
            ans += water <0 ? 0 : water;
        }
        return ans;
    }
}