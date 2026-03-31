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
    int postIndex;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;
        int val = postorder[postIndex--];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);

        root.right=helper(inorder, postorder, index + 1, right);
        root.left= helper(inorder, postorder, left, index - 1);
        return root;
    }
}