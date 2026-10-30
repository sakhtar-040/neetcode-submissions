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
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        dfsHeight(root, diameter);
        return diameter[0];
    }

    private static int dfsHeight(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int leftHeight = dfsHeight(root.left, diameter);
        int rightHeight = dfsHeight(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
