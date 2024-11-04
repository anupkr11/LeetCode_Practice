class Solution {
    public String compressedString(String word) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < word.length()) {
            char curCh = word.charAt(i);
            int len = 1;
            i++;
            while (i < word.length() && word.charAt(i) == curCh && len < 9) {
                len++;
                i++;
            }
            res.append(len);
            res.append(curCh);
        }
        return res.toString();
    }
}