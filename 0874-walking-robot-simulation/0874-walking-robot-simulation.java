class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, d = 0;
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int maxDistance = 0;

        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(encode(obstacle[0], obstacle[1]));
        }

        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                d = (d + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + direction[d][0];
                    int ny = y + direction[d][1];
                    if (obstacleSet.contains(encode(nx, ny))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        return maxDistance;
    }

    private long encode(int x, int y) {
        return (((long) x + 30000) << 16) + (y + 30000);
    }
}