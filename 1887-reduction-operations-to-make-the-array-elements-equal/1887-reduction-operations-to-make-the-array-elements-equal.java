class Solution {
    public int reductionOperations(int[] nums) {
           
           Arrays.sort(nums);
           int ans=0;
           int n=nums.length;
           int prev=nums[n-1];
          
           for(int i=n-1;i>=0;i--)
           {
               if(prev!=nums[i])
               {
                   ans=ans+n-i-1;
                   prev=nums[i];
               }
           }
        return ans;

    }
}