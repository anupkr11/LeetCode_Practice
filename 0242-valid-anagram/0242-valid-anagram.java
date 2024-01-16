class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            if(map.get(t.charAt(i))!=null){
                if(map.get(t.charAt(i))==1)
                  map.remove(t.charAt(i));
                else
                  map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
            else{
                return false;
            }
        }
        return map.isEmpty();
    }
}

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int len1 = s.length();
//         int len2 = t.length();
//         if(len1!=len2){
//             return false;
//         }
//             int[] cnt = new int[26];
//             for(int i=0;i<len1;i++){
//                 cnt[s.charAt(i)-'a']++;
//             }
//             for(int i=0;i<len2;i++){
//                 cnt[t.charAt(i)-'a']--;
//             }
//             for(int i=0;i<cnt.length;i++){
//                 if(cnt[i]!=0){
//                     return false;
//                 }
//             }
//             return true;
//     }
// }