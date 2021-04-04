package com.bhavani.blogspot.cisco;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LonePrime {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        //string containing comma separated numbers
        String inputString = scan.nextLine();
        scan.close();

        /* Enter your code here. Print the lonely prime number to STDOUT */

        String[] tokens = inputString.split(",");
        int[] array = new int[tokens.length];
        int[] copy = new int[tokens.length];
        int maxVal = 0;
        for (int idx =0;idx < tokens.length;++idx) {
            array[idx] = Integer.parseInt(tokens[idx]);
            copy[idx] = array[idx];
            if (array[idx] > maxVal) {
                maxVal = array[idx];
            }
        }

        for (int idx =2;idx < Math.sqrt(maxVal);++idx) {
            for (int j =0;j<array.length;++j) {
                if (array[j] != idx && array[j] % idx == 0) {
                    array[j] = array[j] / idx;
                }
            }
        }

        Set<Integer> primeSet = new HashSet<>(10);
        for (int idx =0;idx < array.length;++idx) {
            if (array[idx] == copy[idx]) {
                if (primeSet.contains(copy[idx])) {
                    primeSet.remove(copy[idx]);
                } else {
                    primeSet.add(copy[idx]);
                }
            }
        }

        for (Integer val:primeSet) {
            System.out.println(val);
        }
    }
}
