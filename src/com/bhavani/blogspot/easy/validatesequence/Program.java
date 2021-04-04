package com.bhavani.blogspot.easy.validatesequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (array.size() < sequence.size()) {
            return false;
        }

        int array_length = array.size();
        int sequence_length = sequence.size();

        for (int idx = 0,j=0;idx < sequence_length;++idx) {
            int currVal = sequence.get(idx);
            boolean isFound = false;
            for (;j<array_length;++j) {
                int arrVal = array.get(j);
                if (currVal == arrVal) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                return false;
            } else {
                int remaining_array_length = array_length - j + 1;
                int remaining_sequence_length = sequence_length - idx + 1;
                if (remaining_sequence_length > remaining_array_length) {
                    return false;
                }
                ++j;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        List<Integer> arr = new ArrayList<>(5);
        for (int idx = 0; idx < length; ++idx) {
            arr.add(sc.nextInt());
        }

        int seqLength = sc.nextInt();
        List<Integer> seq = new ArrayList<>(5);
        for (int idx = 0; idx < seqLength; ++idx) {
            seq.add(sc.nextInt());
        }

        boolean ans = isValidSubsequence(arr,seq);
        System.out.println(ans);

        sc.close();
    }
}
