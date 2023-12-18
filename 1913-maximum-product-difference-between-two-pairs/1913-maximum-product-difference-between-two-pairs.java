class Solution {
    public int maxProductDifference(int[] nums) {
        int maxi1=Integer.MIN_VALUE;
        int maxi2=Integer.MIN_VALUE;
        int mini1=Integer.MAX_VALUE;
        int mini2=Integer.MAX_VALUE;
        for (int i : nums) {
            if (i >= maxi1) {
                maxi2 = maxi1;
                maxi1 = i;
            } else if (i > maxi2)
                maxi2 = i;

            if (i <= mini1) {
                mini2 = mini1;
                mini1 = i;
            } else if (i < mini2)
                mini2 = i;
        }
        return (maxi1 * maxi2) - (mini1 * mini2);
    }
}
