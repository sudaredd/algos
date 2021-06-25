package ds.algos.airbnb;

class TreeNode {
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 6, 8, 9};

        TreeNode binaryTree = convertSortedArrayToBinarySearchTree(arr, 0, arr.length - 1);
        System.out.println(binaryTree);
    }

    private static TreeNode convertSortedArrayToBinarySearchTree(int[] arr, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode treeNode = new TreeNode(arr[mid]);
            treeNode.left = convertSortedArrayToBinarySearchTree(arr, left, mid-1);
            treeNode.right = convertSortedArrayToBinarySearchTree(arr, mid+1, right);
            return treeNode;
        }
        return null;
    }
}
