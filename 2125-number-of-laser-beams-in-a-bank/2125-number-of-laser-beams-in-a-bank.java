class Solution {
    public int numberOfBeams(String[] bank) {
        
        int poc = 0;
        int result = 0;
        for(String s : bank){
            int coc = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    coc++;
                }
            }
            if(coc>0){
                result += coc*poc;
                poc = coc; 
            }
        }
        return result;
    }
}