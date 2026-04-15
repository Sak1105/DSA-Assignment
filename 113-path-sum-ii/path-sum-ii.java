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
import java.util.*;
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> ans=new ArrayList<>();
       List<Integer> arr=new ArrayList<>();
       helper(ans,arr,root,targetSum);
       return ans;
    }
    private static void helper(List<List<Integer>> ans,List<Integer> arr,TreeNode root, int sum ){
        if(root==null){
            return;
        }
         arr.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==sum){
                ans.add(new ArrayList<>(arr));
            }
            arr.remove(arr.size()-1);
            return;
        }

        helper(ans, arr,root.left, sum-root.val);
        helper(ans, arr,root.right, sum-root.val);
        arr.remove(arr.size()-1);
        return;
    
    }
}
