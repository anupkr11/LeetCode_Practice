class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if(flowerbed.length==1)
            if(n==0 || (n==1 && flowerbed[0]==0))
                return true;
            else
                return false;
        for(int i=0;i<flowerbed.length;i++){
            if(i==0 ){
                if(flowerbed[i]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                count++;
                continue;
                }
            }
            else if(i==flowerbed.length-1 ){
                if(flowerbed[i]==0 && flowerbed[i-1]==0){
                flowerbed[i]=1;
                count++;
                continue;
                }
            }
            else if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                count++;continue;
            }
        }
        if(count>=n){
            return true;
        }
        else{
            return false;
        }
    }
}