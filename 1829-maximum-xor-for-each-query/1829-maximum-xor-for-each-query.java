class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int[] ans=new int[n];
        int numBitVal=(int)Math.pow(2, maximumBit)-1;
        
        int xorVal=0;
        for(int i=0; i<n; i++){
            xorVal ^=nums[i];
        }

        int k=0;  
        for(int i=n-1; i>=0; i--){
            ans[k++]=numBitVal^xorVal;
            xorVal ^=nums[i];
        }

        return ans;
    }
}