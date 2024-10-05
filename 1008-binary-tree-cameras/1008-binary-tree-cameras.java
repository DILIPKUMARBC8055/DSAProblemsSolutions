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
    int convered = 1;
    int needCamera = -1;
    int haveCamera = 0;
    int cameras;

    public int minCameraCover(TreeNode root) {
        cameras = 0;
        if (helper(root) == needCamera) cameras++;
        return cameras;
    }

    public int helper(TreeNode root) {
        if (root == null) return convered;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == needCamera || right == needCamera) {
            cameras++;
            return haveCamera;
        }
        if (left == haveCamera || right == haveCamera) {
            return convered;
        }

        return needCamera;
    }
}
