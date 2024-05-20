class Solution {
    int total=0;
    public int subsetXORSum(int[] nums) {
        subset(nums,0,0,nums.length);
        return total;
    }
    public void subset(int[] arr,int prev_xor,int start,int len){
        for(int i=start;i<len;i++){
            int temp=prev_xor^arr[i];
            total+=temp;
            //System.out.println(prev_xor+" "+total);
            subset(arr,temp,i+1,len);
        }

    }
}