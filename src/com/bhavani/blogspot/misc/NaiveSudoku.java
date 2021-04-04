package com.bhavani.blogspot.misc;

import java.util.Arrays;

public class NaiveSudoku {

    public static int[][] grid = {
            { 0, 0, 0, 8, 0, 0, 0, 0, 9 },
            { 0, 1, 9, 0, 0, 5, 8, 3, 0 },
            { 0, 4, 3, 0, 1, 0, 0, 0, 7 },
            { 4, 0, 0, 1, 5, 0, 0, 0, 3 },
            { 0, 0, 2, 7, 0, 4, 0, 1, 0 },
            { 0, 8, 0, 0, 9, 0, 6, 0, 0 },
            { 0, 7, 0, 0, 0, 6, 3, 0, 0 },
            { 0, 3, 0, 0, 7, 0, 0, 8, 0 },
            { 9, 0, 4, 5, 0, 0, 0, 0, 1 }
    };


    public static boolean canFitInRow(int[][] grid,int row, int col,int val) {
        for (int idx=0;idx<grid[0].length;++idx) {
            if (grid[row][idx] == val) {
                return false;
            }
        }
        return true;
    }

    public static boolean canFitInColumn(int[][] grid, int row, int col, int val) {
        for (int idx=0;idx<grid[0].length;++idx) {
            if (grid[idx][col] == val) {
                return false;
            }
        }
        return true;
    }

    public static boolean canFitInSubGrid(int[][] grid, int row, int col,int val) {

        int startRow = row - row%3,startCol = col-col%3;
        for (int row_idx =0;row_idx<3;++row_idx) {
            for (int col_idx =0;col_idx<3;++col_idx) {
                if (grid[startRow+row_idx][startCol+col_idx] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean validGrid(int[][] grid, int row, int col, int val) {
        return canFitInRow(grid,row,col,val) && canFitInColumn(grid,row,col,val) && canFitInSubGrid(grid,row,col,val);
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
                boolean canSolveSudoku = solveSudoku(grid,row,col+1);
                if (canSolveSudoku) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        solveSudoku(grid,0,0);
        for (int[] row:grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
