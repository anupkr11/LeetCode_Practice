class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[j][i]==0)
                    continue;
                else{
                    matrix[j][i]+=matrix[j-1][i];
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(maxArea(matrix[i]),ans);
        }
        return ans;
    }
    public int maxArea(int hist[]){
        Arrays.sort(hist);
        int n = hist.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max((n-i)*hist[i],ans);
        }
        return ans;
    }
}