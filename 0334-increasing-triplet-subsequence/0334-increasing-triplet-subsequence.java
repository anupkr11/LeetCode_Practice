class Solution {
    public boolean increasingTriplet(int[] nums) {
        int l= Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length;i++){
            if(nums[i]>r){
                return true;
            }
            else if(nums[i]>l && nums[i]<r){
                r=nums[i];
            }
            else if(nums[i]<l){
                l=nums[i];
            }
        }
        return false;
    }
}