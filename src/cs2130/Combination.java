package cs2130;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class Combination {

    private ArrayList<Integer> combinationSet;
    private int subsetLength;
    private ArrayList<Integer> currentCombination;

    public Combination(Collection<Integer> values, int subsetLen) {
        TreeSet<Integer> set = new TreeSet<>(values); //sort and remove duplicates
        combinationSet = new ArrayList<>(set);
        subsetLength = subsetLen;
        currentCombination = new ArrayList<>(subsetLength);
        resetCombination();
    }

    public void resetCombination() {
        currentCombination.clear();
        currentCombination.addAll(combinationSet.subList(0, subsetLength));
    }

    public ArrayList<Integer> getCombination() {
        return new ArrayList<>(currentCombination);
    }

    public void setCombination(Collection<Integer> combo){
        TreeSet<Integer> set = new TreeSet<>(combo); //sort and remove duplicates
        if (set.size() != subsetLength){
            return;
        }
        for(Integer value:set){
            if (!combinationSet.contains(value)) {
                return;
            }
        }
        currentCombination.clear();
        currentCombination.addAll(set);
    }

    public void printAllCombinations() {
        //TODO: Make sure you start at the beginning (see the
        // resetCombination method)
        resetCombination();
        int iterations = 0;
        //TODO: Print combination
        System.out.println(currentCombination);
        do {
            //TODO: Generate a next Combination
            System.out.println(nextCombination());
            //TODO: Repeat
            iterations++;
        } while (iterations < numberOfCombinations()-1);
    }

    public ArrayList<Integer> nextCombination() {
        int startPos = 0;
        int mismatch = 0;
        //TODO: Move from right to left in both the
        // currentCombination and the combinationSet
        // until the numbers do not match.
        for(int i = 0; i < currentCombination.size(); i++) {
            if(currentCombination.get(currentCombination.size()-1-i) != combinationSet.get(combinationSet.size()-1-i)) {
                int tempValue = currentCombination.get(currentCombination.size() - 1 - i);
                mismatch = currentCombination.size() - 1 - i;
                for(int j = 0; j < combinationSet.size(); j++) {
                    if(combinationSet.get(j) == tempValue) {
                        startPos = j + 1;
                        break;
                    }
                }
                break;
            }
        }
        //Fill in
        // from left to right in the currentCombination
        // starting at the position of the mismatch the
        // numbers from the combinationSet starting at
        // the startPos you just found
        for(int i = 0; i < currentCombination.size() - mismatch; i++) {
            currentCombination.set(mismatch + i, combinationSet.get(startPos + i));
        }

        
        //TODO: If there was no mismatch start combination over at the
        // first subset. (see the resetCombination method)
        return new ArrayList<>(currentCombination);

    }

    private int factorial(int num) {
        int result = num;

        for(int i = result-1; i > 0; i--) {
            result *= i;
        }
        
        return result;
    }

    public int numberOfCombinations() {
        return ((factorial(combinationSet.size())) / (factorial(currentCombination.size())*(factorial(combinationSet.size() - currentCombination.size()))));
    }

}
