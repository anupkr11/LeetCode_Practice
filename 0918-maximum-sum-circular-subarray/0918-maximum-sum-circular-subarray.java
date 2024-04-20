class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxi1 = Integer.MIN_VALUE;
        int mini = Integer.MIN_VALUE;
        int curr = 0;
        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (curr > maxi1) {
                maxi1 = curr;
            }
            if (curr < 0) {
                curr = 0;
            }
        }
        
        int totsum = 0;
        for(int i = 0; i < nums.length; i++) {
            totsum += nums[i];
        }

        curr = 0;
        for(int i = 0; i <nums.length; i++) {
            curr = curr + (nums[i] * (-1));
            if (curr > mini) mini = curr;
            if(curr < 0) curr = 0;
        }
        
        mini = totsum + mini;
        if (mini==0)
            return maxi1;
        return Math.max(mini, maxi1);
    }
}