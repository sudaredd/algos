package ds.algos.fb;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Design a data structure for History Set with following operations:
 * <p>
 * Add(element) : Adds an element to the Set and returns a SequenceId
 * Discard(element): Discards an element from the Set and returns a SequenceId
 * Member(sequenceId): Return the state of historySet at a given sequenceId
 * Example:
 * seq1 = add("a")
 * seq2 = add("b")
 * seq3 = add("c")
 * seq4 = discard("b")
 * <p>
 * member(seq3) = ("a", "b", "c")
 * member(seq1) = ("a")
 * member(seq4) = ("a", "c")
 */
public class HistorySet {

    private Map<Integer, String> addMap = new HashMap<>();
    private Map<Integer, String> removeMap = new HashMap<>();
    private int id;

    public static void main(String[] args) {
        HistorySet historySet = new HistorySet();
        historySet.add("a");
        historySet.add("b");
        historySet.add("c");
        historySet.discard("b");

        System.out.println(historySet.member(3));
        System.out.println(historySet.member(1));
        System.out.println(historySet.member(4));
    }

    public void add(String val) {
        addMap.put(++id, val);
    }

    public void discard(String val) {
        removeMap.put(++id, val);
    }

    public Set<String> member(int index) {
        Set<String> set = new LinkedHashSet<>();

        for (int i = 1; i <= index; i++) {

            if (addMap.containsKey(i)) {
                set.add(addMap.get(i));
            } else if (removeMap.containsKey(i)) {
                set.remove(removeMap.get(i));
            }
        }

        return set;
    }
}
