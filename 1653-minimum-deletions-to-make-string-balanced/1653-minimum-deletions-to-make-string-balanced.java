class Solution {
    public int minimumDeletions(String s) {
        int ans = 0, countOfB = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'b') {
                countOfB++;
            } else if(s.charAt(i) == 'a') {
                if(countOfB > 0) {
                    ans++;
                    countOfB--;
                }
            }
        }
        return ans;
    }
}