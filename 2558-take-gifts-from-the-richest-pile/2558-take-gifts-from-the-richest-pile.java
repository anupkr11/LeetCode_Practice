class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Arrays.sort(gifts);
        // //long i=0;
        // while(k>0){
        //     gifts[gifts.length-1]=(int)Math.sqrt(gifts[gifts.length-1]);
        //     Arrays.sort(gifts);
        //     k--;
        // }
        // long ans=0;
        // for(int i=0;i<gifts.length;i++){
        //     ans+=gifts[i];
        // }
        // return ans;
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:gifts)
            q.add(x);
        for(int i=0;i<k;i++){
            int cur=q.remove();
            q.add((int)Math.sqrt(cur));
        }
        long ans=0;
        while(q.size()>0){
            ans+=q.remove();
        }
        return ans;
    }
}