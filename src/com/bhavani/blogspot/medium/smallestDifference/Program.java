package com.bhavani.blogspot.medium.smallestDifference;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int[] ans = new int[]{};
        int minValue = Integer.MAX_VALUE;
        for (int j : arrayOne) {
            for (int k : arrayTwo) {
                int currMin = Math.abs(j - k);
                if (minValue > currMin) {
                    ans = new int[]{j, k};
                    minValue = currMin;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lenOne = sc.nextInt();
        int[] arrOne = new int[lenOne];
        for (int idx = 0;idx<lenOne;++idx) {
            arrOne[idx] = sc.nextInt();
        }

        int lenTwo = sc.nextInt();
        int[] arrTwo = new int[lenTwo];
        for (int idx=0;idx < lenTwo;++idx) {
            arrTwo[idx] = sc.nextInt();
        }

        int[] ans = smallestDifference(arrOne,arrTwo);
        System.out.println(Arrays.toString(ans));

        sc.close();
    }
}
