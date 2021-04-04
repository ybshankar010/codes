package com.bhavani.blogspot.medium.moveToEnd;

import java.util.*;

public class First {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int i = 0, arrayLen = array.size(), j = arrayLen-1;
        while (i<j) {
            while (i< arrayLen && array.get(i) != toMove) {
                ++i;
            }

            while (j>0 && array.get(j) == toMove) {
                --j;
            }

            if (i < j) {
                int temp = array.get(i);
                array.set(i,array.get(j));
                array.set(j,temp);
            }
        }
        return array;
    }
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(0);
        Scanner sc = new Scanner(System.in);

        int nextEle = sc.nextInt();
        while (nextEle != -1) {
            array.add(nextEle);
            nextEle = sc.nextInt();
        }

        int toMove = sc.nextInt();

        List<Integer> ans = moveElementToEnd(array,toMove);
        System.out.println(Arrays.toString(ans.toArray()));
        sc.close();
    }
}

/*
2 1 2 2 2 3 4 2 2 -1
2
* */
