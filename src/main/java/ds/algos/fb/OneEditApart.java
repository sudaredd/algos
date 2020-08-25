package ds.algos.fb;

import java.util.logging.Logger;

/**
 * OneEditApart("cat", "dog") = false
 * OneEditApart("cat", "cats") = true
 * OneEditApart("cat", "cut") = true
 * OneEditApart("cat", "cast") = true
 * OneEditApart("cat", "at") = true
 * OneEditApart("cat", "act") = false
 */
public class OneEditApart {

    static Logger logger = Logger.getLogger("OneEditPart");
    public static void main(String[] args) {
        System.out.println(oneEditApart("cat", "dog") == false);
        System.out.println(oneEditApart("cat", "cats") == true);
        System.out.println(oneEditApart("cat", "cut") == true);
        System.out.println(oneEditApart("cat", "cast") == true);
        System.out.println(oneEditApart("cat", "at") == true);
        System.out.println(oneEditApart("cat", "act") == false);
    }

    private static boolean oneEditApart(String s1, String s2) {
        if(s2.length() > s1.length())
            return oneEditApart(s2, s1);

        if(s1.length() - s2.length() > 1)
            return false;

        boolean sawDifference = false;
        for(int i=0, j=0; i<s1.length() && j<s2.length(); i++, j++) {

            if(s1.charAt(i) != s2.charAt(j)) {
                if(sawDifference)
                    return false;
                sawDifference = true;
                if(s1.length() > s2.length())
                    j--;
            }
        }
        logger.info("true for s1: "+s1 +"  ,s2 : "+s2);
        return true;
    }
}
