package ds.algos.leetcode.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class NestedIterator implements Iterator<Integer> {

    LinkedList<NestedInteger> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        queue.addAll(nestedList);
    }

    @Override
    public Integer next() {
        return queue.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!queue.isEmpty()) {
            NestedInteger nestedInteger = queue.peek();
            if (nestedInteger.isInteger()) {
                return true;
            }
            queue.poll();
            List<NestedInteger> list = nestedInteger.getList();
            for(int i = list.size()-1; i>=0; i--) {
                queue.addFirst(list.get(i));
//                queue.add(i, nestedInteger.getList().get(i));
            }
//            queue.addAll(nestedInteger.getList());
        }
        return false;
    }
}
