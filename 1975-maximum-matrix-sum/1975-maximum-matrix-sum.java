class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int numNegatives = 0; 
        int smallestAbsValue = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value); 
                
                if (value < 0) {
                    numNegatives++;
                }
                smallestAbsValue = Math.min(smallestAbsValue, Math.abs(value));
            }
        }
        if (numNegatives % 2 == 1) {
            totalSum -= 2L * smallestAbsValue; 
        }
        
        return totalSum;
    }
}