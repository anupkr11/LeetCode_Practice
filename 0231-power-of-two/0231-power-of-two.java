class Solution {
    public boolean isPowerOfTwo(int n) {
        // for(int i=0;i<n;i++){
        //     if(n==Math.pow(2,i)){
        //         return true;
        //     }
        // }
        // return false;
        if(n==1){
            return true;
        }
        if(n<1){
            return false;
        }
        while(n>1){
            if(n%2!=0){
                return false;
            }
            n=n/2;
        }
        return true;
    }
}