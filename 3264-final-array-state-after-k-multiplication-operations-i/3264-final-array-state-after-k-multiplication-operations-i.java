class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(k == 0){
            return nums;
        }

        int minEle = nums[0], j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < minEle){
                j=i;
                minEle = nums[i];
            }
        }
        nums[j]*=multiplier;
        return getFinalState(nums,k-1,multiplier);
    }
}