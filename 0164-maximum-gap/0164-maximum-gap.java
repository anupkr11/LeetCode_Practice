class Solution {
    public int maximumGap(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums)    pq.add(num);
        int max_diff = 0;
        while(pq.size() > 1){
            max_diff = Math.max(max_diff, Math.abs(pq.poll()-pq.peek()));
        }
        return max_diff;
    }
}