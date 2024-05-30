package cs2130;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Module6Tests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Nested
    class PermutationTest {

        @BeforeEach
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void restoreStreams() {
            System.setOut(originalOut);
        }

        @Test
        void nextPermutation1() {
            Permutation p = new Permutation(List.of(0,1,2));
            ArrayList<Integer> perm = p.getPermutation();
            assertEquals(new ArrayList(List.of(0,1,2)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,2,1)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(1,0,2)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(1,2,0)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(2,0,1)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(2,1,0)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,2)), perm);
        }

        @Test
        void nextPermutation2() {
            Permutation p = new Permutation(List.of(0,1,2,3,4,5));
            ArrayList<Integer> perm = p.getPermutation();
            assertEquals(new ArrayList(List.of(0,1,2,3,4,5)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,2,3,5,4)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,2,4,3,5)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,2,4,5,3)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,2,5,3,4)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,2,5,4,3)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,3,2,4,5)), perm);
            p.setPermutation(List.of(0,1,5,4,3,2));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,2,1,3,4,5)), perm);
            p.setPermutation(List.of(0,4,5,3,2,1));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,5,1,2,3,4)), perm);
            p.setPermutation(List.of(4,5,2,3,1,0));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(4,5,3,0,1,2)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(4,5,3,0,2,1)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(4,5,3,1,0,2)), perm);
            p.setPermutation(List.of(4,5,3,2,1,0));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(5,0,1,2,3,4)), perm);
            p.setPermutation(List.of(5,4,3,0,1,2));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(5,4,3,0,2,1)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(5,4,3,1,0,2)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(5,4,3,1,2,0)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(5,4,3,2,0,1)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(5,4,3,2,1,0)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,1,2,3,4,5)), perm);
        }

        @Test
        void nextPermutation3() {
            Permutation p = new Permutation(List.of(0,2,4,6,8,10));
            ArrayList<Integer> perm = p.getPermutation();
            assertEquals(new ArrayList(List.of(0,2,4,6,8,10)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,2,4,6,10,8)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,2,4,8,6,10)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,2,4,8,10,6)), perm);
            p.setPermutation(List.of(0,2,10,8,6,4));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,4,2,6,8,10)), perm);
            p.setPermutation(List.of(0,8,10,6,4,2));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,10,2,4,6,8)), perm);
            p.setPermutation(List.of(8,10,6,4,2,0));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(10,0,2,4,6,8)), perm);
            p.setPermutation(List.of(10,8,6,2,0,4));
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(10,8,6,2,4,0)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(10,8,6,4,0,2)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(10,8,6,4,2,0)), perm);
            perm = p.nextPermutation();
            assertEquals(new ArrayList(List.of(0,2,4,6,8,10)), perm);
        }


        @Test
        void printAllPermutations() {
            Permutation p = new Permutation(List.of(1, 2, 3));
            p.printAllPermutations();
            assertEquals("[1, 2, 3]" + System.getProperty("line.separator") +
                    "[1, 3, 2]" + System.getProperty("line.separator") +
                    "[2, 1, 3]" + System.getProperty("line.separator") +
                    "[2, 3, 1]" + System.getProperty("line.separator") +
                    "[3, 1, 2]" + System.getProperty("line.separator") +
                    "[3, 2, 1]" +  System.getProperty("line.separator"), outContent.toString());
            outContent.reset();
        }
    }

    @Nested
    class CombinationTest {


        @BeforeEach
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterEach
        public void restoreStreams() {
            System.setOut(originalOut);
        }


        @Test
        void nextCombination1() {
            ArrayList<Integer> values = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                values.add(i);
            }
            Combination c = new Combination(values, 5);
            ArrayList<Integer> combo = c.getCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 3, 4)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 3, 5)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 3, 6)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 3, 7)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 3, 8)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 3, 9)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 4, 5)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 4, 6)), combo);
            c.setCombination(List.of(0, 1, 2, 4, 9));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 5, 6)), combo);
            c.setCombination(List.of(0, 1, 2, 8, 9));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 3, 4, 5)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 3, 4, 6)), combo);
            c.setCombination(List.of(0, 6, 7, 8, 9));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(1, 2, 3, 4, 5)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(1, 2, 3, 4, 6)), combo);
            c.setCombination(List.of(4, 5, 7, 8, 9));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(4, 6, 7, 8, 9)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(5, 6, 7, 8, 9)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 1, 2, 3, 4)), combo);
        }


        @Test
        void nextCombination2() {
            ArrayList<Integer> values = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                values.add(i * 2);
            }
            Combination c = new Combination(values, 5);
            ArrayList<Integer> combo = c.getCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 6, 8)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 6, 10)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 6, 12)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 6, 14)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 6, 16)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 6, 18)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 8, 10)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 8, 12)), combo);
            c.setCombination(List.of(0, 2, 4, 8, 18));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 10, 12)), combo);
            c.setCombination(List.of(0, 2, 4, 16, 18));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 6, 8, 10)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 6, 8, 12)), combo);
            c.setCombination(List.of(0, 12, 14, 16, 18));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(2, 4, 6, 8, 10)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(2, 4, 6, 8, 12)), combo);
            c.setCombination(List.of(8, 10, 14, 16, 18));
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(8, 12, 14, 16, 18)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(10, 12, 14, 16, 18)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0, 2, 4, 6, 8)), combo);
        }


        @Test
        void nextCombination3() {
            ArrayList<Integer> values = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                values.add(i);
            }
            Combination c = new Combination(values, 1);
            ArrayList<Integer> combo = c.getCombination();
            assertEquals(new ArrayList(List.of(0)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(1)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(2)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(3)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(4)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(5)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(6)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(7)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(8)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(9)), combo);
            combo = c.nextCombination();
            assertEquals(new ArrayList(List.of(0)), combo);
        }

        @Test
        void printAllCombinations() {
            Combination c = new Combination(List.of(1, 2, 3, 4, 5), 2);
            c.printAllCombinations();
            assertEquals("[1, 2]" + System.getProperty("line.separator") +
                    "[1, 3]" + System.getProperty("line.separator") +
                    "[1, 4]" + System.getProperty("line.separator") +
                    "[1, 5]" + System.getProperty("line.separator") +
                    "[2, 3]" + System.getProperty("line.separator") +
                    "[2, 4]" + System.getProperty("line.separator") +
                    "[2, 5]" + System.getProperty("line.separator") +
                    "[3, 4]" + System.getProperty("line.separator") +
                    "[3, 5]" + System.getProperty("line.separator") +
                    "[4, 5]" + System.getProperty("line.separator"), outContent.toString());
            outContent.reset();
            c = new Combination(List.of(1, 2, 3, 4, 5), 3);
            c.printAllCombinations();
            assertEquals("[1, 2, 3]" + System.getProperty("line.separator") +
                    "[1, 2, 4]" + System.getProperty("line.separator") +
                    "[1, 2, 5]" + System.getProperty("line.separator") +
                    "[1, 3, 4]" + System.getProperty("line.separator") +
                    "[1, 3, 5]" + System.getProperty("line.separator") +
                    "[1, 4, 5]" + System.getProperty("line.separator") +
                    "[2, 3, 4]" + System.getProperty("line.separator") +
                    "[2, 3, 5]" + System.getProperty("line.separator") +
                    "[2, 4, 5]" + System.getProperty("line.separator") +
                    "[3, 4, 5]" + System.getProperty("line.separator"), outContent.toString());
        }
    }
}