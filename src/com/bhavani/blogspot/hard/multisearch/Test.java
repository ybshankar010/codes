package com.bhavani.blogspot.hard.multisearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
this is a big string
1
string
* */
public class Test {
    private static Boolean isAvailable(String bigString, String smallString) {

        int matchedCharacters = 0;
        for (int i = 0;i<bigString.length(); ++i) {

            matchedCharacters = 0;
            for (int j=0;(i+j)<bigString.length() && j < smallString.length();++j) {
                char bigStringChar = bigString.charAt(i+j);
                char smallStringChar = smallString.charAt(j);
                if (bigStringChar != smallStringChar) {
                    break;
                }
                ++matchedCharacters;
            }

            if (matchedCharacters == smallString.length()) {
                return true;
            }
        }
        return false;
    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

        List<Boolean> availability = new ArrayList<>();
        for (int idx = 0;idx < smallStrings.length;++idx) {
            availability.add(isAvailable(bigString,smallStrings[idx]));
        }
        return availability;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bigString = sc.nextLine();
        int numStrings = sc.nextInt();

        String[] smallStrings = new String[numStrings];
        for (int idx = 0;idx < numStrings;++idx) {
            smallStrings[idx] = sc.next();
        }

        List<Boolean> availableOrNot = multiStringSearch(bigString,smallStrings);
        System.out.println(Arrays.toString(availableOrNot.toArray()));
        sc.close();
    }
}
