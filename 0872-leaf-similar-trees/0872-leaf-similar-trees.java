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
    int index = 0;
    public boolean verifyTree(TreeNode root,List<Integer> l){
        if(root==null)return true;
        boolean left = verifyTree(root.left,l);
        boolean right = verifyTree(root.right,l);
       
       if(root.left==null && root.right==null){
           if(index>l.size())return false;
            if(index<l.size() && root.val!=l.get(index)){
                return false;
            }
            index++;
        }
        return left && right;
    }
    public void findLeafNodes(TreeNode root,List<Integer> l){
        if(root==null)return;
        if(root.left==null && root.right==null){
            l.add(root.val);
        }
        findLeafNodes(root.left,l);
        findLeafNodes(root.right,l);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        findLeafNodes(root1,list);
        boolean ans = verifyTree(root2,list);
        return index!=list.size()?false:ans;
    }
}