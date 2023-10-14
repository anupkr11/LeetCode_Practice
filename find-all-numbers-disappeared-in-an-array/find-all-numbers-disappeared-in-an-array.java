class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();
            for(int i:nums){
                hs.add(i);
            }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(!hs.contains(i)){
                al.add(i);
            }
        }
        return al;
    }
}