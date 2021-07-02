package ds.algos.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p>
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 */
public class RandomisedSet {

    public static void main(String[] args) {
        RandomisedSet randomisedSet = new RandomisedSet();
        System.out.println(randomisedSet.insert(1));
        System.out.println(randomisedSet.remove(2));
        System.out.println(randomisedSet.insert(2));
        System.out.println(randomisedSet.getRandom());
        System.out.println(randomisedSet.remove(1));
        System.out.println(randomisedSet.insert(2));
        System.out.println(randomisedSet.getRandom());
    }

    private Map<Integer, Integer> map = new HashMap<>();

    private List<Integer> list = new ArrayList<>();

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {

        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int pos = map.remove(val);
            int lastIndex = list.size() - 1;
            if (pos < lastIndex) {
                int finalVal = list.get(lastIndex);
                list.set(pos, finalVal);
                map.put(finalVal, list.size());
            }
            list.remove(lastIndex);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

        return list.get(new Random().nextInt(list.size()));
    }
}
