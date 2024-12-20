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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        
        Queue<TreeNode> qu=new ArrayDeque<>();
        
        
        qu.add(root);
        int level=-1;
        List<Integer> list=new ArrayList<>();
        
        
        while(qu.size()>0){
            
            int size=qu.size();
            level++;
            list=new ArrayList<>();
            
             Queue<TreeNode> dummy=new ArrayDeque<>();
            while(size-->0){
                
                TreeNode node=qu.poll();
                list.add(node.val);
                dummy.add(node);
                
                if(node.left!=null) qu.add(node.left);
                if(node.right!=null) qu.add(node.right);
                
            }
            
            if(level%2!=0){
                
                size=dummy.size();
                
                
                while(size-->0){
                    
                    TreeNode node=dummy.poll();
                    System.out.println("commin");
                    node.val=list.get(size);
                }
            }
            
        }
        
        return root;
    }
}