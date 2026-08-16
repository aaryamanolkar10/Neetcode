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
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int numberOfLevels=0;

        while(true){
            int nodeCountAtLevel=queue.size();
            if(nodeCountAtLevel==0)return numberOfLevels;

            while(nodeCountAtLevel>0){
                TreeNode temp=queue.poll();
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
                nodeCountAtLevel--;
            }
            numberOfLevels++;
        }
    }
}
