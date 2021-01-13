/**
 * Problem: https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputArg1 = scanner.nextLine();
        String inputArg2 = scanner.nextLine();
        try{
            int x = Integer.parseInt(inputArg1);
            int y = Integer.parseInt(inputArg2);
            System.out.println(x/y);
        } catch(NumberFormatException ex){
            System.out.println(new InputMismatchException());
        } catch(ArithmeticException ex){
            System.out.println(ex);
        }
    }
}