package ds.algos.algorithms4.ch1;

/**
 * Array exercise. Write a code fragment that creates an N-by-N boolean array
 * a[][] such that a[i][j] is true if i and j are relatively prime (have no common factors),
 * and false otherwise.
 */
public class ArrayPrimeExerise {

    public static boolean[][] arrayPrimes(int rows, int columns) {
        boolean [] [] primeArray = new boolean[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                primeArray[i][j] = isPrime(i) && isPrime(j);
            }
        }
        return primeArray;
    }

    private static boolean isPrime(int p) {
        if(p < 2) return false;
        for(int i=2; i <= p/2; i++) {
            if(p%i==0)
                return false;
        }
        return true;
    }
}
