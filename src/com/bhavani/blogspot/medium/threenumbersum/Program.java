package com.bhavani.blogspot.medium.threenumbersum;

import java.util.*;

public class Program {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> matchedArrays = new ArrayList<>();
        for (int i = 0; i < array.length ; ++i) {
            int currVal = array[i];
            int currTargetSum = targetSum - currVal;
            for (int j = i+1,k=array.length-1;j<k;) {
                int currSum = array[j] + array[k];
                if (currSum == currTargetSum){
                    Integer[] ansArr = {array[i],array[j],array[k]};
                    matchedArrays.add(ansArr);
                    ++j;
                    --k;
                } else if (currSum < currTargetSum) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return matchedArrays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int []arr = new int[length];
        for (int idx = 0; idx < length; ++idx) {
            arr[idx] = sc.nextInt();
        }

        int targetSum = sc.nextInt();

        List<Integer[]> ans = threeNumberSum(arr,targetSum);
        for (Integer[] answerArr : ans) {
            System.out.println(Arrays.toString(answerArr));
        }

        sc.close();
    }
}
