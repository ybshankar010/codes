package com.bhavani.blogspot.easy.twonumbersum;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int []ans = new int[2];
        boolean found = false;

        for (int i=0,j=array.length-1;i<j && !found;){
            int currSum = array[i] + array[j];
            if (currSum == targetSum) {
                ans[0] = array[i];
                ans[1] = array[j];
                found = true;
            } else if (currSum > targetSum) {
                --j;
            } else {
                ++i;
            }
        }

        return found ? ans : new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int []arr = new int[length];
        for (int idx = 0; idx < length; ++idx) {
            arr[idx] = sc.nextInt();
        }

        int targetSum = sc.nextInt();

        int []ans = twoNumberSum(arr,targetSum);
        System.out.println(Arrays.toString(ans));

        sc.close();
    }
}
