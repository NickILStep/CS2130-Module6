package cs2130;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class Permutation {

    private ArrayList<Integer> currentPermutation;
    private boolean skip = false;

    public Permutation(Collection<Integer> values) {
        TreeSet<Integer> set = new TreeSet<>(values); //sort and remove duplicates
        currentPermutation = new ArrayList<>(set);
        resetPermutation();
    }

    public void resetPermutation() {
        Collections.sort(currentPermutation);
    }

    public ArrayList<Integer> getPermutation() {
        return new ArrayList<>(currentPermutation);
    }

    public void setPermutation(Collection<Integer> perm){
        TreeSet<Integer> set = new TreeSet<>(perm); //sort and remove duplicates
        if (set.size() != currentPermutation.size() && set.size() != perm.size()){
            return;
        }
        for(Integer value:set){
            if (!currentPermutation.contains(value)) {
                return;
            }
        }
        currentPermutation.clear();
        currentPermutation.addAll(perm);
    }

    public void printAllPermutations() {
        //TODO: Make sure you start at the beginning (see the
        // resetPermutation method)
        resetPermutation();
        int iterations = 0;
        //TODO: Print permutation
        System.out.println(currentPermutation);
        do {
            //TODO: Generate a next permutation
            System.out.println(nextPermutation());
            //TODO: Repeat
            iterations++;
        } while(iterations < factorial(currentPermutation.size())-1);
    }

    public ArrayList<Integer> nextPermutation() {
        int pos1 = -1;
        int pos2 = -1;
        if(!skip) {
            //TODO: Move from right to left until the
            // current number is less than the previous one
            for(int i = currentPermutation.size()-1; i > 0; i--) {
                if(currentPermutation.get(i) > currentPermutation.get(i-1)) {
                    pos1 = i-1;
                    break;
                }
            }

            //TODO: Start at the right and find the first
            // number greater than current.
            for(int i = currentPermutation.size()-1; i > 0; i--) {
                if(currentPermutation.get(i) > currentPermutation.get(pos1)) {
                    pos2 = i;
                    break;
                }
            }

            //TODO: Swap the numbers
            int tempPos = currentPermutation.get(pos1);
            currentPermutation.set(pos1, currentPermutation.get(pos2));
            currentPermutation.set(pos2, tempPos);

            //TODO: Reverse the order of the numbers to the right of the swapped
            // value so that they are in increasing order.
            ArrayList<Integer> tempList = new ArrayList<Integer>(currentPermutation.subList(pos1+1, currentPermutation.size()));
            Collections.sort(tempList);
            for(int i = 0; i < tempList.size(); i++) {
                currentPermutation.set(pos1 + 1 + i, tempList.get(i));
            }
        }
        else {
            skip = false;
        }

        ArrayList<Integer> returnList = new ArrayList<Integer> (currentPermutation);

        //TODO: When you go through the entire set and the current
        // number is never less than the previous one, reset
        // the permutation to the beginning (see resetPermutation)
        boolean isDone = true;
        for(int i = currentPermutation.size()-1; i > 0; i--) {
            if(currentPermutation.get(i) > currentPermutation.get(i-1)) {
                isDone = false;
                break;
            }
        }
        if(isDone) {
            resetPermutation();
            skip = true;
        }
        

        return returnList;
    }

    private int factorial(int num) {
        int result = num;

        for(int i = result-1; i > 0; i--) {
            result *= i;
        }
        
        return result;
    }

}
