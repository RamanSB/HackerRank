/**
 * Problem: https://www.hackerrank.com/challenges/java-currency-formatter/problem
 *
 * --INPUT---
 * Input: payment, p (primitive variable of type double)
 *
 * ---OUTPUT---
 * Output:
 * US: $12,324.13
 * India: Rs.12,324.13
 * China: ￥12,324.13
 * France: 12 324,13 €
 *
 * ---CONSTRAINTS---
 * p in set of [0, 1E9]
 * 0<=p<=10**9
 */

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        //Reminder of all available Locales:
        //System.out.println(Arrays.toString(Locale.getAvailableLocales()));

        NumberFormat numberFormatUS = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("US").build());
        String us = numberFormatUS.format(payment);
        NumberFormat numberFormatIN = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = numberFormatIN.format(payment);
        NumberFormat numberFormatCN = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = numberFormatCN.format(payment);
        NumberFormat numberFormatFR = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = numberFormatFR.format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}