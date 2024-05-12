class Solution {
    public int[][] largestLocal(int[][] grid) {
        int max;
        int len = grid.length;
        int result[][] = new int[len-2][len-2];
        for(int i = 0; i < len - 2; i++) {
            for(int j = 0; j < len - 2; j++) {
                max = 0;
                for(int x = i; x < i + 3; x++) {
                    for(int y = j; y < j + 3; y++) {
                        max = Math.max(grid[x][y], max);
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}