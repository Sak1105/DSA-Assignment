class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        return false;
        if(root.left==null && root.right==null)
        return targetSum==root.val;
        boolean leftd=hasPathSum(root.left,targetSum-root.val);
        boolean rightd=hasPathSum(root.right,targetSum-root.val);
        
            return (leftd||rightd);
    
    }
}