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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum[] = { 0 };
        helper(root, sum,false);
        return sum[0];
    }

    public void helper(TreeNode root, int sum[], boolean left) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (left)
                sum[0] += root.val;
            return;

        }
        helper(root.left, sum, true);
        helper(root.right, sum, false);
    }
}