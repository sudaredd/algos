package ds.algos.ice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubstringCalculator {
    public static void main(String[] args) {
        System.out.println(subStringCalculator("kincenvizh"));
        Set<String> set = new HashSet<>();
        subStringCalculator("kincenvizh", set);
        System.out.println(set.size());
    }


    public static long subStringCalculator(String s) {
        if (s == null || s.length() == 0)
            return 0L;
        int n = s.length();
        Set<String>[] sets = new Set[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sets[i].add(s.substring(j, n - (i - j)));
            }
        }
        return Arrays.stream(sets).map(s1 -> s1.size()).mapToLong(i -> i).sum();
    }

    public static void subStringCalculator(String s, Set<String> set) {
        if(s==null || s.isEmpty())
            return;

        if(!set.contains(s)) {
            set.add(s);
        }
        subStringCalculator(s.substring(1), set);

        subStringCalculator(s.substring(0, s.length()-1), set);

        if(s.length() >=2) {
            subStringCalculator(s.substring(1, s.length()-1), set);
        }

    }
}
