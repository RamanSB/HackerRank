import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/java-regex/problem
 *
 * You need to write a regular expression and assign it to the pattern such that it can be used to validate an IP address
 *
 * ---INPUT---
 * In this problem you will be provided strings containing any combination of ASCII characters.
 * You have to write a regular expression to find the valid IPs.
 *
 * ---OUTPUT---
 * true/false
 */


public class MyRegexSolution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}



/*
A.B.C.D
let X = {A,B,C,D} - the values of X can be any values between 0 to 255 (inclusive) [0,255]

Values such as 1, 21, 9, 92, 12 (Any value up to 2 digits) can be captured by \\d{1,2}
3 Digit values starting with 0,1 or 2 can be captured by: ((0|1)\\d{2}|2[012345]{2})
3 Digit values up to 255
2([01234][0123456789]|[5][012345])
 */

class MyRegex {
    String pattern = "((\\d{1,2}.)|(((0|1)\\d{2}|2([01234][\\d]|[5][012345])).)){3}(\\d{1,2}|(((0|1)\\d{2}|2([01234][\\d]|[5][012345]))))";
}


