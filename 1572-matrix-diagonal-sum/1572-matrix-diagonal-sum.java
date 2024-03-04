class Solution {
    public int diagonalSum(int[][] mat) {
        int sum =0;
        int len = mat.length;
        // int mid = mat[len/2][len/2];

        for(int i=0;i<len;i++){
            sum+=mat[i][i];
            if(i!=len-i-1) sum+=mat[i][len-i-1];
        }

        return sum;

    }
}