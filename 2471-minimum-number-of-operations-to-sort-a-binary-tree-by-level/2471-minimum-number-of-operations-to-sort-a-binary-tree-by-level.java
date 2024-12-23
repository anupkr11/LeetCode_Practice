/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, Integer> imap = new HashMap<>();
            int[] arr = new int[size];
            int[] sorted = new int[size];
            for (int i = 0; i < size; ++i) {
                TreeNode t = q.poll();
                imap.put(t.val, i);
                arr[i] = t.val;
                sorted[i] = t.val;
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            Arrays.sort(sorted);
            for (int i = 0; i < size; ++i) {
                if (arr[i] != sorted[i]) {
                    arr[imap.get(sorted[i])] = arr[i];
                    imap.put(arr[i], imap.get(sorted[i]));
                    ret++;
                }
            }
        }
        return ret;
    }
}