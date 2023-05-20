class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int count=0;
        ArrayList<Integer> list=new ArrayList();
        int ans[]=new int[k];
        for(int i=0;i<mat.length;i++)
        {
            list.add(noOfSoldiers(mat[i]));
        }
        for(int i=0;i<k;i++)
        {
            int index=list.indexOf(Collections.min(list));
            ans[i]=index;
            list.set(index,Integer.MAX_VALUE);
        }
        return ans;
        
        
    }

    public int noOfSoldiers(int mat[])
    {
        int count=0;
        for(int i=0;i<mat.length;i++)
        {
            if(mat[i]==1)
                count++;   
        }
        return count;
    }
}
