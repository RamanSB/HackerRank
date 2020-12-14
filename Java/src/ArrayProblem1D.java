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
 * Starting off by defining each form of movement: step forward/back, leap forward. Thinking of a (backed by Queue) Breadth-first-search:
 * https://www.baeldung.com/java-breadth-first-search. Need to explore all possible movements from each node/cell.
 * Also thinking that if we have a very long array (i.e. n is large) we should opt for a (backed by Stack) depth first search, which is useful
 * when the target node is far away from the source i.e. n is big.
 *
 * Approach: Attempted a Breadth First Search (Which checks each possible move after a possible move) - Uses a Queue.
 */

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
/*
2
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
 */
public class ArrayProblem1D {

    static Queue<Integer> queue = new ArrayDeque<>();

    public static boolean canWin(int leap, int[] game) {
        LocalTime startTime = LocalTime.now();
        Duration duration = Duration.ofSeconds(5);
        //Duration debugDuration = Duration.ofSeconds(60);
        System.out.println("---Starting simulation---");
        queue.add(0);
        while(!queue.isEmpty() && LocalTime.now().isBefore(startTime.plus(duration))){
            int currentNode = queue.poll();
            System.out.println("Visiting index: " + currentNode);
            if(currentNode >= game.length - 1){
                queue.clear();
                return true;
            }else{
                if(canWalkForward(game, currentNode)) queue.add(currentNode + 1);
                if(canLeapForward(game, leap, currentNode)) queue.add(currentNode + leap);
                if(canWalkBackward(game, currentNode)) queue.add(currentNode - 1);
                System.out.println("x");
            }
        }
        queue.clear();
        return false;
    }

    private static boolean canWalkForward(int[] game, int currentNode){
        if(currentNode + 1 > game.length-1){
            System.out.println("Can walk forward: " + true);
            return true;
        }
        boolean canWalkForward = game[currentNode+1] == 0;
        System.out.println("Can walk forward: " + canWalkForward);
        return canWalkForward;
    }

    private static boolean canWalkBackward(int[] game, int currentNode){
        if(currentNode - 1 < 0){
            System.out.println("Can walk backwards: " + false);
            return false;
        }
        boolean canWalkBackward = game[currentNode-1] == 0;
        System.out.println("Can walk backwards: " + canWalkBackward);
        return canWalkBackward;
    }

    private static boolean canLeapForward(int[] game, int leap, int currentNode){
        if(currentNode + leap > game.length - 1){
            System.out.println("Can leap forward: " + true);
            return true;
        }
        boolean canLeapForward = game[currentNode+leap] == 0;
        System.out.println("Can leap forward: " + canLeapForward);
        return canLeapForward;
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