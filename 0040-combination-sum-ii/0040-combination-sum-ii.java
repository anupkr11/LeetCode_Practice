class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // Sort the candidates
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        int n = candidates.length;

        backtrack(0, 0, elem, ans, candidates, target, n);
        return ans;
    }

    private void backtrack(int idx, int curr_sum, List<Integer> elem, List<List<Integer>> ans, int[] candidates, int target, int n) {
        if (curr_sum == target) {
            ans.add(new ArrayList<>(elem));  // Add a copy of the current combination
            return;
        }
        
        if (idx == n || curr_sum > target) {
            return;  // End of array or sum exceeded target
        }
        
        elem.add(candidates[idx]);  // Include current candidate
        backtrack(idx + 1, curr_sum + candidates[idx], elem, ans, candidates, target, n);
        elem.remove(elem.size() - 1);  // Backtrack
        
        // Skip duplicates
        while (idx + 1 < n && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        backtrack(idx + 1, curr_sum, elem, ans, candidates, target, n);  // Explore next candidate without the current one
    }
}
