// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         for(int i = 0;i<nums.length;i++)
//         {
//             nums[i] *= nums[i];
//         }
//         Arrays.sort(nums);
//         return nums;
//     }
// }

class Solution{
    public int[] sortedSquares(int[] nums){
        
        int idx = nums.length;
        for(int i=0 ;i<nums.length; i++){
            if(nums[i]>=0){
                idx = i;
                break;
            }
        }
        int left =idx-1, right=idx;
        int[] arr = new int[nums.length];
        int k=0;
        while(left>=0 && right<nums.length){
            nums[left] = Math.abs(nums[left]);
            if(nums[left]>nums[right]){
                arr[k++] = nums[right]*nums[right];
                right++;
            }
            else{
                arr[k++] = nums[left]*nums[left];
                left--;
            }
        }
        while(left>=0){
            arr[k++]=nums[left]*nums[left];
            left--;
        }
        while(right<nums.length){
            arr[k++]=nums[right]*nums[right];
            right++;
        }
        return arr;
    }
}