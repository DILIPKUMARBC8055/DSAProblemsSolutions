/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        return helper(root, val, 1, depth);
    }

    public TreeNode helper(TreeNode root, int val, int currentDepth, int depth) {
        if (root == null) {
            return null;
        }
        if (currentDepth == depth - 1) {
            TreeNode leftNewNode = new TreeNode(val);
            TreeNode rightNewNode = new TreeNode(val);
            leftNewNode.left = root.left;
            rightNewNode.right = root.right;
            root.right = rightNewNode;
            root.left = leftNewNode;
            return root;
        }
        root.left = helper(root.left, val, currentDepth + 1, depth);
        root.right = helper(root.right, val, currentDepth + 1, depth);
        return root;
    }
}