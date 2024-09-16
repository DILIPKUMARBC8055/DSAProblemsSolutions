/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> output = new ArrayList<>();
        distanceKHelper(root, target, k, output);
        return output;
    }

    public int distanceKHelper(TreeNode root, TreeNode target, int k, List<Integer> output) {
        if (root == null) {
            return -1;

        }
        if (root == target) {
            addAtDistance(root, k, output);
            return 0;
        }
        int leftHeight = distanceKHelper(root.left, target, k, output);
        if (leftHeight != -1) {
            if (leftHeight + 1 == k) {
                output.add(root.val);
                return -1;
            } else {
                addAtDistance(root.right, k - leftHeight - 2, output);
                return 1 + leftHeight;
            }
        }
        int rightHeight = distanceKHelper(root.right, target, k, output);
        if (rightHeight != -1) {
            if (rightHeight + 1 == k) {
                output.add(root.val);
                return -1;

            } else {
                addAtDistance(root.left, k - rightHeight - 2, output);
                return 1 + rightHeight;
            }
        }
        return -1;

    }

    public void addAtDistance(TreeNode root, int k, List<Integer> output) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            output.add(root.val);
            return;
        }
        addAtDistance(root.left, k - 1, output);
        addAtDistance(root.right, k - 1, output);
    }
}