package ds.algos.tree;

public class ValidateBinaryTree {

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer maxValue, Integer minValue) {
        if(root == null)
            return true;

        if(maxValue != null && root.val >= maxValue || minValue!= null && root.val <= minValue)
            return false;

        return isValidBST(root.left, root.val, minValue) && isValidBST(root.right, maxValue, root.val);
    }
}
