class Solution {
    public int getMaximumGold(int[][] G) {
        int max=0,m=G.length,n=G[0].length;
        for(int r=0;r<m;r++)
            for(int c=0;c<n;c++)
                if(G[r][c]!=0)
                max=Math.max(max,dfs(G,m,n,r,c,0));
        return max;
    }
    int D[]={0,1,0,-1,0};
    boolean flag=false;
    public int dfs(int[][] G,int m,int n,int r,int c,int used){
        if(used==25) flag=true; //max possibility
        if(r<0 || r==m || c<0 || c==n || G[r][c]==0)return 0;
        int orignal=G[r][c],max=0;
        G[r][c]=0;//mark as visted 
        for(int i=0;i<4;i++)
            if(!flag)
            max=Math.max(max,dfs(G,m,n,r+D[i],c+D[i+1],used+1));
        G[r][c]=orignal;//backtrack
        return max+orignal;
}
}