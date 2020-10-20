package ds.algos.bbg;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TopKStockTicker {


    private ConcurrentMap<String, Double> stockMap = new ConcurrentHashMap<>();

    private Queue<Map.Entry<String, Double>> kPriorityQueue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));

    int topN;

    public TopKStockTicker(int topN) {

        this.topN = topN;
    }


    public void addOrUpdateStock(String stock, double price) {

        stockMap.compute(stock, (k, v) -> v == null ? price : v + price);

    }

    public List<Map.Entry<String, Double>> topK() {

        kPriorityQueue.clear();
        for (Map.Entry<String, Double> entry : stockMap.entrySet()) {

            if (kPriorityQueue.size() < topN) {
                kPriorityQueue.offer(entry);
            } else if (kPriorityQueue.peek().getValue() < entry.getValue()) {
                kPriorityQueue.poll();
                kPriorityQueue.offer(entry);
            }

        }

        return new ArrayList(kPriorityQueue);
    }

    public static void main(String[] args) {
        TopKStockTicker topKStockTicker = new TopKStockTicker(3);
        topKStockTicker.addOrUpdateStock("a",100.0);
        topKStockTicker.addOrUpdateStock("b",110.0);
        topKStockTicker.addOrUpdateStock("c",120.0);

        System.out.println(topKStockTicker.topK());

        topKStockTicker.addOrUpdateStock("d",130.0);
        topKStockTicker.addOrUpdateStock("d",140.0);

        System.out.println(topKStockTicker.topK());
    }

}
