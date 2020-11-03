package ds.algos.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {

    Node left;
    Node right;
    private int val;

    public Node(int data) {
        this.val = data;
    }

    public int getVal() {
        return val;
    }

}

public class BinaryTreeAvgLevel {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(7);
        root.right = new Node(9);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.right = new Node(6);
        root.left.right.right = new Node(6);
        root.left.right.right.left = new Node(2);

        System.out.println(new BinaryTreeAvgLevel().avg(root));
        System.out.println(new BinaryTreeAvgLevel().avgWithMinSpace(root));
    }

    public List<Integer> avg(Node root) {
        Map<Integer, List<Integer>> data = new HashMap<>();
        collect(root, data, 0);
        int level = 0;
        List<Integer> result = new ArrayList<>();
        while (data.containsKey(level)) {
            List<Integer> vals = data.get(level++);

            int avg = vals.stream().mapToInt(i -> i).sum() / vals.size();
            result.add(avg);
        }
        return result;
    }


    public List<Integer> avgWithMinSpace(Node root) {

        Map<Integer, DataHolder> data = new HashMap<>();
        collectWithMinSpace(root, data, 0);
        int level = 0;
        List<Integer> result = new ArrayList<>();
        while (data.containsKey(level)) {
            result.add(data.get(level++).avg());
        }
        return result;
    }

    private void collect(Node node, Map<Integer, List<Integer>> data, int level) {

        if (node == null)
            return;

        data.computeIfAbsent(level, k -> new ArrayList()).add(node.getVal());
        collect(node.left, data, level + 1);
        collect(node.right, data, level + 1);

    }

    private void collectWithMinSpace(Node node, Map<Integer, DataHolder> data, int level) {

        if (node == null)
            return;

        data.computeIfAbsent(level, k -> new DataHolder()).addSum(node.getVal());
        collectWithMinSpace(node.left, data, level + 1);
        collectWithMinSpace(node.right, data, level + 1);

    }
}
