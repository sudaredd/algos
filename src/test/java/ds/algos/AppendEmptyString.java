package ds.algos;

import org.junit.jupiter.api.Test;

public class AppendEmptyString {

    private static final String EMPTY_STRING = " ";

    @Test
    public void appendEmptyTest() {

        String str= "App";
        System.out.println("str:"+str);
        System.out.println("strLength:"+str.length());
        for(int i=str.length(); i<2505; i++) {
            str = str +  EMPTY_STRING;
        }
        System.out.println("str:"+str);
        System.out.println("strLength:"+str.length());
    }
}
