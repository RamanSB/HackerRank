import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Problem: https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
 *
 * You have to check whether the syntax of the given pattern is valid.
 *
 * ---INPUT---
 * Input Format
 *
 * The first line of input contains an integer, N denoting the number of test cases.
 * The next N lines contain a string of any printable characters representing the pattern of a regex.
 *
 * ---OUTPUT---
 * For each test case, print Valid if the syntax of the given pattern is correct. Otherwise, print Invalid. Do not print the quotes.
 *
 * Note: In this problem, a regex is only valid if you can compile it using the Pattern.compile method.
 */
public class PatternSyntaxChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            testCases--;
            String pattern = in.nextLine();
            Consumer<String> printConsumer = System.out::println;
            String result = isRegExpSyntaxValid(pattern) ? "Valid" : "Invalid";
            printConsumer.accept(result);
        }
    }

    public static boolean isRegExpSyntaxValid(String regExp) {
        try {
            Pattern.compile(regExp);
            return true;
        } catch (PatternSyntaxException patternSyntaxException) {
            return false;
        }
    }

}
