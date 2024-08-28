class Solution {
    private int m, n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int subIslandCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (isSubIsland(grid1, grid2, i, j)) {
                        subIslandCount++;
                    }
                }
            }
        }
        return subIslandCount;
    }

    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        boolean[] isSubIsland = { true };
        dfs(grid1, grid2, i, j, isSubIsland);
        return isSubIsland[0];
    }

    private void dfs(int[][] grid1, int[][] grid2, int i, int j, boolean[] isSubIsland) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0)
            return;
        if (grid1[i][j] != grid2[i][j]) {
            isSubIsland[0] = false;
        }
        grid2[i][j] = 0;
        dfs(grid1, grid2, i + 1, j, isSubIsland);
        dfs(grid1, grid2, i - 1, j, isSubIsland);
        dfs(grid1, grid2, i, j + 1, isSubIsland);
        dfs(grid1, grid2, i, j - 1, isSubIsland);
    }
}
