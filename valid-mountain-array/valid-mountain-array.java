class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        boolean peak = false;
        for(int i=1; i<arr.length-1; i++){
            if(arr[i-1]<arr[i] && arr[i]<arr[i+1] ){
                continue;
            }
            else if(arr[i]>arr[i+1] && arr[i-1]<arr[i]){
                peak = true;
            }
            else if(arr[i-1]>arr[i] && arr[i]>arr[i+1] ){
                continue;
            }
            else{
                return false;
            }
        }
        return peak;
    }
}