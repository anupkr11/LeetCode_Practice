class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long prefixSum[] = new long[nums.length];
        prefixSum[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += nums[i - 1] + prefixSum[i - 1];
        }

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < prefixSum[i]) {
                return nums[i] + prefixSum[i];
            }
        }

        return -1;
    }
}