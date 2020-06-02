package ds.algos.leetcode.medium;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        System.out.println("height is "+h);
        System.out.println("width is "+w);
        int res [][] = new int[h][w];
        for(int row=0; row<h; row++) {
            for(int col=0; col<w; col++) {
                if(row==0 && col==0) {
                    res[row][col]= grid[row][col];
                } else {
                 res[row][col] =grid[row][col] +  Math.min(row==0 ? Integer.MAX_VALUE: res[row-1][col],
                                                           col==0 ? Integer.MAX_VALUE: res[row][col-1]);
                }
            }
        }
        Arrays.stream(res).map(Arrays::toString).forEach(System.out::println);
        return res[h-1][w-1];
    }
}
