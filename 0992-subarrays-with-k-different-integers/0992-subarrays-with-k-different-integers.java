class Solution {
    public int subarraysWithKDistinct(int[] nums, int k){
        return countSubArrays(nums,k)-countSubArrays(nums,k-1);
    }
    public int countSubArrays(int[] nums, int k) {
        int i=0;
        int j=0;
        int res=0;
        HashMap<Integer,Integer> freq=new HashMap<>();
        while(j<nums.length){
            freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
            while (freq.size()>k) {
                freq.put(nums[i], freq.get(nums[i]) - 1);
                if (freq.get(nums[i]) == 0) {
                    freq.remove(nums[i]);
                }
                i++;
            }
        res += (j - i + 1);
        j++;
        }
        return res;  
    }
}