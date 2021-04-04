package com.bhavani.blogspot.medium.balancedBrackets;

import java.util.Scanner;
import java.util.Stack;

public class First {
//    public static boolean balancedBrackets(String str) {
//        Stack<Character> bracketQueue = new Stack<Character>();
//
//        for (int idx = 0; idx < str.length();++idx) {
//            Character curr_char = str.charAt(idx);
//            switch (curr_char) {
//                case '(', '{', '[' -> bracketQueue.push(curr_char);
//                case ')' -> {
//                    if (!bracketQueue.isEmpty() && bracketQueue.peek() == '(') {
//                        bracketQueue.pop();
//                    } else {
//                        return false;
//                    }
//                }
//                case '}' -> {
//                    if (!bracketQueue.isEmpty() && bracketQueue.peek() == '{') {
//                        bracketQueue.pop();
//                    } else {
//                        return false;
//                    }
//                }
//                case ']' -> {
//                    if (!bracketQueue.isEmpty() && bracketQueue.peek() == '[') {
//                        bracketQueue.pop();
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return bracketQueue.empty();
//    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> bracketQueue = new Stack<Character>();

        for (int idx = 0; idx < str.length();++idx) {
            Character curr_char = str.charAt(idx);
            switch (curr_char) {
                case '(' :
                case '{' :
                case '[' :
                    bracketQueue.push(curr_char);
                    break;
                case ')' :
                    if (!bracketQueue.isEmpty() && bracketQueue.peek() == '(') {
                        bracketQueue.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}' :
                    if (!bracketQueue.isEmpty() && bracketQueue.peek() == '{') {
                        bracketQueue.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']' :
                    if (!bracketQueue.isEmpty() && bracketQueue.peek() == '[') {
                        bracketQueue.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return bracketQueue.empty();
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String str = sc.next();
        boolean ans = balancedBrackets(str);
        System.out.println(ans);
        sc.close();

    }
}
