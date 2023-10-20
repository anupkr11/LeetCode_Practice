class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum = sum + nums[i];
        }
        int maxi = sum;
        if(nums.length==1){
            return (double)maxi;
        }
        int i = 0;
        int j = k;
        while(j<nums.length && nums.length>1){
            sum = sum - nums[i];
            i++;
            sum = sum + nums[j];
            j++;
            maxi = Math.max(maxi,sum);
        }
        return (double)maxi/k;
    }
}