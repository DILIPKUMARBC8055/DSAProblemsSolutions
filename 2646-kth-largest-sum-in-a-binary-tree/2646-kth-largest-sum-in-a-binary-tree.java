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

    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        Queue<TreeNode> pendingNode = new LinkedList<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>();
        pendingNode.add(root);
        while (!pendingNode.isEmpty()) {
            int size = pendingNode.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode parent = pendingNode.poll();
                sum += parent.val;
                if (parent.left != null) {
                    pendingNode.add(parent.left);
                }
                if (parent.right != null) {
                    pendingNode.add(parent.right);
                }
            }
            maxHeap.add(sum);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.size() >= k ? maxHeap.poll() : -1;
    }
}
