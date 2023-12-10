class Solution {
    public int[][] transpose(int[][] A) {
        // Get the number of rows and columns in the original matrix
        int m = A.length;
        int n = A[0].length;
        
        // Initialize the transposed matrix with dimensions swapped
        int[][] result = new int[n][m];
        
        // Iterate through each element in the original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Swap the row and column indices to transpose the element
                result[j][i] = A[i][j];
            }
        }
        
        // Return the transposed matrix
        return result;
    }
}
