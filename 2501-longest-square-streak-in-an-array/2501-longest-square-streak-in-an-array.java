class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer>hm=new HashMap<>();
        int max=-1;
        for(int i=nums.length-1;i>=0;i--)
        {
            int ele=nums[i];
            if(hm.containsKey(ele*ele))
            {
                hm.put(ele,hm.get(ele*ele)+1);
            }
            else
            {
                hm.put(ele,1);
            }
            max=Math.max(max,hm.get(ele));
        }
        if(max==1)
        {
            return -1;
        }
        return max;
    }
}