class Solution {
    public int maxPoints(int[][] p) {
        if (p.length == 1) return 1;
        int max = 2;
        for (int i = 0; i < p.length - 1; i++) {
            int x1 = p[i][0], y1 = p[i][1];
            for (int j = i + 1; j < p.length; j++) {
                int x2 = p[j][0], y2 = p[j][1];
                int count = 2;
                if (x2 == x1) {

                    for (int l = 0; l < p.length; l++) {
                        if (l == i || l == j) continue;
                        int x3 = p[l][0];
                        if (x3 == x1) count++;
                    }
                } else if (y2 == y1) {

                    for (int l = 0; l < p.length; l++) {
                        if (l == i || l == j) continue;
                        int y3 = p[l][1];
                        if (y3 == y2) count++;
                    }
                } else {
                    double k = (y2 * 1.0 - y1) / (x2 - x1);
                    double b = y1 - k * x1;
                    for (int l = 0; l < p.length; l++) {
                        if (l == i || l == j) continue;
                        int x3 = p[l][0], y3 = p[l][1];
                        double yPotential = k * x3 + b;
                        yPotential = Math.round(yPotential * 10000.0) / 10000.0;
                        if (y3 == yPotential) count++;
                    }
                }
                if (max < count) max = count;
            }
        }
        return max;
    }
}