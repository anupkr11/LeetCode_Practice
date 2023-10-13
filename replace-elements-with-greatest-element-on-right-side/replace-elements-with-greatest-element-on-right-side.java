// class Solution {
//     public int[] replaceElements(int[] arr) {
//         for(int i=0; i<arr.length; i++){
//             for(int j=i+1; j<arr.length; j++){
//                 if(arr[i]<arr[j]){
//                     arr[i]=arr[j];
//                 }
//             }
//         }
//     }
// }
class Solution {
    public int[] replaceElements(int[] arr) {
        int max=-1;
        int length=arr.length;
        int[] nums= new int[length];

        for(int i = length-1 ; i >= 0; i--){
            nums[i]= max;
            if(arr[i]>=max){
                max=arr[i];
            }
        }
        return nums;
    }
}