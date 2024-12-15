class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                double b_groth = (double)(b[0]+1)/(double)(b[1]+1) - (double)b[0]/(double)b[1];
                double a_groth = (double)(a[0]+1)/(double)(a[1]+1) - (double)a[0]/(double)a[1];
                if(b_groth >= a_groth) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for(int[] c : classes) {
            pq.add(c);
        }

        for(int i=0; i<extraStudents; i++) {
            int[] cur = pq.poll();
            cur[0]+=1;
            cur[1]+=1;
            pq.add(cur);
        }

        double ans = 0;
        while(pq.size()>0) {
            int[] cur = pq.poll();
            ans += (double)cur[0]/(double)cur[1];
        }

        ans /= classes.length;

        return ans;
    }
}