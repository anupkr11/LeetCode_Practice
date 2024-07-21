class Solution {
    public boolean isToeplitzMatrix(final int[][] matrix) {
        int i = matrix.length - 1, j = 0;

        while(j < matrix[0].length) {
            int curr = matrix[i][j];

            for(int y = i, x = j; y < matrix.length && x < matrix[0].length; y++) {
                if(matrix[y][x] != curr)
                    return false;

                x++;
            }

            if(i == 0)
                ++j;

            if(i != 0)
                --i;
        }

        return true;
    }
}