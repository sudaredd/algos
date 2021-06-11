package ds.algos.amazon;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("VIII"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("IX"));
    }
    public static int romanToInt(String s) {
        //MCMXCIV
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int val = 0;

        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                val += map.get(s.charAt(i));
            } else if(map.get(s.charAt(i)) > map.get(s.charAt(i+1))) {
                val += map.get(s.charAt(i));
            } else {
                val -=map.get(s.charAt(i));
            }
        }
        return val + map.get(s.charAt(s.length()-1));

    }
}
