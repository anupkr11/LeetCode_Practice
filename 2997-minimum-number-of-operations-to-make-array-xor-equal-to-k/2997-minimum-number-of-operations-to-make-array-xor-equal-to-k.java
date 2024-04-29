class Solution {
    public int minOperations(int[] nums, int k) {
        int xor_result = nums[0]  ; 
        int flip = 0;
        for(int i = 1; i < nums.length ; i++){
            xor_result ^= nums[i];
        }
        while(xor_result != 0 || k != 0){
            if((xor_result&1) != 1){
                if((k&1) == 1){
                    flip++;
                }
            }
            if((xor_result&1) != 0){
                if((k&1) == 0){
                    flip++;
                }
            }
            xor_result >>= 1;
            k >>= 1;
        }
        return flip;
    }
}