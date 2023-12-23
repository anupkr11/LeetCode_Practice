class Solution {
    public boolean isPathCrossing(String s) {
        HashSet<String> hs = new HashSet<>();
        int x = 0;
        int y = 0;
        hs.add("0,0");
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='N'){
                y++;
            }else if(ch=='S'){
                y--;
            }else if(ch=='E'){
                x++;
            }else{
                x--;
            }

            if(hs.contains(x+","+y)) return true;
            else hs.add(x+","+y);
        }
        return false;
    }
}