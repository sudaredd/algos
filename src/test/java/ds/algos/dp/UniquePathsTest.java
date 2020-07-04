package ds.algos.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsTest {

    @Test
    void uniquePaths() {
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(3, 4);
        System.out.println(result);
        assertEquals(10, result);
    }

    @Test
    void uniquePathsWithObstacles() {
        UniquePaths uniquePaths = new UniquePaths();

        int obstacleMatrix[][] = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 0},
        };
        int result = uniquePaths.uniquePathsWithObstacles(obstacleMatrix, 3, 4);

        assertEquals(3, result);

        obstacleMatrix = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 0},
        };
        result = uniquePaths.uniquePathsWithObstacles(obstacleMatrix, 3, 4);

        assertEquals(0, result);
    }

    @Test
    void maxProfitPaths() {

        int matrx[][] = new int[][] {
                {1, 3, 1, 1, 2},
                {2, 1, 1, 1, 1},
                {5, 4, 4, 2, 0}
        };

        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.maxProfitPaths(matrx);
        System.out.println("propfit is :" + result);
        assertEquals(18, result);

    }
}