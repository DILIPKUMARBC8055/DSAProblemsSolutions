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
    int min1;
    int min2;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        min1 = root.val;
        min2 = -1;
        helper(root);
        return min2;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        helper(root.right);
        if (root.val < min1) {
            min2 = min1;
            min1 = root.val;

        } else if ((root.val > min1 && ( root.val < min2 || min2 == -1))) {
            min2 = root.val;
        }
    }
}