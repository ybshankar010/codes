package com.bhavani.blogspot.misc;

public class Algo {
    public static int maxSubArraySum(int[] array) {
        int currentMax = Integer.MIN_VALUE,currSum = 0;

        for (int i = 0; i < array.length; i++) {
            currSum = currSum + array[i];
            if (currSum >  currentMax) {
                currentMax = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return currentMax;
    }

    public static void main(String[] args) {
        int [] arr = {-30,-20,-30};

        System.out.println(maxSubArraySum(arr));

    }
}
