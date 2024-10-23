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
    public TreeNode replaceValueInTree(final TreeNode root) {
        final Queue<TreeNode> levelNodes = new LinkedList<>();

        root.val = 0;

        levelNodes.offer(root);

        while(!levelNodes.isEmpty()) {
            final int size = levelNodes.size();
            int sum = 0;

            for(int i = 0; i < size; ++i) {
                final TreeNode node = levelNodes.poll();

                if(node.left != null)
                    sum += node.left.val;

                if(node.right != null)
                    sum += node.right.val;

                levelNodes.offer(node);
            }

            for(int i = 0; i < size; ++i) {
                final TreeNode node = levelNodes.poll();
                int newSum = sum;

                if(node.left != null) {
                    newSum -= node.left.val;
                    levelNodes.offer(node.left);
                }

                if(node.right != null) {
                    newSum -= node.right.val;
                    levelNodes.offer(node.right);
                }

                if(node.left != null)
                    node.left.val = newSum;

                if(node.right != null)
                    node.right.val = newSum;
            }
        }

        return root;
    }
}