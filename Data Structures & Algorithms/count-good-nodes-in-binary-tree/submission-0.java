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
    int numGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    public int helper(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            numGoodNodes++;
        }
        if (node.left != null) {
            helper(node.left, Math.max(node.val, maxSoFar));
        }
        if (node.right != null) {
            helper(node.right, Math.max(node.val, maxSoFar));
        }
        return numGoodNodes;
    }
}
