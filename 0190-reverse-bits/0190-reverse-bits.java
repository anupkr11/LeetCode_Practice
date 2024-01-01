public class Solution 
{
    public int reverseBits(int n) 
    {
        int i , reverse = 0 ;
        for( i = 0 ; i < 32 ; i++ )
        {
            reverse = reverse << 1 ;
            if( ( n & 1 ) == 1 )
            {
                reverse = reverse | 1 ;
            }
            n = n >> 1 ;
        }
        return reverse ;       
    }
}