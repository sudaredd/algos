package ds.algos.fb;

public class DataHolder {

    private int sum;
    private int count;

    public void addSum(int val) {
        sum+=val;
        count++;
    }

    public int avg() {
        return sum/count;
    }
}
