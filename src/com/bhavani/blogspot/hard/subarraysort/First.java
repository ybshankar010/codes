package com.bhavani.blogspot.hard.subarraysort;

import java.util.Arrays;
import java.util.Scanner;

public class First {

    public static int[] subarraySort(int[] array) {
        int[] ans = {-1,-1};
        for (int i = 0 ;i< array.length;++i) {
            int curr_element = array[i];
            for (int j=i+1;j < array.length;++j) {
                if (curr_element > array[j]) {
                    array[i] = array[j];
                    array[j] = curr_element;
                    if (ans[0] == -1 || ans[0] > i) {
                        ans[0] = i;
                    }

                    if (ans[1] == -1 || ans[1] < j) {
                        ans[1] = j;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[] array = new int[length];
        for (int idx = 0;idx<length;++idx) {
            array[idx] = scanner.nextInt();
        }

        int[] ans = subarraySort(array);
        System.out.println(Arrays.toString(ans));

        scanner.close();
    }
}
