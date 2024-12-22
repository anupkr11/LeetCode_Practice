class SegmentTree{
    private int n;
    public SegmentTree(int n) {
        this.n = n;
    }
    public void update(int[] tree, int idx, int val) {
        idx += n;
        tree[idx] = val;
        while (idx > 0) {
            tree[idx >> 1] = Math.min(tree[idx], tree[idx ^ 1]);
            idx >>= 1;
        }
    }
    public int query(int[] tree, int left, int right) {
        left += n;
        right += n;
        int minIdx = n;
        while (left < right) {
            if ((left & 1) == 1) {
                minIdx = Math.min(minIdx, tree[left++]);
            }
            if ((right & 1) == 1) {
                minIdx = Math.min(minIdx, tree[--right]);
            }
            left >>= 1;
            right >>= 1;
        }
        return minIdx;
    }
}

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] res = new int[queries.length];
        int idx = 0;
        List<int[]> candidate = new ArrayList<>();
        for (int i = 0; i < queries.length; ++i) {
            int idxa = queries[i][0], idxb = queries[i][1];
            if (idxa > idxb) {
                int tmp = idxa;
                idxa = idxb;
                idxb = tmp;
            }
            if (idxa < idxb && heights[idxa] < heights[idxb]) res[i] = idxb;
            else if (idxa == idxb) res[i] = idxa;
            else {
                candidate.add(new int[]{idxa, idxb, i});
            }
        }
        Collections.sort(candidate, (int[] a, int[] b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int[] copyHeights = new int[heights.length];
        for (int i = 0; i < copyHeights.length; ++i) {
            copyHeights[i] = heights[i];
        }
        Arrays.sort(copyHeights);
        Map<Integer, Integer> segIdxMap = new HashMap<>();
        int copyIdx = 0;
        for (int i = 0; i < copyHeights.length; ++i) {
            segIdxMap.put(copyHeights[i], copyIdx++);
        }
        idx = heights.length - 1;
        SegmentTree seg = new SegmentTree(n);
        int[] tree = new int[2 * heights.length];
        Arrays.fill(tree, n);
        for (int i = candidate.size() - 1; i >= 0; --i) {
            while (idx > candidate.get(i)[1]) {
                int segIdx = segIdxMap.get(heights[idx]);
                seg.update(tree, segIdx, idx);
                --idx;
            }
            int targetCandidate =  candidate.get(i)[0];
            int segIdx = segIdxMap.get(heights[targetCandidate]);
            Integer higher = seg.query(tree, segIdx + 1, n);
            if (higher >= n) res[candidate.get(i)[2]] = -1;
            else res[candidate.get(i)[2]] = higher;
        }
        return res;
    }
}