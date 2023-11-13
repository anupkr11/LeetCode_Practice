// class Solution {
//         public String removeStars(String s) {
//         StringBuilder res = new StringBuilder();
//         for (char c : s.toCharArray())
//             if (c == '*')
//                 res.setLength(res.length() - 1);
//             else
//                 res.append(c);
//         return res.toString();
//     }
// }

class Solution{
    public String removeStars(String s){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }

        String ans="";
        for(char e:st){
            ans+=e;
        }
        return ans;
    }
}