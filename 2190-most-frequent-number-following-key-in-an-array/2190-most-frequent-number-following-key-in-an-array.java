class Solution {
    public int mostFrequent(int[] nums, int key) {
        int[] count = new int[1001];
        int max = -1, ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                count[nums[i + 1]]++;
                if (count[nums[i + 1]] > max) {
                    ans = nums[i + 1];
                    max = count[nums[i + 1]];
                }
            }
        }
        return ans;
    }
}