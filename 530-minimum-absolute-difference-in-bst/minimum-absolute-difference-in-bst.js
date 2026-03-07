/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var getMinimumDifference = function(root) {
    let prev = null;
    let mini = Infinity;
    function inorder(node){
        if(!node) return;
        inorder(node.left);
        if(prev!=null){
            mini = Math.min(mini,node.val-prev);
        }
        prev = node.val;
        inorder(node.right);
    }
    inorder(root);
    return mini;
};