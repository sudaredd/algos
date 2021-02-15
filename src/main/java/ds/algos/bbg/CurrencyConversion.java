package ds.algos.bbg;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Parameters:
 *
 * array of currency conversion rates. E.g. ['USD', 'GBP', 0.77] which means 1 USD is equal to 0.77 GBP
 * an array containing a 'from' currency and a 'to' currency
 * Given the above parameters, find the conversion rate that maps to the 'from' currency to the 'to' currency.
 * Your return value should be a number.
 *
 * Example:
 * You are given the following parameters:
 *
 * Rates: ['USD', 'JPY', 110] ['US', 'AUD', 1.45] ['JPY', 'GBP', 0.0070]
 * To/From currency ['GBP', 'AUD']
 * Find the rate for the 'To/From' currency. In this case, the correct result is 1.89.
 */
public class CurrencyConversion {

    public static void main(String[] args) {
        double d = convertCurrency(asList(asList("US","JPY"),asList("US","AUD"), asList("JPY","GBP")), new double[]{110, 1.45, 0.0070},Arrays.asList("GBP","AUD") );
        System.out.println(d);
    }

    private static double convertCurrency(List<List<String>> currencies, double[] prices, List<String> fromTo) {
        Map<String, Map<String, Double>> graph = buildGraph(currencies, prices);

        return dfs(fromTo.get(0), fromTo.get(1), graph, new HashSet<>());
    }

    private static double dfs(String from, String to, Map<String, Map<String, Double>> graph, HashSet<String> visitedSet) {

        if(!graph.containsKey(from))
            return -1.0;

        if(graph.get(from).containsKey(to)) {
            return graph.get(from).get(to);
        }
        visitedSet.add(from);
        for(Map.Entry<String, Double> edge: graph.get(from).entrySet()) {
            if(!visitedSet.contains(edge.getKey())) {
                double res = dfs(edge.getKey(), to, graph, visitedSet);
                if(res != 1.0)
                    return edge.getValue() * res;
            }
        }

        return -1.0;
    }

    private static Map<String, Map<String, Double>> buildGraph(List<List<String>> currencies, double[] prices) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i=0; i<currencies.size(); i++) {
            List<String> curr = currencies.get(i);
            String from = curr.get(0);
            String to = curr.get(1);
            double price = prices[i];
            graph.computeIfAbsent(from, k->new HashMap<>()).put(to, price);
            graph.computeIfAbsent(to, k->new HashMap<>()).put(from, 1/price);
        }
        return graph;
    }
}
