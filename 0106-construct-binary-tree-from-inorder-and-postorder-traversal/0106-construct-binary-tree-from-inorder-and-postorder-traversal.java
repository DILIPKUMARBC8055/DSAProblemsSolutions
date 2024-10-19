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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int rootIndexInOrder = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == postOrder[postEnd]) {
                rootIndexInOrder = i;
                break;
            }
        }
        int leftSubtreeSize = rootIndexInOrder - inStart;

        int leftInStart = inStart;
        int leftInEnd = rootIndexInOrder - 1;
        int leftPostStart = postStart;
        int leftPostEnd = postStart + leftSubtreeSize - 1;
        root.left = helper(inOrder, leftInStart, leftInEnd, postOrder, leftPostStart, leftPostEnd);
        int rightInStart = rootIndexInOrder + 1;
        int rightInEnd = inEnd;
        int rightPostStart = postStart + leftSubtreeSize;
        int rightPostEnd = postEnd - 1;

        root.right = helper(inOrder, rightInStart, rightInEnd, postOrder, rightPostStart, rightPostEnd);
        return root;
    }
}
