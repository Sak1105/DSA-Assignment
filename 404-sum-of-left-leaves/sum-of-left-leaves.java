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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        sum=sumLeftNodes(root,sum);
        return sum;
    }
    private int sumLeftNodes(TreeNode root,int sum){
        if(root==null){
            return sum;
        }
        else{
            if(root.left!=null &&
             root.left.left==null &&
             root.left.right==null){
                sum=sum+root.left.val;
            }
           sum=sumLeftNodes(root.left,sum);
           sum=sumLeftNodes(root.right,sum);
        }
        return sum;
    }
}