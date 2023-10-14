class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int right = nums[n - 1] - nums[0];
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int slow = 0;
            for (int fast = 0; fast < n; fast++) {
                while (nums[fast] - nums[slow] > mid) slow++;
                count += fast - slow;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private int helper(int[] nums, int start, int value) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > value) return i;
        }
        return nums.length;
    }
}