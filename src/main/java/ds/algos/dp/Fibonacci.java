package ds.algos.dp;

public class Fibonacci {
    public int[] fib(int num) {
        int res[] = new int[num+1];
        res[1]=1;
//        fibRecursive(res, num);
        fibIterative(res, num);
        return res;
    }

    private void fibIterative(int[] res, int num) {
        for(int i=2; i<=num; i++) {
            res[i] = res[i-1] + res[i-2];
        }
    }

     private int fibRecursive(int[] res, int num) {
        if(num==0)
            return 0;
        if(num==1) {
            return 1;
        }
        if(res[num]  == 0)
            res[num] = fibRecursive(res, num-1) + fibRecursive(res, num-2);
        return res[num];
    }

}
