class Solution {
    public boolean check(int[] nums) {
        int count = 0, n = nums.length-1;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }
        }
        if(count==1 && nums[0]>=nums[n]){
            return true;
        }
        if(count == 0) return true;
        return false;
    }
}