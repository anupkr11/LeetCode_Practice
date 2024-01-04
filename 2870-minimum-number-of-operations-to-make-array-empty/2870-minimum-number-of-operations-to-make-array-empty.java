class Solution {
    public int minOperations(int[] nums) 
    {
        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        
        int count = 0;
        for (Map.Entry<Integer, Integer> j : hm.entrySet()) {
            int curr = j.getValue();
            if (curr == 1){
                return -1;
            } 
            count += curr / 3;
            if (curr % 3 != 0) count++;
        }
        return count;
    }
}