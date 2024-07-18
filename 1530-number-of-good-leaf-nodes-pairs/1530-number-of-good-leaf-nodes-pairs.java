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
    short[] zeroDist;
    short[] leafDist;  
    int goodLeafCount = 0;
    
    public int countPairs(TreeNode root, int distance) {
        if (distance <= 1)  return 0;
        zeroDist = new short[distance];
        leafDist = new short[distance];
        leafDist[1] = 1;
        dfs(root, distance);
        return goodLeafCount;
    }
    
    
    private short[] dfs(TreeNode node, int distance) {
        if (node == null)  return zeroDist;
        
        if (node.left == null) {
            if (node.right == null)  
                return leafDist;
            short[] rightDist = dfs(node.right, distance);
            short[] dist = new short[distance];
            for (int idx = distance - 2; idx >= 0; idx--)
                dist[idx + 1] = rightDist[idx];
            return dist;
        }
        else if (node.right == null) {
            short[] leftDist = dfs(node.left, distance);
            short[] dist = new short[distance];
            for (int idx = distance - 2; idx >= 0; idx--)
                dist[idx + 1] = leftDist[idx];
            return dist;
        }
        else {
            short[] leftDist = dfs(node.left, distance);
            short[] rightDist = dfs(node.right, distance);
            short[] dist = new short[distance];
            int rightCount = 0;
            int rightIdx = 1;
            for (int leftIdx = distance - 1; leftIdx >= 1; leftIdx--) {
                rightCount += rightDist[rightIdx++];
                goodLeafCount += leftDist[leftIdx] * rightCount;
                dist[leftIdx] = (short)(leftDist[leftIdx - 1] + rightDist[leftIdx - 1]);
            }
            return dist;
        }
    }
}