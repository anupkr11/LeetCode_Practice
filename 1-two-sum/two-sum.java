class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            int a = nums[i];
            int req = target-a;
            if(hm.containsKey(req)){
                return new int[] {hm.get(req),i};
            }
            hm.put(a,i);
        }
        return new int[] {-1,-1};
    }
}