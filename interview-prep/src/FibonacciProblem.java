/**
 * Attempting to solve: https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
 *
 */
public class FibonacciProblem {

    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args){
       System.out.println(fibonacci(3));
    }
}
