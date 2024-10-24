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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
       swap(root1, root2);
       return f(root1, root2);
    }

    private void swap(TreeNode root1, TreeNode root2) {
        if(root1 == null  && root2 == null) return;
        if(root1 == null || root2== null) return;
        TreeNode left = null, right = null;
        if(root2.left != null) left = root2.left;
        if(root2.right != null) right = root2.right;
        int lVal = (left != null) ? left.val : 0;
        int rVal = (right != null) ? right.val : 0;

        if((root1.left != null && root1.left.val != lVal) || (root1.right != null && root1.right.val != rVal)) {
            TreeNode temp = root2.left;
            root2.left = root2.right;
            root2.right = temp;
        }

        swap(root1.left, root2.left);
        swap(root1.right, root2.right);
    } 

    private boolean f(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if((root1 == null || root2 == null) || (root1.val != root2.val)) return false;

        return f(root1.left, root2.left) && f(root1.right, root2.right);

    }

}