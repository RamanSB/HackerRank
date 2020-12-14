/**
 * Problem: https://www.hackerrank.com/challenges/java-1d-array/problem
 *
 * Consider an array of size n: begin at index 0.
 * For some index i, i [0,n):
 *  Backwards: - If index (i-1) exists and contains a 0, we can move back to array entry (cell) i-1.
 *  Forwards: - If index (i+1) exists and contains a 0, we can move forward to cell i+1.
 *            - If index (i+leap) exists and contains a 0, we can JUMP to cell (i+leap)
 *            - If at index (n-1) or (i+leap) >=n - you can walk or jump off the end of the array and win the game.
 *
 *
 * ---INPUT---
 * Input:
 * 1) q, number of function calls (queries)
 * 2) (the next 2*q lines) are split in to 2 categories:
 * a) first line: 2 space separated integers, describing n and leap
 * b) second line: n space separated integers describing the game array
 *
 * ---OUTPUT---
 * Output: YES/NO
 *
 * --Constraints--
 * q [1,5000]
 * n [2, 100]
 * leap [0,100]
 * game[0] = 0
 *
 *
 * Initial thoughts: Perhaps some form of recursive approach can be taken? Trying to identify what could be a possible base case?
 * Starting off by defining each form of movement: step forward/back, leap forward. Thinking of a Breadth-first-search:
 * https://www.baeldung.com/java-breadth-first-search. Need to explore all possible movements from each node/cell.
 */

import java.util.*;

public class ArrayProblem1D {

    static int currIdx = 0;

    public static boolean canWin(int leap, int[] game) {
       while(currIdx < game.length){

       }
    }

    private static boolean canWalkForward(int[] game){
        boolean canWalkForward = game[currIdx+1] == 0;
        currIdx = canWalkForward ? currIdx + 1 : currIdx;
        return canWalkForward;
    }

    private static boolean canWalkBackward(int[] game){
        boolean canWalkBackward = game[currIdx-1] == 0;
        currIdx = canWalkBackward ? currIdx - 1 : currIdx;
        return canWalkBackward;
    }

    private static boolean canLeapForward(int[] game, int leap){
        boolean canLeapForward = game[currIdx+leap] == 0;
        currIdx = canLeapForward ? currIdx + leap : currIdx;
        return canLeapForward;
    }

    private boolean checkIfWon(int[] game){
        return currIdx >= game.length;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}