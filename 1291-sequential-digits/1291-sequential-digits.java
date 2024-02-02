class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        String s = "123456789";
        List<Integer> ans = new ArrayList<>();

        for (int len = 2; len <= s.length(); len++) {
            for (int startIdx = 0; startIdx <= s.length() - len; startIdx++) {
                String temp = s.substring(startIdx, startIdx + len);
                int cur = Integer.parseInt(temp);

                if (cur >= low && cur <= high) {
                    ans.add(cur);
                }
            }
        }
        return ans;
    }
}