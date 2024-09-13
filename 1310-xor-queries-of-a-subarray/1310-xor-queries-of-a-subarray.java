class Solution {
    public int[] xorQueries(int[] ar, int[][] queries) {
        int n=ar.length;
        int[] p=new int[n];
        p[0]=ar[0];
        for(int i=1;i<n;i++) {
            p[i]=p[i-1]^ar[i];
        }
        int[] r=new int[queries.length];
        for(int k=0;k<queries.length;k++) {
            int a=queries[k][0];
            int b=queries[k][1];
            if(a==0) {
                r[k]=p[b];
            } else {
                r[k]=p[b]^p[a-1];
            }
        }
        return r;
    }
}