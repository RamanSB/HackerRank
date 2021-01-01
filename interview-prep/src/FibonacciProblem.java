import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Attempting to solve: https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
 *
 */
public class FibonacciProblem {

    public static int fibonacci(int n, int[] memo) {
        if(memo[n]!=0){
            return memo[n];
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        memo[n] = fibonacci(n-1, memo) + fibonacci(n-2, memo);
        return memo[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        LocalTime startTime = LocalTime.now();
        int[] memo = new int[n+1];
        System.out.println(fibonacci(n, memo));
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.format("Time taken: %f ms", (duration.getNano())/1E6);
    }
}