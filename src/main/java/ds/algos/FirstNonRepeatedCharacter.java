package ds.algos;

public class FirstNonRepeatedCharacter {

    public static char firstNonRepeatedChar(String string) {

        char [] chars = new char[26];

        for(char c : string.toCharArray()) {

            chars[c-'a']++;

        }

        for (char c : string.toCharArray()) {
            if(chars[c-'a']==1) return c;
        }

        return '_';
    }
}
