package com.bhavani.blogspot.hard.largestRange;

import java.util.Arrays;
import java.util.Scanner;

public class First {

    public static int[] largestRange(int[] array) {
        if (array.length == 1) { return  new int[]{array[0],array[0]};}

        Arrays.sort(array);

        int[] ans = {-1,-1};
        int length = 0,maxLength = -1,currMinIdx = array.length,currMaxIndex = -1;
        for (int idx = 1;idx < array.length;++idx) {
            if ((array[idx] == array[idx-1] + 1) || (array[idx] == array[idx-1])) {
                currMinIdx = Math.min(currMinIdx,idx-1);
                currMaxIndex = idx;
                length = array[currMaxIndex] - array[currMinIdx];
            } else {
                if (length > maxLength ) {
                    maxLength = length;
                    if (length == 0) {
                        currMinIdx = idx;
                        currMaxIndex = idx;
                    }
                    ans = new int[]{array[currMinIdx], array[currMaxIndex]};
                    currMinIdx = array.length;
                    currMaxIndex = -1;
                    length = 0;
                }
            }
        }

        if (length > maxLength ) {
            ans = new int[]{array[currMinIdx], array[currMaxIndex]};
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numElements = sc.nextInt();
        int[] arr = new int[numElements];

        for (int i =0; i<numElements;++i) {
            arr[i] = sc.nextInt();
        }

        int[] ans = largestRange(arr);
        System.out.println(Arrays.toString(ans));

        sc.close();
    }
}
/*
12
1 11 3 0 15 5 2 4 10 7 12 6

23
19  -1  18  17  2  10  3  12  5  16  4  11  8  7  6  15  12  12  2  1  6  13  14
* */
