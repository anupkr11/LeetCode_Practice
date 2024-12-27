class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        var max = 0;
        var maxIndex = 0;
        var res = 0;
        for (int i = 0; i < values.length; i++) {
            if (i > maxIndex && max + values[i] - i > res) {
                res = max + values[i] - i;
            }
            if ((values[i] + i) > max) {
                max = values[i] + i;
                maxIndex = i;
            }
        }
        return res;
    }
}