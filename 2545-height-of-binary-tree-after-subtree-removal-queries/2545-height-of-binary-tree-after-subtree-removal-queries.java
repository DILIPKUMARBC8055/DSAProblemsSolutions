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

    private int findHeight(TreeNode root, int level, int[] node_level, int[] node_height, int[][] top2_heights) {
        if (root == null) return 0;
        node_level[root.val] = level;
        int left = findHeight(root.left, level + 1, node_level, node_height, top2_heights);
        int right = findHeight(root.right, level + 1, node_level, node_height, top2_heights);
        int maxHeight = 1 + Math.max(left, right);
        node_height[root.val] = maxHeight;
        if (maxHeight > top2_heights[level][0]) {
            top2_heights[level][1] = top2_heights[level][0];
            top2_heights[level][0] = maxHeight;
        } else if (maxHeight > top2_heights[level][1]) {
            top2_heights[level][1] = maxHeight;
        }
        return maxHeight;
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = 100001;
        int node_level[] = new int[n];
        int node_height[] = new int[n];
        int top2_heights[][] = new int[n][2];
        int result[] = new int[queries.length];
        findHeight(root, 0, node_level, node_height, top2_heights);
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int level = node_level[node];

            int height = node_height[node];
            if (top2_heights[level][0] == height) {
                result[i] = top2_heights[level][1] + level - 1;
            } else {
                result[i] = top2_heights[level][0] + level - 1;
            }
        }
        return result;
    }
}
