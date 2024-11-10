class Solution {
    class BitMask{
        int[] bitmask;
        
        int ORvalue(){
            int value = 0;
            for(int i = 30;i>=0;i--){
                value =  value<<1 | (bitmask[i] >= 1 ? 1 : 0);
            }
            return value;
        }

        BitMask(){
            bitmask = new int[31];
        }

        void add(int num){
            int ctr = 0;
            while(num>0){
                int bit = num & 1;
                bitmask[ctr++] += bit  ;
                num = num >> 1;     
            }
        }

        void remove(int num){
            int ctr = 0;
            while(num>0){
                int bit = num & 1;
                if(bit==1 && bitmask[ctr]==0 ) throw new Error("Error while removing "+num);
                bitmask[ctr++] -= bit  ;
                num = num >> 1;
            }
        }

    }
    public int minimumSubarrayLength(int[] nums, int k) {
        if(k==0) return 1 ;
        BitMask bm = new BitMask();
        int n = nums.length;
        int i = 0, j = 0;
        int minWindow = Integer.MAX_VALUE;

        while(j<n){
            bm.add(nums[j++]);
            while(bm.ORvalue()>=k && i<n){
                minWindow = Math.min(minWindow,j-i);
                bm.remove(nums[i++]);
            }   
        }

        return minWindow == Integer.MAX_VALUE ? -1 : minWindow;
    }
}