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
    class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode n, int l) {
            node = n;
            level = l;
        }
    }
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Pair> valueMap = new HashMap<>();
        Map<Integer, Integer> levelMap = new HashMap<>();
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        
        int levelCount=0, size = 0;
        while(!bfs.isEmpty()) {
            size = bfs.size();
            levelMap.put(levelCount, size);
            
            while(size-- > 0) {
                TreeNode top = bfs.remove();
                valueMap.put(top.val, new Pair(top, levelCount));
                if(top.left != null) bfs.add(top.left);
                if(top.right != null) bfs.add(top.right);
            }
            levelCount++;
        }
        levelMap.put(levelCount, 0);
        
        int n = queries.length, i = 0;
        int res[] = new int[n];
        for(int query : queries) {
            Pair p = valueMap.get(query);
            TreeNode curr = p.node;
            
            if(levelMap.get(p.level) == 1) {
                res[i++] = p.level-1;
                continue;
            }
            
            bfs.clear();
            bfs.add(curr);
            int currLevel = p.level;
            boolean flag = true;
            
            while(!bfs.isEmpty()) {
                int nodeCounts = levelMap.get(currLevel+1);
                size = bfs.size();
                
                while(size-- > 0) {
                    TreeNode top = bfs.remove();
                    if(top.left != null) {
                        bfs.add(top.left);
                        nodeCounts--;
                    }
                    if(top.right != null) {
                        bfs.add(top.right);
                        nodeCounts--;
                    }
                }
                
                if(nodeCounts == 0) {
                    res[i++] = currLevel;
                    flag=false;
                    break;
                }
                currLevel++;
            }
            
            if(flag) {
                res[i++] = levelCount-1;
            }
        }
        
        return res;
    }
}