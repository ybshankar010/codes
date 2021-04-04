package com.bhavani.blogspot.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OptimizedSudoku {
    public static int[][] grid = {
            { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
            { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
            { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
            { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
            { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
            { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
            { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
            { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
            { 7, 4, 5, 0, 8, 6, 3, 1, 0 }
    };

    private static Map<String,Integer[]> rowMap, colMap,boxMap;


    private static boolean validGrid(int[][] grid, int row, int col,int val) {

        Integer[] rowVals = rowMap.get(String.valueOf(row));
        if (rowVals[val -1] > 0) {
            return false;
        }

        Integer[] colVals = colMap.get(String.valueOf(col));
        if (colVals[val -1] > 0) {
            return false;
        }

        int startRow = (row - row%3)%3,startCol = (col-col%3)%3;
        Integer[] boxVals = boxMap.get(startRow+"_"+startCol);
        if (boxVals[val-1] > 0) {
            return false;
        }

        return true;
    }

    private static boolean solveSudoku(int[][] grid,int row,int col) {

        if (row == grid.length-1 && col == grid[0].length) {
            return true;
        }

        if (col == grid[0].length) {
            ++row;
            col = 0;
        }

        if (grid[row][col] != 0) {
            return solveSudoku(grid,row,col+1);
        }

        for (int num = 1;num < 10;++num) {

            if (validGrid(grid,row,col,num)) {

                grid[row][col] = num;

                Integer[] rowVals = rowMap.get(String.valueOf(row));
                ++rowVals[num-1];
                rowMap.put(String.valueOf(row),rowVals);


                Integer[] colVals = colMap.get(String.valueOf(col));
                ++colVals[num-1];
                colMap.put(String.valueOf(row),colVals);

                int startRow = (row - row%3),startCol = (col-col%3);
                Integer[] boxVals = boxMap.get(startRow+"_"+startCol);
                ++boxVals[num-1];
                boxMap.put(startRow+"_"+startCol,boxVals);

                boolean canSolveSudoku = solveSudoku(grid,row,col+1);
                if (canSolveSudoku) {
                    return true;
                }
                grid[row][col] = 0;

                rowVals = rowMap.get(String.valueOf(row));
                --rowVals[num-1];
                rowMap.put(String.valueOf(row),rowVals);


                colVals = colMap.get(String.valueOf(col));
                --colVals[num-1];
                colMap.put(String.valueOf(row),colVals);

                boxVals = boxMap.get(startRow+"_"+startCol);
                --boxVals[num-1];
                boxMap.put(startRow+"_"+startCol,boxVals);
            }
        }

        return false;
    }

    private static Map<String,Integer[]> initMap() {
        Map<String,Integer[]> map = new HashMap<>();

        for (int idx =0; idx<10;++idx) {
            map.put(String.valueOf(idx), new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        }

        return map;
    }


    private static void initMaps(int[][] grid) {
        for (int row = 0; row < grid.length;++row) {
            for (int col=0;col<grid[0].length;++col) {
                int val = grid[row][col];
                if (val == 0) {
                    continue;
                }

                Integer[] rowVals = rowMap.get(String.valueOf(row));
                ++rowVals[val-1];
                rowMap.put(String.valueOf(row),rowVals);


                Integer[] colVals = colMap.get(String.valueOf(col));
                ++colVals[val-1];
                colMap.put(String.valueOf(row),colVals);

                int startRow = (row - row%3),startCol = (col-col%3);
                Integer[] boxVals = boxMap.get(startRow+"_"+startCol);
                ++boxVals[val-1];
                boxMap.put(startRow+"_"+startCol,boxVals);
            }
        }
    }

    public static void main(String[] args) {
        rowMap = initMap();
        colMap = initMap();
        boxMap = new HashMap<>();
        for (int row = 0; row < 9; ++row) {
            for (int col=0;col < 9; ++col) {
                int start_row = (row - row %3),start_col=(col -col%3);
                boxMap.put(start_row+"_"+start_col,new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
            }
        }

        initMaps(grid);

        solveSudoku(grid,0,0);
        for (int[] row:grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
