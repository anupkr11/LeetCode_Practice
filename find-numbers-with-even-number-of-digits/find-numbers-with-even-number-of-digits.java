class Solution {
    public int findNumbers(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
          int  cnt=0;
            while (nums[i]>0){
                cnt++;
                nums[i]=nums[i]/10;
            }
            if(cnt%2==0){
                count++;
            }
        }
        return count;
    }
}