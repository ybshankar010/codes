package com.bhavani.blogspot.easy.closestValueInBST;

import java.util.Scanner;

public class First {

    public static int findClosestValueInBst(BST tree, int target) {
        if (tree == null) {
            return -1;
        }

        int rootVal = tree.value;
        int rootDiff = Math.abs(target - rootVal);
        int leftVal = findClosestValueInBst(tree.left,target);
        int rightVal = findClosestValueInBst(tree.right,target);


        if (leftVal == -1 && rightVal == -1) {
            return rootVal;
        }

        int rightDiff = Integer.MAX_VALUE,leftDiff = Integer.MAX_VALUE;
        if (rightVal != -1) {
            rightDiff = Math.abs(target - rightVal);
        }

        if (leftVal != -1) {
            leftDiff = Math.abs(target - leftVal);
        }

        return ((rootDiff < leftDiff) ? ((rootDiff < rightDiff) ? rootVal : rightVal): ((leftDiff < rightDiff)?leftVal:rightVal));
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST insert(BST root, BST nodeToInsert) {
        if (root == null) {
            return nodeToInsert;
        }

        int rootVal = root.value;
        int currVal = nodeToInsert.value;

        if (rootVal < currVal) {
            root.right = insert(root.right,nodeToInsert);
        } else {
            root.left = insert(root.left,nodeToInsert);
        }

        return root;
    }

    public static void main(String[] args) {
        BST root = null;

        Scanner sc = new Scanner(System.in);
        int nextEle = sc.nextInt();

        while (nextEle != -1) {
            BST currNode = new BST(nextEle);
            root = insert(root,currNode);
            nextEle = sc.nextInt();
        }

        System.out.println("Tree is completed");

        int target = sc.nextInt();
        int ans = findClosestValueInBst(root,target);
        System.out.println(ans);

        sc.close();
    }
}
