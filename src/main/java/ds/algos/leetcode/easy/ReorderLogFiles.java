package ds.algos.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderLogFiles {

    public static void main(String[] args) {
        String a = "let2 own kit dig";
        String b = "let3 art zero";
        String s1 = a.substring(a.indexOf(" ") + 1);
        String s2 = b.substring(b.indexOf(" ") + 1);
        System.out.println(s1);
        System.out.println(s2);
        String logs[] = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(new ReorderLogFiles().reorderLogFiles(logs)));

    }
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length <=0) return logs;
        List<String>  letterL = new ArrayList<>();
        List<String>  digitL = new ArrayList<>();
        for(String log : logs) {
            String row[] = log.split(" ");
            if(Character.isDigit(row[1].charAt(0)))
                digitL.add(log);
            else
                letterL.add(log);
        }
        Collections.sort(letterL, (a, b)->{
            String s1 = a.substring(a.indexOf(" ") + 1);
            String s2 = b.substring(b.indexOf(" ") + 1);
           return s1.equals(s2) ? a.compareTo(b) : s1.compareTo(s2);
        });
        letterL.addAll(digitL);
        return letterL.toArray(new String[letterL.size()]);
    }
}
