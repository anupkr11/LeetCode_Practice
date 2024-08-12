class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int K;
    public KthLargest(int k, int[] nums) {
        
        K = k;

        for(int num : nums){

            minHeap.add(num);

            if(minHeap.size() > K){

                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        
        minHeap.add(val);

        if(minHeap.size() > K){

            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */