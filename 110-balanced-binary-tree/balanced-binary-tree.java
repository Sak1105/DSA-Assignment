class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
     this.val = val; }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(depth(root)==-1)
        return false;
        return true;
        
        
    }
    private int depth(TreeNode node)
    {
        if(node==null)
        return 0;
        int lh=depth(node.left);
        if(lh==-1){
            return -1;
        }
        int rh=depth(node.right);
        if(rh==-1){
            return -1;
        }
        if(Math.abs(lh-rh)>1)
        return -1;
        return 1+Math.max(lh,rh);
    }
}
