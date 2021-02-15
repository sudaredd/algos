package ds.algos.bbg;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Example 1:
 * <p>
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 * <p>
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 * <p>
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * Constraints:
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {


    public static void main(String[] args) {

        List<String> e1 = asList("a", "b");
        List<String> e2 = asList("b", "c");
        double[] calcs = calcEquation(asList(e1, e2), new double[]{2.0, 3.0}, asList(asList("a", "c"), asList("b", "a"), asList("a", "e"), asList("a", "a"), asList("x", "x")));
        System.out.println(Arrays.toString(calcs));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result = new double[queries.size()];

        Map<String, Map<String, Double>> map = buildMap(equations, values);

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = dfs(query.get(0), query.get(1), new HashSet<>(), map);
        }
        return result;
    }

    private static double dfs(String start, String end, Set<String> visitedSet, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);

        visitedSet.add(start);
        Map<String, Double> edges = graph.get(start);
        for (Map.Entry<String, Double> entry : edges.entrySet()) {
            if (!visitedSet.contains(entry.getKey())) {
                double val = dfs(entry.getKey(), end, visitedSet, graph);
                if (val != -1.0) {
                    return entry.getValue() * val;
                }
            }
        }
        return -1.0;
    }

    private static Map<String, Map<String, Double>> buildMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String src = equation.get(0);
            String dest = equation.get(1);
            double val = values[i];
            map.computeIfAbsent(src, k -> new HashMap<>()).put(dest, val);
            map.computeIfAbsent(dest, k -> new HashMap<>()).put(src, 1 / val);
        }

        return map;
    }
}
