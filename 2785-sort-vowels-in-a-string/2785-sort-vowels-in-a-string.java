class Solution 
{
    
    public static boolean check(char s)
    {
        
        return (s== 'A' ||s== 'E' ||s== 'I'||s== 'O' ||s== 'U' ||s== 'a' || s== 'e' || s== 'i' ||s== 'o' || s== 'u');
      
    }
    
    
    public String sortVowels(String s) 
    {
        ArrayList<Character> vl = new ArrayList<>();     
        
        for(char i : s.toCharArray() )
        {
            if(check(i))
            {
                vl.add(i);
            }

        }            
         Collections.sort(vl);
        
      String str="";
        int index=0;
        
         for(int i=0 ; i<s.length() ; i++ )
        {
            if(check(s.charAt(i))){
                str += vl.get(index++);
            } 
            else{
                str+=(s.charAt(i));
            } 
        }
        
  
            return str;
    }
}