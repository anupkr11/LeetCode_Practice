class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)->y[1]-x[1]);
        
        if(a > 0)
            maxHeap.offer(new int[]{0,a});
        if(b > 0)
            maxHeap.offer(new int[]{1,b});
        if(c > 0)
            maxHeap.offer(new int[]{2,c});
        
        while(!maxHeap.isEmpty()) {
            int[] top=maxHeap.poll();
            int[] second=maxHeap.isEmpty() ? null : maxHeap.poll();
            
            int count=Math.min(2,top[1]);
            sb.append(getString((char)(top[0] + 'a'), count));
            top[1] -= count;
            
            if(second == null)
                break;
            
            count= top[1] <= second[1] ? Math.min(2,second[1]) : Math.min(1,second[1]);
            sb.append(getString((char)(second[0] + 'a'), count));
            second[1] -= count;
            
            if(top[1] > 0)
                maxHeap.offer(top);
            
            if(second[1] > 0)
                maxHeap.offer(second);
        }
        
        return sb.toString();
    }
    
    private String getString(char ch, int count) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}