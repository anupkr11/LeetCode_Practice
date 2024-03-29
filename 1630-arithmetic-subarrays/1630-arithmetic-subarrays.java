class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int st=l[i];
            int end=r[i];
            if(solve(nums,st,end)){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
    public boolean solve(int arr[],int l,int r){
        int len=r-l+1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        int diff=max-min;
        if(diff==0){
            return true;
        }
        if(diff % (len-1)!=0){
            return false;
        }
        diff=diff/(len-1);
        boolean visited[]=new boolean[len];
        for(int i=l;i<=r;i++){
            if((arr[i]-min)%diff!=0){
                return false;
            }
            int pos=(arr[i]-min)/diff;
            if(visited[pos]){
                return false;
            }
            visited[pos]=true;
        }
        return true;
    }
}