package ds.algos.algorithms4.ch1;

public class NFactorial {

    public static int nFactorial(int n) {
        return n <=1 ? 1 : n * nFactorial(n-1);
    }

}
