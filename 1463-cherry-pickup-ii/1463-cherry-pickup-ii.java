class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Initialize the 3D DP array with -1
        int[][][] DP = new int[rows][cols][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Arrays.fill(DP[i][j], -1);
            }
        }

        // Base case: bottom row
        for (int j1 = 0; j1 < cols; ++j1) {
            for (int j2 = 0; j2 < cols; ++j2) {
                DP[rows - 1][j1][j2] = grid[rows - 1][j1];
                if (j1 != j2) {
                    DP[rows - 1][j1][j2] += grid[rows - 1][j2];
                }
            }
        }

        // Iterate from the second-to-last row up to the top
        for (int i = rows - 2; i >= 0; --i) {
            for (int j1 = 0; j1 < cols; ++j1) {
                for (int j2 = 0; j2 < cols; ++j2) {
                    int cherries = grid[i][j1];
                    if (j1 != j2) {
                        cherries += grid[i][j2];
                    }

                    // Iterate over the possible next positions for both robots
                    for (int nj1 = j1 - 1; nj1 <= j1 + 1; ++nj1) {
                        for (int nj2 = j2 - 1; nj2 <= j2 + 1; ++nj2) {
                            // Check if the next positions are within bounds
                            if (nj1 >= 0 && nj1 < cols && nj2 >= 0 && nj2 < cols) {
                                DP[i][j1][j2] = Math.max(DP[i][j1][j2], cherries + DP[i + 1][nj1][nj2]);
                            }
                        }
                    }
                }
            }
        }

        // The answer is stored in DP[0][0][cols - 1]
        return DP[0][0][cols - 1];
    }
}
