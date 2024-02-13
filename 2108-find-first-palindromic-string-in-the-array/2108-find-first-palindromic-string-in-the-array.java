public class Solution {
    public String firstPalindrome(String[] words) {
        for (String str : words) {
            int left = 0;
            int right = str.length() - 1;
            boolean flag = true;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    flag = false;
                }
                left++;
                right--;
            }
            if (flag) {
                return str;
            }
        }
        return "";
    }
}