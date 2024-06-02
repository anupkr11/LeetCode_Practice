class Solution {
    public List<String> commonChars(String[] words) {
        String s=words[0];
        List<String> l=new ArrayList<>();
        for(char c:s.toCharArray()){
            int p=0;
            for(int i=1;i<words.length;i++){
                char h[]=words[i].toCharArray();
                for(int j=0;j<h.length;j++){
                    if(c==h[j]){
                        p++;
                        h[j]='-';
                        break;
                    }
                }
                String g="";
                for(char e:h){
                    g+=e+"";
                }
                words[i]=g;
            }
           if(p==words.length-1){
               l.add(c+"");
           }
        }
        return l;
    }
}