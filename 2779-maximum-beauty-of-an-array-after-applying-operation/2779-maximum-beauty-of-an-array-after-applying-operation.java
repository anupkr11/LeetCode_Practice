class Solution 
{
    public int maximumBeauty(int[] nums, int k) 
    {
        if(nums.length == 1) return 1;

        int max = 0;
        for(int num : nums) max = Math.max(num,max);

        int lineSweepAlgo[] = new int[max+1];

        for(int num : nums)
        {
            lineSweepAlgo[ Math.max(num - k, 0) ]++;
            lineSweepAlgo[ Math.min(num + k + 1, max)]--;
        }

        int currSum = 0;
        int maxBeauty = 0;

        for(int val : lineSweepAlgo)
        {
            currSum += val;
            maxBeauty = Math.max(maxBeauty,currSum);
        }

        return maxBeauty;
    }
}