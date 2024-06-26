class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] counts = new long[101];
        int kMod = 1_000_000_007;
        int max = 0;
        for (int num: arr) {
            counts[num]++;
            max = Math.max(max, num);
        }
        long total = 0;
        for(int i = 0; i <= max; i++) {
            for(int j = i; j <= max; j++) {
                int k = target - i - j;
                if (k >= j && k <= max) {
                    if (counts[i]== 0 || counts[j] == 0 || counts[k] == 0) continue;
                    if (i == j && i == k) {
                        total += combination(counts[i], 3);
                    } else if (i == j && j != k) {
                        total += combination(counts[i], 2) * counts[k];
                    } else if (i != j && j == k) {
                        total += combination(counts[j], 2) * counts[i];
                    } else {
                        total += counts[i] * counts[j] * counts[k];
                    }
                }
            }
        }
        return (int)(total % kMod);
    }
    private long combination(long x, long y) {
        if(x < y) return 0;
        if(x == y) return 1;
        if(y == 2) return (x * (x - 1) >> 1);            
        else return (x * (x - 1) >> 1) * (x - 2) / 3;
    }
}