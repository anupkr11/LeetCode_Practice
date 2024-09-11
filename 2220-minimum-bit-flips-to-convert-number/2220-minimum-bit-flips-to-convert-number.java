class Solution {
    public int minBitFlips(int start, int goal) {
        String bit1 = Integer.toBinaryString(start);
        String bit2 = Integer.toBinaryString(goal);
        if (bit1.length() == bit2.length()) {
            return minFlips(bit1,bit2);
        }
        else if (bit1.length()>bit2.length()) {
            int diff = bit1.length()-bit2.length();
            while(diff-->0) {
                bit2 = "0"+bit2;
            }
        }else{
            int diff = bit2.length()-bit1.length();
            while(diff-->0) {
                bit1 = "0"+bit1;
            }
        }
        return minFlips(bit1,bit2);
    }
    public int minFlips (String s1, String s2) {
        int count = 0;
        for (int i = 0;i<s1.length();i++) {
            if (s1.charAt(i) !=s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}