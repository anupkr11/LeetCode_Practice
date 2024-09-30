class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        char first = words[0].charAt(0);
        char last = words[words.length-1].charAt(words[words.length-1].length()-1);
        int n = words.length;
        for(int i=1;i<n;i++){
              char len1 = words[i].charAt(0);
            char len2 = words[i-1].charAt(words[i-1].length()-1);
            if(len1!=len2){
                
                return false;
            }
        }
        if(first!=last){
            return false;
        }
        
        
        return true;
    }
}