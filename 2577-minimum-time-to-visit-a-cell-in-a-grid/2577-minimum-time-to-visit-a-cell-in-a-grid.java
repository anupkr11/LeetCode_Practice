class Solution {
    static class Pair {
        int x;
        int y;
        int time;

        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int minimumTime(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(0, 0, 0));
        vis[0][0] = true;

        int[] xcor = new int[]{1, -1, 0, 0};
        int[] ycor = new int[]{0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int x = pair.x;
            int y = pair.y;
            if (x == n - 1 && y == m - 1) {
                return pair.time;
            }
            for (int i = 0; i < 4; i++) {
                int newX = xcor[i] + x;
                int newY = ycor[i] + y;
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || vis[newX][newY]) continue;

                if (grid[newX][newY] <= pair.time + 1) {
                    pq.offer(new Pair(newX, newY, pair.time + 1));
                } else {
					// If we cant move to neighbor yet, we can hop to the previous cell
                    // and back to current cell as many times as we need to until
                    // sufficient time has passed.
                    // The trick here is that if the difference between the current time
                    // and the time we need is even, we will arrive back at the current cell
                    // 1 second "late" and so we will move to the neighbor 1 second after
                    // the minimum neighbor time.
                    
                    int diff = grid[newX][newY] - pair.time;
                    if (diff % 2 == 1) {
                        pq.offer(new Pair(newX, newY, pair.time + diff));
                    } else {
                        pq.offer(new Pair(newX, newY, pair.time + diff + 1));
                    }
                }
                vis[newX][newY] = true;
            }
        }
        return -1;
    }
}