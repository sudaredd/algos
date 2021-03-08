package ds.algos.bbg;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

record E(int qty, String name) {};

public class Test {

    public static void main(String[] args) {
        List<E> list = asList(new E(10, "darsan"), new E(20, "2arsan"),
                new E(30, "3arsan"), new E(40, "4arsan"));
        E result = list.stream()
                .reduce(list.get(0), (e1, e2) -> {
                    System.out.println("e1::"+e1);
                    System.out.println("e2::"+e2);
                return    e1.qty() > e2.qty() ? e1 : e2;
                });
        System.out.println(result);

        System.out.println(list.stream().map(E::qty).reduce(0, (e1,e2)->e1+e2));
        System.out.println(list.stream().map(E::qty).reduce(12, (e1,e2)->e1+e2));
    }
}

