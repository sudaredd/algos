package ds.algos.dp;

import java.util.HashMap;
import java.util.Map;

public class GridTravelor {

    public static void main(String[] args) {
        System.out.println(new GridTravelor().gridTravelor(2, 3));
        System.out.println(new GridTravelor().gridTravelor(5, 5));
        System.out.println(new GridTravelor().gridTravelorWithMemorization(2, 3, new HashMap<>()));
        System.out.println(new GridTravelor().gridTravelorWithMemorization(18, 18, new HashMap<>()));
    }

    private long gridTravelor(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        return gridTravelor(m - 1, n) + gridTravelor(m, n - 1);
    }

    private long gridTravelorWithMemorization(int m, int n, Map<String, Long> map) {

        String key = m + "_" + n;
        if (map.containsKey(key))
            return map.get(key);
        
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
       
        long res = gridTravelorWithMemorization(m - 1, n, map) + gridTravelorWithMemorization(m, n - 1, map);
        map.put(key, res);
        return res;
    }
}
