package com.bhavani.blogspot.hard.fourNumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class First {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> ans = new ArrayList<>(5);
        for (int i=0;i<array.length;++i) {
            int sum_without_first = targetSum - array[i];
            for (int j=i+1;j<array.length;++j) {
                int sum_without_second = sum_without_first - array[j];
                for (int p=j+1,q=array.length-1;p<q;){
                    int curr_sum = array[p] + array[q];
                    if (curr_sum == sum_without_second) {
                        Integer[] answer_array = {array[i],array[j],array[p],array[q]};
                        ans.add(answer_array);
                        ++p;
                        --q;
                    } else if (curr_sum > sum_without_second) {
                        --q;
                    } else {
                        ++p;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int idx = 0;idx < n;++idx) {
            arr[idx] = sc.nextInt();
        }
        int targetSum = sc.nextInt();

        List<Integer[]> ans = fourNumberSum(arr,targetSum);
        for (Integer[] itr : ans) {
            System.out.println(Arrays.toString(itr));
        }

        sc.close();
    }
}
