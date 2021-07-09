package ds.algos.practice;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}

public class BinaryTree {

    TreeNode root;

    public void insert(int val) {
        TreeNode treeNode = new TreeNode(val);

        if (root == null) {
            root = treeNode;
            return;
        }
        TreeNode current = root;
        TreeNode prev = current;

        while (current != null) {
            if (val > current.val) {
                prev = current;
                current = current.right;
            } else {
                prev = current;
                current = current.left;
            }
        }
        if (prev.val < val) {
            prev.right = treeNode;
        } else {
            prev.left = treeNode;
        }
    }

    public void delete(TreeNode root, int val) {
        TreeNode current = root;
        TreeNode parent = current;

        while (current != null && current.val != val) {
            parent = current;
            if (val > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (current.left == null && current.right == null) {
            if (parent.left == current) {
                parent.left = null;
            } else if (parent.right == current) {
                parent.right = null;
            }
        } else if (current.left != null && current.right != null) {
            TreeNode predecessorRightNode = findPredecessorRightNode(current.left);
            int maxVal = predecessorRightNode.val;
            delete(current, maxVal);
            current.val = maxVal;
        } else {
            TreeNode temp = current.left != null ? current.left : current.right;
            if (parent.left == current) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
        }
    }

    private TreeNode findPredecessorRightNode(TreeNode node) {
        TreeNode parent = node;
        TreeNode current = node;
        while (current != null) {
            parent = current;
            current = current.right;
        }
        return parent;
    }

    public TreeNode search(int val) {
        TreeNode current = root;
        while (current != null && current.val != val) {
            if (val > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return current;
    }

    public void inOrder(TreeNode treeNode, List<Integer> vals) {
        if (treeNode == null)
            return;
        inOrder(treeNode.left, vals);
        vals.add(treeNode.val);
        inOrder(treeNode.right, vals);
    }

    public int sumAtKLevel(TreeNode treeNode, int k) {
        if (treeNode == null) {
            return 0;
        }
        if (k == 1) {
            return treeNode.val;
        }
        return sumAtKLevel(treeNode.left, k - 1) + sumAtKLevel(treeNode.right, k - 1);
    }
}
