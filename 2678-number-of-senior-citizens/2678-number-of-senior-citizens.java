class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String str : details) {
            int i = str.charAt(11) - '0';
            int j = str.charAt(12) - '0';
            int age = (i * 10) + j;
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}