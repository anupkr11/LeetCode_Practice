class Solution {
    public int numIslands(char[][] grid) {
        
        int[] d1 = new int[]{-1,0,1,0};
        int[] d2 = new int[]{0,-1,0,1};
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i< grid.length ; i ++) {
            for (int j = 0; j< grid[0].length ; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});

                    while(!queue.isEmpty()) {
                        int[] point = queue.poll();
                        for(int p =0; p<4;p++) {
                            int nx = point[0] +d1[p];
                            int ny = point[1] +d2[p];

                            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length) {
                                if(grid[nx][ny] == '1' && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}