class Solution {
    private String inputString;
    private int stringLength;
    public int maximumLength(String inputString) {
        this.inputString = inputString;
        this.stringLength = inputString.length();

        int left = 0, right = stringLength;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (isCriteriaSatisfied(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left == 0 ? -1 : left;
    }
    private boolean isCriteriaSatisfied(int targetLength) {
        int[] frequencyCounter = new int[26];
        for (int i = 0; i < stringLength;) {
            int endIndex = i + 1;
            while (endIndex < stringLength && inputString.charAt(endIndex) == inputString.charAt(i)) {
                endIndex++;
            }
            int charIndex = inputString.charAt(i) - 'a';
            frequencyCounter[charIndex] += Math.max(0, endIndex - i - targetLength + 1);

            if (frequencyCounter[charIndex] >= 3) {
                return true;
            }
            i = endIndex;
        }

        return false;
    }
}