/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let mini = Infinity;
    let maxProfit = 0;
    for(let p of prices){
        if(p<mini){
            mini =p;
        }
        let profit = p-mini;
        maxProfit = Math.max(maxProfit, profit);
    }
    return maxProfit;
};