class Solution {
    public int numSpecial(int[][] mat) {
        int row  = mat.length;
        int col = mat[0].length;
        int cnt = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int sum = 0;
                if(mat[i][j]==1){
                    for(int k=0;k<row;k++){
                    sum += mat[k][j];
                }
                for(int k=0;k<col;k++){
                    sum+=mat[i][k];
                }
                if(sum == 2){
                    cnt++;
                }
                }
            }
        }
        return cnt;
    }
}
