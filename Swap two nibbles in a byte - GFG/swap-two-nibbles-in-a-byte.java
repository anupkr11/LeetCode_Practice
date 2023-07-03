//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int swapNibbles(int N) {
        int left = (N & 0x0F) << 4;
        int right = (N >> 4) & 0x0F;
        int ans = left | right;
        return ans;
    }
}