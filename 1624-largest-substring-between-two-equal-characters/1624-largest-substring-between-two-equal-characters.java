class Solution {
    public int maxLengthBetweenEqualCharacters(String s) 
    {
        int i=0,n=s.length(),m=-1;
        while(i<n)
        {
            char c=s.charAt(i);
            int t=s.lastIndexOf(c);
            if(t!=i)
            {
                m=Math.max(m,t-i-1);
            }
            i++;
        }
        return m;
    }
}