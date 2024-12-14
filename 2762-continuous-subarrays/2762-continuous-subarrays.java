class Solution {
    public long continuousSubarrays(int[] nums) {
        int limit = 2;
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        maxD.addLast(nums[0]);
        minD.addLast(nums[0]);

        long ans = 1;
        int i=0;
        for(int j=1; j<nums.length; j++){
            while(!maxD.isEmpty() && maxD.getLast()<nums[j]){
                maxD.removeLast();
            }
            maxD.addLast(nums[j]);

            while(!minD.isEmpty() && minD.getLast()>nums[j]){
                minD.removeLast();
            }
            minD.addLast(nums[j]);

            while(Math.abs(maxD.getFirst() - minD.getFirst())>limit){
                if(maxD.getFirst()==nums[i])
                    maxD.removeFirst();
                if(minD.getFirst()==nums[i])
                    minD.removeFirst();
                i++;
            }

            ans += (j-i+1);
        }
        return ans;
    }
}