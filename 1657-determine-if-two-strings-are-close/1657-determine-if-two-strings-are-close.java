class Solution {
    public boolean closeStrings(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        if(l1!=l2) return false;
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<l1;i++)
            w1[word1.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++)
            map.put(w1[i], map.getOrDefault(w1[i], 0)+1);
        
        for(int i=0;i<l2;i++) {
            if(w1[word2.charAt(i)-'a'] == 0) return false;
            w2[word2.charAt(i)-'a']++;
        }
        
        for(int i=0;i<26;i++) {
            if(map.getOrDefault(w2[i],0)==0) return false;
            map.put(w2[i], map.get(w2[i])-1);
        }
        return true;
    }
}