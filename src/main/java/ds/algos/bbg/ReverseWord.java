package ds.algos.bbg;

/**
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 */
public class ReverseWord {

    public static void main(String[] args) {
        System.out.println(new ReverseWord().reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {

        char []chars = s.trim().toCharArray();

        reverse(chars, 0, chars.length);
        int begin = 0;
        for(int i=0; i<chars.length; i++) {
            if(chars[i]==' ') {
                reverse(chars, begin, i);
                begin = i+1;
            }
        }
        reverse(chars, begin, chars.length);


        return new String(chars);

    }

    private void reverse(char[] chars, int start, int end) {
        while (start<end) {
            char temp = chars[start];
            chars[start]=chars[end-1];
            chars[end-1]=temp;
            start++;
            end--;
        }
    }
}
