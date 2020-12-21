/**
 * Problem: https://www.hackerrank.com/challenges/java-exception-handling/problem
 *
 * Input:
 * n & p (both integers)
 *
 * Constraints
 * n, p [-10, 10]
 *
 * Comments: Ideally should really be using IllegalArguemtnException for these kind of validations on the parameters.
 */
import java.util.Scanner;

class MyCalculator {
    /*
     * Create the method long power(int, int) here.
     */
    long power(int n, int p) throws Exception {
        if(n<0 || p<0) throw new Exception("n or p should not be negative.");
        if(n==0 & p==0) throw new Exception("n and p should not be zero.");
        return (long) Math.pow(n, p);
    }

}

public class Solution {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}