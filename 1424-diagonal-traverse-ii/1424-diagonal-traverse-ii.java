class Solution {

    public static class Point{
        int row;
        int val;
        int sum;

        Point(int row, int val, int sum){
            this.row = row;
            this.val = val;
            this.sum = sum;
        }
    }

    public static class PointComparator implements Comparator<Point>{
        public int compare(Point p1, Point p2){
            if(p1.sum>p2.sum) return 1;
            else if(p1.sum<p2.sum) return -1;
            else{
                if(p1.row<p2.row) return 1;
                else if(p1.row>p2.row) return -1;
                else return 0;
            }
        }
    }


    public int[] findDiagonalOrder(List<List<Integer>> arr) {
        ArrayList<Point> ans = new ArrayList<>();

        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.get(i).size(); j++){
                ans.add(new Point(i,arr.get(i).get(j),i+j));
            }
        }

        Collections.sort(ans, new PointComparator());

        int a[] = new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            a[i] = ans.get(i).val;
        }

        return a;
    }
}