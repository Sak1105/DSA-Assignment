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

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    
    private Map<Integer, Integer> postIndexMap;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Map from value → index in postorder for fast lookup
        postIndexMap = new HashMap<>();
        for(int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if(preStart > preEnd) return null;
        
        TreeNode root = new TreeNode(pre[preStart]);
        if(preStart == preEnd) return root; // leaf node
        
        // Next element in preorder is left child
        int leftRootVal = pre[preStart + 1];
        int leftRootIndex = postIndexMap.get(leftRootVal);
        int leftSize = leftRootIndex - postStart + 1;
        
        // Build left and right subtrees
        root.left = build(pre, preStart + 1, preStart + leftSize, post, postStart, leftRootIndex);
        root.right = build(pre, preStart + leftSize + 1, preEnd, post, leftRootIndex + 1, postEnd - 1);
        
        return root;
    }
}