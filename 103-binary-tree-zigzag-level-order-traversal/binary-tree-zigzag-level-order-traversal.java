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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int l=height(root)+1;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=l;i++){
            List<Integer> list=new ArrayList<>();
            if(i%2!=0){
            elementNth(root,i,list);
            if(list.size()!=0)
            ans.add(list);
            }
            else{
            elementNth2(root,i,list);
            if(list.size()!=0)
            ans.add(list);
            }
        }
           return ans;
        }
    private static void elementNth(TreeNode root,int n,List<Integer> list){
        if(root==null)
            return;
        if(n==1){list.add(root.val);}
        elementNth(root.left,n-1,list);
        elementNth(root.right,n-1,list);
        
        
    }
    private static void elementNth2(TreeNode root,int n,List<Integer> list){
        if(root==null)
            return;
        if(n==1) list.add(root.val);
        elementNth2(root.right,n-1,list);
        elementNth2(root.left,n-1,list);
         
        
    }
     private static int height(TreeNode root){
            if(root==null)
                return 0;
            return 1+Math.max(height(root.left),height(root.right));
        }

}