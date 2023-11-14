class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        int longest = 0;
        for(int num: nums){
            hm.put(num, Boolean.FALSE);
        }
        for(int num: nums){
            int currlen = 1;
            int nextNum = num+1;
            while(hm.containsKey(nextNum) && hm.get(nextNum) == false){
                currlen++;
                hm.put(nextNum, Boolean.TRUE);
                nextNum++;
            }
            
            int prevNum = num-1;
            while(hm.containsKey(prevNum)&& !hm.get(prevNum)){
                currlen++;
                hm.put(prevNum, Boolean.TRUE);
                prevNum--;
            }
            longest = Math.max(longest, currlen);
        }
        return longest;
    }
}