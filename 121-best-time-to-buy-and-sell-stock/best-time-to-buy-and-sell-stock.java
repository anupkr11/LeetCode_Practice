class Solution {
    public int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int maxi= 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<mini){
                mini =prices[i];
            }
            int profit= prices[i]-mini;
            if(profit>maxi){
                maxi =profit;
            }
        }
        return maxi;
    }
}