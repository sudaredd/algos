package ds.algos.amazon;

// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
//     2
//    / \
//   1   3
// Binary tree [2,1,3], return true.
// Example 2:
//     1
//    / \
//   2   3
// Binary tree [1,2,3], return false.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);

        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null)
            return true;

        if (root.val <= minValue || root.val >= maxValue)
            return false;

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);

    }


}
