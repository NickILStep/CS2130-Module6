package cs2130;

import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.TreeSet;
// import java.lang.Math;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // // Test List --------------------------------------------
        // ArrayList<Integer> testList = new ArrayList<Integer>();
        // for(int i = 0; i < 10; i++) {
        //     testList.add(i);
        // }
        // // ------------------------------------------------------

        // // Test Permutations ------------------------------------
        // Permutation test = new Permutation(testList);
        // System.out.println(test.getPermutation());
        // for(int i = 0; i < factorial(testList.size()); i++) {
        //     System.out.println(test.nextPermutation());
        // }
        // System.out.println();
        // test.printAllPermutations();
        // // ------------------------------------------------------

        // // Test Combinations ------------------------------------
        // Combination test = new Combination(testList, 5);
        // System.out.println(test.getCombination());
        // test.printAllCombinations();
        // // ------------------------------------------------------

        //TODO: Prompt user to input a set of positive integers (-1 to stop)
        System.out.println("Enter a set of positive integers one at a time. (Enter -1 to stop): ");
        ArrayList<Integer> numList = new ArrayList<Integer> ();
        Scanner input = new Scanner(System.in);
        boolean toContinue = true;
        int value;
        int targetSum;
        int subLength;
        while(toContinue) {
            value = input.nextInt();
            if(value >= 0) {
                numList.add(value);
            }
            else{
                toContinue = false;
            }
        }
        //TODO: Prompt user to enter a target sum
        System.out.println("Enter a target sum");
        targetSum = input.nextInt();
        //TODO: Prompt user to enter the subset length
        System.out.println("Enter the subset length");
        subLength = input.nextInt();
        //TODO: Use the combination class to find all subsets of length n that sum to x
        Combination comSet = new Combination(numList, subLength);
        for(int i = 0; i < comSet.numberOfCombinations(); i++) {
            int tempSum = 0;
            for(int j = 0; j < comSet.getCombination().size(); j++) {
                tempSum += comSet.getCombination().get(j);
            }
            if(tempSum == targetSum) {
                System.out.println(comSet.getCombination());
            }
            comSet.nextCombination();
        }
        //TODO: Use the permutation class to print all permutations of the set.
        Permutation perSet = new Permutation(numList);
        perSet.printAllPermutations();
    }

    // // For finding the number of all permutations of a set
    // private static int factorial(int num) {
    //     int result = num;

    //     for(int i = result-1; i > 0; i--) {
    //         result *= i;
    //     }
        
    //     return result;
    // }
    // // ---------------------------------------------------
}