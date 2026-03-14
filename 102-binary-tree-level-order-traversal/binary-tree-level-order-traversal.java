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
    public List<List<Integer>> levelOrder(TreeNode root) {
        int l=1+height(root);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<l;i++){
            List<Integer> list=new ArrayList<>();
            Nthorder(root,i,list);
            ans.add(list);

        }
        return ans;
        
    }
    private static int height(TreeNode root){
        if(root==null)
            return 0;
         return 1+Math.max(height(root.left),height(root.right)) ; 
        
    }
    private static List<Integer> Nthorder(TreeNode root,int i,List<Integer> list){
        if(root==null)
            return null;
        if(i==1){
            list.add(root.val);
           
        }
        Nthorder(root.left,i-1,list);
        Nthorder(root.right,i-1,list);
        return list;
        
    }
}