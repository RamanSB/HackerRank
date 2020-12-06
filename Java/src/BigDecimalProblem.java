/**
 * Problem: https://www.hackerrank.com/challenges/java-bigdecimal/problem
 *
 * ---INPUT---
 * Input:
 * 1) single integer, n, denoting the number of integer strings.
 * 2) Each subsequent line i denotes a number within the array s, (element si).
 *
 * ---OUTPUT---
 * Output: Reordered elements of inputted values in an array.
 *
 * Constraints:
 * n [1,200]
 * each array element has at most 300 digits.
 */

import java.math.BigDecimal;
import java.util.*;

public class BigDecimalProblem{
    public static void main(String []args){
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n+2];
        for(int i=0; i<n; i++){
            s[i] = sc.next();
        }
        sc.close();

        BigDecimal[] bigDecimals = new BigDecimal[n];


        //Output
        for(int i=0; i<n; i++) {
            bigDecimals[i] = new BigDecimal(s[i]);
        }
        Collections.sort(Arrays.asList(bigDecimals));

        for(int i=0; i<n; i++){
            System.out.println(bigDecimals[i].toString());
        }
    }
}