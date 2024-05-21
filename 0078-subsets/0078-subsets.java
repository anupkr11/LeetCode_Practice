class Solution {
    void f(int ind, int[] nums, List<Integer> subset, List<List<Integer>> result){
            if(ind>=nums.length){
                result.add(new ArrayList<>(subset));
                return;
            }

            subset.add(nums[ind]);
            f(ind+1,nums,subset,result);

            subset.remove(subset.size()-1);
            f(ind+1, nums, subset, result);
        }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        f(0, nums, new ArrayList<>(),result);
        return result;
    }
}