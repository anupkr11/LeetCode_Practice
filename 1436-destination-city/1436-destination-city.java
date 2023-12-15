class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> hs = new HashSet<>();
        for(List<String> l : paths){
            hs.add(l.get(0));
        }
        
        for(List<String> s : paths){
            if(!hs.contains(s.get(1))){
                return s.get(1);
            }
        }
        return "";
    }
}