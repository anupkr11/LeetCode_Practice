class Solution {
    public int differenceOfSums(int n, int m) {
         int s1=0,s2=0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0)
                s1 = s1 + i;
            else
                s2 = s2 + i;

        }
        return s2 - s1;
    }
}