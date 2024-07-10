class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s=new Stack<>();
        for(int i=0;i<logs.length;i++){
            String s1=logs[i];
            if(s1.equals("../")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else if(s1.equals("./")){
                continue;
            }
            else{
                s.push(s1);
            }
        }
        return s.size();
    }
}