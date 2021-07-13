package ds.algos.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point
 * to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class PopulateNextNodesByLevel {

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        TreeLinkNode res = new PopulateNextNodesByLevel().connect(root);
        System.out.println(res);
    }

    public TreeLinkNode connect(TreeLinkNode root) {
       TreeLinkNode levelStart = root;
       while (levelStart != null) {
           TreeLinkNode curr = levelStart;
           while (curr != null) {
               if(curr.left != null) {
                   curr.left.next = curr.right;
               }
               if(curr.right != null && curr.next != null) {
                   curr.right.next = curr.next.left;
               }
               curr = curr.next;
           }
           levelStart = levelStart.left;
       }
       return root;
    }

    static class TreeLinkNode {
        public int val;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;

        public TreeLinkNode() {
        }

        public TreeLinkNode(int _val) {
            val = _val;
        }

        public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "TreeLinkNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
        }
    }
}
