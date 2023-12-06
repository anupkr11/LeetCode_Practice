class Solution {
    public String largestGoodInteger(String s) {
        int greatest=-1;
        int indx=-1;
        for(int i=0;i<s.length()-2;i++){
            if(s.charAt(i)==s.charAt(i+1)&&s.charAt(i)==s.charAt(i+2)){
                if(greatest<(s.charAt(i)-'0')){
                    indx=i;
                 greatest=s.charAt(i)-'0';}
            }
        }
     if(indx==-1)
     return "";
        
    return s.substring(indx,indx+3);
    }
}