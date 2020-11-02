package ds.algos.bbg;

import java.util.*;

class Emp {
    String name;
    int amount;
    int mins;
    String city;

    public Emp(String name, int amount, int mins, String city) {
        this.name = name;
        this.amount = amount;
        this.mins = mins;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", mins=" + mins +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emp emp = (Emp) o;

        return name != null ? name.equals(emp.name) : emp.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

/**
 * Emp whose transaction is more than 1000 or
 * if employee made multiple transactions in 2 different cities in less than 60 mins
 */

public class BadEmps {

    public static void main(String[] args) {

        List<Emp> emps = Arrays.asList(
                new Emp("Andrea", 100, 10, "NYC"),
                new Emp("Andrea", 1001, 12, "NYC"),
                new Emp("Dan", 50, 10, "NYC"),
                new Emp("Kelly", 300, 40, "JC"),
                new Emp("Dan", 60, 40, "BOSTON")
        );

        System.out.println(new BadEmps().listBadEmps(emps));

    }

    List<Emp> listBadEmps(List<Emp> list) {
        List<Emp> badList = new ArrayList<>();
        Map<Emp, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Emp emp = list.get(i);
            if (emp.amount > 1000) {
                badList.add(emp);
            } else if(map.containsKey(emp)) {
                    int index = map.get(emp);
                    Emp oldRecord = list.get(index);
                    if(!oldRecord.city.equals(emp.city) && emp.mins - oldRecord.mins < 60) {
                        badList.add(emp);
                        badList.add(oldRecord);
                    }
                }

            map.put(emp, i);
        }
        return badList;
    }
}
