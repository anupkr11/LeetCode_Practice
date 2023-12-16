// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int len1 = s.length();
//         int len2 = t.length();
//         if(len1==len2){
//             char[] ch1 = s.toCharArray();
//             char[] ch2 = t.toCharArray();
//             Arrays.sort(ch1);
//             Arrays.sort(ch2);
//             for(int i=0; i<len1;i++){
//                 if(ch1[i]!=ch2[i]){
//                     return false;
//                 }
//             }
//             return true;
//         }
//         return false;
//     }
// }

class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1!=len2){
            return false;
        }
            int[] cnt = new int[26];
            for(int i=0;i<len1;i++){
                cnt[s.charAt(i)-'a']++;
            }
            for(int i=0;i<len2;i++){
                cnt[t.charAt(i)-'a']--;
            }
            for(int i=0;i<cnt.length;i++){
                if(cnt[i]!=0){
                    return false;
                }
            }
            return true;
    }
}