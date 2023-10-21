class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> hs = new HashSet<>();
    hs.add('a');
    hs.add('e');
    hs.add('i');
    hs.add('o');
    hs.add('u');
        int count = 0;
        int maxi = 0;
        for(int i=0; i<k; i++){
            if(hs.contains(s.charAt(i))){
                count++;
            }
        }
        maxi = count;
        for(int i = k; i<s.length(); i++){
            if(hs.contains(s.charAt(i-k))){
                count--;
            }
            if(hs.contains(s.charAt(i))){
                count++;
            }
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}