import java.math.BigInteger;
import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/java-primality-test/problem
 *
 * Comments: I didn't really understand the point in this question. The test cases are satisifed by simply
 * instantiating a BigInteger object & invoking isProbablePrime with any integer > 0.
 */


public class PrimalityTest {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger bigInteger = new BigInteger(n);
        System.out.println(bigInteger.isProbablePrime(1) ? "prime" : "not prime");
        scanner.close();
    }
}
