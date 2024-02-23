class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1 << 30;
        int[][] dp = new int[k + 2][n];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        
        dp[0][src] = 0;
        
        for (int i = 1; i <= k + 1; ++i) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + price);
            }
        }
        
        int result = INF;
        for (int i = 1; i <= k + 1; ++i) {
            result = Math.min(result, dp[i][dst]);
        }
        
        return (result == INF) ? -1 : result;
    }
}