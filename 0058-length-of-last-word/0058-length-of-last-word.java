class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int j=0;
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(s.length()-1-j) == ' ') {
                j++;
                continue;
            }
            else {
                if(s.charAt(i) != ' ') {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }
}

// class Solution {
//     public int lengthOfLastWord(String s) {

//         s=s.trim(); //Removes first and last spaces of a string
//         int x=s.lastIndexOf(" ");// gives last index of Whitespace
//         return s.length()-x-1;

//     }
// }