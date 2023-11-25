class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        int[] result = new int[n];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            
        }

        suffixSum[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++){
            suffixSum[n - i - 1] = suffixSum[n - i] + nums[n - i - 1];
        }
        
        
        for(int i = 0; i < n; i++){
            int num = nums[i];
            result[i] = (suffixSum[i] - prefixSum[i] - num * (n-2*i));
        }
        return result;
    }
}