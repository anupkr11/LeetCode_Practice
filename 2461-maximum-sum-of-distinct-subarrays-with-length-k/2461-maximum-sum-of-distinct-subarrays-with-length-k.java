class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] mp = new int[100001];
        int count = 0;
        long res = 0, sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            if (mp[nums[i]] == 0) {
                count++;
            }
            mp[nums[i]]++;
            
            if (i - j + 1 == k) { 
                if (count == k) {
                    res = Math.max(res, sum);  
                }
                if (mp[nums[j]] == 1) {
                    count--;
                }
                mp[nums[j]]--;
                sum -= nums[j];
                j++;
            }
        }
        return res;
    }
}