package ds.algos.leetcode.medium;

/**
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 *
 */
public class AnagramMinSteps {

    public static int minSteps(String s, String t) {

        int sChars[] = new int[26];

        for(int i=0; i<s.length(); i++) {
            sChars[s.charAt(i)-'a']++;
            sChars[t.charAt(i)-'a']--;
        }

        int total = 0;
  /*      for(int i=0; i<s.length(); i++) {

            if(sChars[s.charAt(i)-'a'] > 0 ){
                total = total + sChars[s.charAt(i)-'a'];
                sChars[s.charAt(i)-'a']=0;
            }
        }*/

        for(int i=0; i<26; i++) {
            if(sChars[i]>0)
                total +=sChars[i];
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(minSteps("bab", "aba") + " :"+1);
        System.out.println(minSteps("leetcode", "practice") + " :"+5);
        System.out.println(minSteps("anagram", "mangaar") + " :"+0);
        System.out.println(minSteps("xxyyzz", "xxyyzz") + " :"+0);
        System.out.println(minSteps("friend", "family") + " :"+4);
    }
}
