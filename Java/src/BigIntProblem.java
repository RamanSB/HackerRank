import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/java-biginteger/problem
 *
 * BigInteger class is used to deal with the mathematical operations on numbers that are far greater than Integer.MAX_VALUE
 * BigInteger allocates memory dynamically depending on the String value passed to the BigInteger constructor.
 * The constraints on memory are limited to that of the constraints on the heap space allocated XmX (maximum heap space)
 *
 */
public class BigIntProblem {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            BigInteger a, b;
            a = new BigInteger(input.nextLine());
            b = new BigInteger(input.nextLine());

            System.out.println(a.add(b));
            System.out.println(a.multiply(b));
        }
}
