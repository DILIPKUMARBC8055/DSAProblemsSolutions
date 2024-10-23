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

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> pendingNode = new LinkedList<>();
        Queue<TreeNode> parentNode = new LinkedList<>();
        root.val=0;
        pendingNode.add(root);
        while (!pendingNode.isEmpty()) {
            int size = pendingNode.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode parent = pendingNode.poll();
                parentNode.add(parent);
                if (parent.left != null) {
                    pendingNode.add(parent.left);
                    sum += parent.left.val;
                }
                if (parent.right != null) {
                    pendingNode.add(parent.right);
                    sum += parent.right.val;
                }
            }
            while (!parentNode.isEmpty()) {
                TreeNode updateNode = parentNode.poll();
                int childTotal = 0;
                if (updateNode.left != null) {
                    childTotal = updateNode.left.val;
                }
                if (updateNode.right != null) {
                    childTotal += updateNode.right.val;
                }
                if (updateNode.left != null) {
                    updateNode.left.val = sum - childTotal;
                }
                if (updateNode.right != null) {
                    updateNode.right.val = sum - childTotal;
                }
            }
        }
        return root;
    }
}
