package ds.algos.dp;

import java.util.*;

public class AllConstruct {

    public static void main(String[] args) {
        System.out.println(allConstruct("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(allConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println("---------------------------------------------------------");

        System.out.println("--------------------with memo----------------------");
        System.out.println(allConstructMemo("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"), new HashMap<>()));
        System.out.println(allConstructMemo("purple", Arrays.asList("purp", "p", "ur", "le", "purpl"), new HashMap<>()));
    }

    public static List<List<String>> allConstruct(String target, List<String> words) {

        List<List<String>> list = new LinkedList<>();
        if(target == null || target.isEmpty()) {
            list.add(new LinkedList<>());
            return list;
        }

        for (String word : words) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> res = allConstruct(suffix, words);
                for(List row : res) {
                    row.add(0, word);
                    list.add(row);
                }
            }
        }
        return list;
    }

    public static List<List<String>> allConstructMemo(String target, List<String> words, Map<String, List<List<String>>> memo) {

        List<List<String>> list = new LinkedList<>();
        if(target == null || target.isEmpty()) {
            list.add(new LinkedList<>());
            return list;
        }

        if(memo.containsKey(target)) {
            return memo.get(target);
        }

        for (String word : words) {
            if(target.startsWith(word)) {
                String suffix = target.substring(word.length());
                List<List<String>> res = allConstructMemo(suffix, words, memo);
                for(List row : res) {
                    row.add(0, word);
                    list.add(new ArrayList<>(row));
                }
            }
        }
//        List<List<String>> l = new LinkedList<>();
//        for (List<String> strings : list) {
//            l.add(new ArrayList(strings));
//        }
        memo.put(target, list);
        return list;
    }
}
