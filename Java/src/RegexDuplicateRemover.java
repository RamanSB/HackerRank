import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PROBLEM: https://www.hackerrank.com/challenges/duplicate-word/problem
 *
 * 1) Write a RegEx that will match any repeated word.
 * 2) Case insensitive regex.
 *
 * ---INPUT---
 * Input:
 * 5
 * Goodbye bye bye world world world
 * Sam went went to to to his business
 * Reya is is the the best player in eye eye game
 * in inthe
 * Hello hello Ab aB
 *
 * ---OUTPUT---
 * Output:
 * Goodbye bye world
 * Sam went to his business
 * Reya is the best player in eye game
 * in inthe
 * Hello Ab
 *
 * CONSTRAINTS
 * 1) s.length <= 1E4
 * 2) n [1, 100]
 */

public class RegexDuplicateRemover {

    public static void main(String[] args) {
        String regex = "\\b(\\w+)(\\s\\1\\b)*";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1)); //This replaces all strings that match the regex with the (first) matched group.
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}   