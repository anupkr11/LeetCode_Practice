class Solution {
    List<int[]> result = new ArrayList();
    Random random = new Random();

    public int[][] kClosest(int[][] points, int k) {
        quickSelect(Arrays.asList(points), k);
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    private void quickSelect(List<int[]> points, int k) {
        int pivotIndex = random.nextInt(points.size());
        int[] pivot = points.get(pivotIndex);

        List<int[]> left = new ArrayList();
        List<int[]> right = new ArrayList();
        List<int[]> mid = new ArrayList();

        for (int[] point : points) {
            if (distance(point) > distance(pivot)) {
                right.add(point);
            } else if (distance(point) < distance(pivot)) {
                left.add(point);
            } else {
                mid.add(point);
            }
        }
    
        if (left.size() > k) {
            quickSelect(left, k);
            return;
        } else if (left.size() < k) {
            if (left.size() + mid.size() < k) {
                result.addAll(left);
                result.addAll(mid);
                quickSelect(right, k - left.size() - mid.size());
                return;
            }else if ((left.size() + mid.size()) > k) {
                result.addAll(left);
                quickSelect(mid, k - left.size());
                return;
            }else {
                result.addAll(mid);
            }
        } 
        
        result.addAll(left);
    }

    private long distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}