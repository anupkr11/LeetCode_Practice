class Solution {
    public String reverseVowels(String s) {
        // s = s.tolowerCase();
        int l = 0;
        int r = s.length()-1;
        char ch[] = s.toCharArray();
        while(l<r){
            if(!isVowel(ch[l])){
                l++;
            }
            else if(!isVowel(ch[r])){
                r--;
            }
            else{
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] =temp;
                l++;
                r--;
            }
        }
        return String.valueOf(ch);
        
    }
    public static boolean isVowel(char c){
            if(c=='a' || c=='e' || c == 'i' || c == 'o' || c=='u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
            }
            else{
                return false;
            }
        }
}


// class Solution {
//     public String reverseVowels(String s) {
//         int lengthOfString = s.length();
//         char ch[] = s.toCharArray();
//         int start = 0;
//         int end = lengthOfString - 1;
//         while(start < end) {
//             if(!isVowel(ch[start])) {
//                 start++;
//             }
//             else if(!isVowel(ch[end])) {
//                 end--;
//             }
//             else {
//                 char temp = ch[start];
//                 ch[start] = ch[end];
//                 ch[end] = temp;
//                 start++;
//                 end--;
//             }
//         }
//         return String.valueOf(ch);
        
//     }
//      public static boolean isVowel(char ch) {
//         if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
//             return true;
//         }
//         return false;
        
//     }
// }