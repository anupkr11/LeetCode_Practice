class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double l = 0;
        double h = 1;
        int[] res = new int[] {0,1};

        while(l < h) {
            double m = l + (h - l)/2;
            int[] arr1 = new int[] {0,1};
            int cnt = 0;
            int j = 1;
            for(int i = 0; i < n - 1; i++) {
                while(j < n && arr[i] > m * arr[j]) {
                    j++;
                }
                cnt += n - j;
                if (j < n && arr1[0] * arr[j] < arr1[1] * arr[i]) {
                    arr1[0] = arr[i];
                    arr1[1] = arr[j];
                }
            }
            if (cnt == k) {
                return arr1;
            }

            if (cnt < k) {
                l = m;
            } else {
                h = m;
                arr1[0] = arr1[0];
                arr1[1] = arr1[1];
            } 
        }
        return res;
    }
}