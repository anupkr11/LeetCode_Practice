class Solution {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        String compStr = ""; 
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                compStr += "1";
            } else {
                compStr += "0";
            }
        }
        return Integer.parseInt(compStr, 2);
    }
}