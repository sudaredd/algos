package ds.algos.amazon;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

   static Map<Integer, String> map = new HashMap();
    static String host = "http://tinyurl.com/";

    public static void main(String[] args) {
        System.out.println(encode("https://linkedin.com/profile/sudaredd/view"));
        System.out.println(decode("http://tinyurl.com/276703213"));
    }

    public static String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return host+key;
    }

    public static String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replaceAll(host,"")));
    }

}
