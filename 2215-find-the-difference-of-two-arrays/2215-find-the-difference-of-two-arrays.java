class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> h1 = new ArrayList<>();
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        
        for(int i : nums1){
            hs1.add(i);
        }
        for(int i : nums2){
            hs2.add(i);
        }
        List<Integer> ans1 = new ArrayList<>();
        for(int i:hs1){
            if(!hs2.contains(i)){
                ans1.add(i);
            }
        }
        h1.add(ans1);
        List<Integer> ans2 = new ArrayList<>();
         for(int i:hs2){
            if(!hs1.contains(i)){
                ans2.add(i);
            }
        }
        h1.add(ans2);
        return h1;
    }
}